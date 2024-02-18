package com.example.finalproject.BottomNavigationBar.Authentication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.finalproject.BottomNavigationBar.BottomNavigationActivity;
import com.example.finalproject.BottomNavigationBar.Home.HomeFragment;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText loginEmail, loginPassword;
    TextView signupRedirectText;
    Button loginButton;
    public static String PREFS_NAME = "MyPrefsFile";


    SharedPreferences mySavedData;
    SharedPreferences.Editor mySavedDataEditor;


    ImageView btn_google;
    FirebaseDatabase database;
    GoogleSignInClient googleSignInClient;
    int RC_SIGN_IN = 20;
    FirebaseAuth authh;
    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if(o.getResultCode() == RESULT_OK){
                Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(o.getData());
                try{
                    GoogleSignInAccount signInAccount = accountTask.getResult(ApiException.class);
                    AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                    authh.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                authh = FirebaseAuth.getInstance();
                                loginEmail.setText(authh.getCurrentUser().getEmail());
                                loginPassword.setText(authh.getCurrentUser().getDisplayName());
                                Toast.makeText(LoginActivity.this, "successfully", Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(LoginActivity.this, "failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                } catch (ApiException e) {
                   e.printStackTrace();
                }
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);

        auth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signup_redirect_text);
        btn_google = findViewById(R.id.iv_google);


        database = FirebaseDatabase.getInstance();


       /* GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);*/

        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleLogin();
            }
        });

        mySavedData = getSharedPreferences("mySavedDataFile" , MODE_PRIVATE);
        mySavedDataEditor = mySavedData.edit();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                     if(!password.isEmpty()){
                         auth.signInWithEmailAndPassword(email , password)
                                 .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                     @Override
                                     public void onSuccess(AuthResult authResult) {

                                         SharedPreferences preferences = getSharedPreferences(LoginActivity.PREFS_NAME, 0);
                                         SharedPreferences.Editor editor = preferences.edit();
                                         editor.putBoolean("hasLoggedIn", true);
                                         editor.apply();

                                         Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                         startActivity(new Intent(LoginActivity.this , BottomNavigationActivity.class));
                                         finish();
                                     }
                                 }).addOnFailureListener(new OnFailureListener() {
                                     @Override
                                     public void onFailure(@NonNull Exception e) {
                                         Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                     }
                                 });
                     }else{
                         loginPassword.setError("Password can not be empty ");
                     }
                }else if(email.isEmpty()){
                    loginEmail.setError("Email can not be empty");
                }else{
                    loginEmail.setError("Please Enter Valid Email");
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , SignUpActivity.class));
            }
        });
    }

    private void googleLogin() {
        Intent intent = googleSignInClient.getSignInIntent();
        startActivityForResult(intent , RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);


            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuth(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken,null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();

                            HashMap<String, Object> map = new HashMap<>();
                            map.put("id" , user.getUid());
                            map.put("name" , user.getDisplayName());
                            map.put("profile" , user.getPhotoUrl());

                            database.getReference().child("users").child(user.getUid()).setValue(map);

                            Intent intent = new Intent(LoginActivity.this , HomeFragment.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}