package com.example.finalproject.BottomNavigationBar.MealScreen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.finalproject.R;
import com.example.finalproject.model.Meal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MealScreenActivity extends AppCompatActivity{

    ImageView mealImage;
    TextView mealName , mealCountry;
    WebView mealVideo;
    TextView ingred1;
    TextView ingred2;
    TextView ingred3;
    TextView ingred4;
    TextView ingred5;
    TextView ingred6;
    TextView ingred7;
    TextView ingred8;
    TextView ingred9;
    TextView ingred10;
    TextView ingred11;
    TextView ingred12;
    TextView ingred13;
    TextView ingred14;
    TextView ingred15;
    TextView ingred16;
    TextView ingred17;
    TextView ingred18;
    TextView ingred19;
    TextView ingred20;



    TextView messure1;
    TextView messure2;
    TextView messure3;
    TextView messure4;
    TextView messure5;
    TextView messure6;
    TextView messure7;
    TextView messure8;
    TextView messure9;
    TextView messure10;
    TextView messure11;
    TextView messure12;
    TextView messure13;
    TextView messure14;
    TextView messure15;
    TextView messure16;
    TextView messure17;
    TextView messure18;
    TextView messure19;
    TextView messure20;


    TextView structure;


    public static final String EXTRA_MEAL_DETAILS = "mealDetails";

    private static final String TAG = "MealScreenActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_screen);
        mealImage = findViewById(R.id.iv_each_meal);
        mealName = findViewById(R.id.tv_each_meal);
        mealCountry = findViewById(R.id.tv_country_of_meal);
        mealVideo = findViewById(R.id.videoView);
        ingred1 = findViewById(R.id.tv_ingred1);
        ingred2 = findViewById(R.id.tv_ingred2);
        ingred3 = findViewById(R.id.tv_ingred3);
        ingred4 = findViewById(R.id.tv_ingred4);
        ingred5 = findViewById(R.id.tv_ingred5);
        ingred6 = findViewById(R.id.tv_ingred6);
        ingred7 = findViewById(R.id.tv_ingred7);
        ingred8 = findViewById(R.id.tv_ingred8);
        ingred9 = findViewById(R.id.tv_ingred9);
        ingred10 = findViewById(R.id.tv_ingred10);
        ingred11 = findViewById(R.id.tv_ingred11);
        ingred12 = findViewById(R.id.tv_ingred12);
        ingred13 = findViewById(R.id.tv_ingred13);
        ingred14 = findViewById(R.id.tv_ingred14);
        ingred15 = findViewById(R.id.tv_ingred15);
        ingred16 = findViewById(R.id.tv_ingred16);
        ingred17 = findViewById(R.id.tv_ingred17);
        ingred18 = findViewById(R.id.tv_ingred18);
        ingred19 = findViewById(R.id.tv_ingred19);
        ingred20 = findViewById(R.id.tv_ingred20);


        messure1 = findViewById(R.id.tv_mess1);
        messure2 = findViewById(R.id.tv_mess2);
        messure3 = findViewById(R.id.tv_mess3);
        messure4 = findViewById(R.id.tv_mess4);
        messure5 = findViewById(R.id.tv_mess5);
        messure6 = findViewById(R.id.tv_mess6);
        messure7 = findViewById(R.id.tv_mess7);
        messure8 = findViewById(R.id.tv_mess8);
        messure9 = findViewById(R.id.tv_mess9);
        messure10 = findViewById(R.id.tv_mess10);
        messure11 = findViewById(R.id.tv_mess11);
        messure12 = findViewById(R.id.tv_mess12);
        messure13 = findViewById(R.id.tv_mess13);
        messure14 = findViewById(R.id.tv_mess14);
        messure15 = findViewById(R.id.tv_mess15);
        messure16 = findViewById(R.id.tv_mess16);
        messure17 = findViewById(R.id.tv_mess17);
        messure18 = findViewById(R.id.tv_mess18);
        messure19 = findViewById(R.id.tv_mess19);
        messure20 = findViewById(R.id.tv_mess20);

        structure = findViewById(R.id.tv_structt_body);




        Intent intent = getIntent();
        intent.hasExtra(EXTRA_MEAL_DETAILS);
        Log.i(TAG, "daily object" + intent.hasExtra(EXTRA_MEAL_DETAILS));


        Meal meal = (Meal) intent.getSerializableExtra(EXTRA_MEAL_DETAILS);
        if(meal != null){
            mealDetails(meal);
            Log.i(TAG, "onCreate: thhhhhhhhhhhhhhhhhhh");
        }

    }

    public void mealDetails(Meal meal) {
        Glide.with(this).load(meal.getStrMealThumb()).into(mealImage);
        mealName.setText(meal.getStrMeal());
        mealCountry.setText(meal.getStrArea());
        ingred1.setText(meal.getStrIngredient1());
        ingred2.setText(meal.getStrIngredient2());
        ingred3.setText(meal.getStrIngredient3());
        ingred4.setText(meal.getStrIngredient4());
        ingred5.setText(meal.getStrIngredient5());
        ingred6.setText(meal.getStrIngredient6());
        ingred7.setText(meal.getStrIngredient7());
        ingred8.setText(meal.getStrIngredient8());
        ingred9.setText(meal.getStrIngredient9());
        ingred10.setText(meal.getStrIngredient10());
        ingred11.setText(meal.getStrIngredient11());
        ingred12.setText(meal.getStrIngredient12());
        ingred13.setText(meal.getStrIngredient13());
        ingred14.setText(meal.getStrIngredient14());
        ingred15.setText(meal.getStrIngredient15());
        ingred16.setText(meal.getStrIngredient16());
        ingred17.setText(meal.getStrIngredient17());
        ingred18.setText(meal.getStrIngredient18());
        ingred19.setText(meal.getStrIngredient19());
        ingred20.setText(meal.getStrIngredient20());


        messure1.setText(meal.getStrMeasure1());
        messure2.setText(meal.getStrMeasure2());
        messure3.setText(meal.getStrMeasure3());
        messure4.setText(meal.getStrMeasure4());
        messure5.setText(meal.getStrMeasure5());
        messure6.setText(meal.getStrMeasure6());
        messure7.setText(meal.getStrMeasure7());
        messure8.setText(meal.getStrMeasure8());
        messure9.setText(meal.getStrMeasure9());
        messure10.setText(meal.getStrMeasure10());
        messure11.setText(meal.getStrMeasure11());
        messure12.setText(meal.getStrMeasure12());
        messure13.setText(meal.getStrMeasure13());
        messure14.setText(meal.getStrMeasure14());
        messure15.setText(meal.getStrMeasure15());
        messure16.setText(meal.getStrMeasure16());
        messure17.setText(meal.getStrMeasure17());
        messure18.setText(meal.getStrMeasure18());
        messure19.setText(meal.getStrMeasure19());
        messure20.setText(meal.getStrMeasure20());

        structure.setText(meal.getStrInstructions());


        if(meal.getStrYoutube() != null){
            setMealVideo(meal.getStrYoutube());
        }



    }
    public static String convertToEmbeddedUrl(String youtubeUrl) {
        String videoId = extractVideoId(youtubeUrl);
        return "https://www.youtube.com/embed/" + videoId;
    }

    private static String extractVideoId(String youtubeUrl) {
        String videoId = null;
        String regex = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%2Fvideos%2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(youtubeUrl);
        if (matcher.find()) {
            videoId = matcher.group();
        }

        return videoId;
    }
    public void setMealVideo(String url)
    {
        Log.d("TAG", "setMealVideo: width " +mealVideo.getX());
        String videoUrl = convertToEmbeddedUrl(url);
        String video="<iframe width='400' height=\"200\" src= '"+videoUrl+"' title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        mealVideo.getSettings().setJavaScriptEnabled(true);
        mealVideo.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                adjustIframeWidth(view);
            }
        });
        mealVideo.loadData(video, " text/html", "utf-8");

    }
    private void adjustIframeWidth(WebView webView) {
        webView.evaluateJavascript("javascript:(function() { " +
                "var iframes = document.getElementsByTagName('iframe');" +
                "for (var i = 0; i < iframes.length; i++) {" +
                "    var iframe = iframes[i];" +
                "    iframe.style.width = '100%';" +
                "}})();", null);
    }


}

