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

    Button addOrRemove;
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

    public static final String EXTRA_MEAL_DETAILS = "mealDetails";

    //MealsRepositoryImp repo;
    private static final String TAG = "MealScreenActivity";
   // RecyclerView recyclerView;
   // MealScreenAdapter mealScreenAdapter;

    //MealPresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_screen);
        addOrRemove = findViewById(R.id.btn_add_fav_or_remove_meal_of_category);
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


        Intent intent = getIntent();
        intent.hasExtra(EXTRA_MEAL_DETAILS);
        Log.i(TAG, "daily object" + intent.hasExtra(EXTRA_MEAL_DETAILS));


        Meal meal = (Meal) intent.getSerializableExtra(EXTRA_MEAL_DETAILS);
        if(meal != null){
            mealDetails(meal);
            Log.i(TAG, "onCreate: thhhhhhhhhhhhhhhhhhh");
        }
        addOrRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOrRemove.setTag("Remove");
                Log.i(TAG, "onClick: button");
            }
        });





/*
    @Override
    public void removeMeal(Meal meals) {
        favoritePresenterImp.removeFromFav(meals);
    }

    @Override
    public void allMeals(List<Meal> meals) {
        favoriteAdapter.setList(meals);
        favoriteAdapter.notifyDataSetChanged();

    }
         */



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
        String videoUrl = convertToEmbeddedUrl(url); // Replace VIDEO_ID with the actual video ID or embed URL
        String video="<iframe width='400' height=\"200\" src= '"+videoUrl+"' title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        mealVideo.getSettings().setJavaScriptEnabled(true); // Enable JavaScript (required for video playback)
        mealVideo.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                adjustIframeWidth(view);
            }
        });
        mealVideo.loadData(video, " text/html", "utf-8"); // Load the HTML content into the WebView

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

/*
package com.example.foodplanner.Meals.view;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;
import com.example.foodplanner.model.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MealDetailsActivity extends AppCompatActivity {
    private static final String TAG = "MealDetailsActivity";
    ImageView mealImage;
    TextView mealName;
    TextView mealArea;
    TextView mealCategory;
    TextView mealDrink;
    TextView mealInstructions;
    TextView mealIngredient1;
    TextView mealIngredient2;
    TextView mealIngredient3;
    TextView mealIngredient4;
    TextView mealIngredient5;
    TextView mealIngredient6;
    TextView mealIngredient7;
    TextView mealIngredient8;
    TextView mealIngredient9;
    TextView mealIngredient10;
    TextView mealIngredient11;
    TextView mealIngredient12;
    TextView mealIngredient13;
    TextView mealIngredient14;
    TextView mealIngredient15;
    TextView mealIngredient16;
    TextView mealIngredient17;
    TextView mealIngredient18;
    TextView mealIngredient19;
    TextView mealIngredient20;
    TextView mealYoutube;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        mealImage = findViewById(R.id.iv_strMealThumb);
        mealName = findViewById(R.id.tv_strMeal);
        mealArea = findViewById(R.id.tv_strArea);
        mealCategory =findViewById(R.id.tv_strCategory);
        mealDrink = findViewById(R.id.tv_strDrinkAlternate);
        mealInstructions = findViewById(R.id.tv_strInstructions);
        mealIngredient1 = findViewById(R.id.tv_strIngredient1);
        mealIngredient2 = findViewById(R.id.tv_strIngredient2);
        mealIngredient3 = findViewById(R.id.tv_strIngredient3);
        mealIngredient4 = findViewById(R.id.tv_strIngredient4);
        mealIngredient5 = findViewById(R.id.tv_strIngredient5);
        mealIngredient6 = findViewById(R.id.tv_strIngredient6);
        mealIngredient7 = findViewById(R.id.tv_strIngredient7);
        mealIngredient8 = findViewById(R.id.tv_strIngredient8);
        mealIngredient9 = findViewById(R.id.tv_strIngredient9);
        mealIngredient10 = findViewById(R.id.tv_strIngredient10);
        mealIngredient11 = findViewById(R.id.tv_strIngredient11);
        mealIngredient12 = findViewById(R.id.tv_strIngredient12);
        mealIngredient13 = findViewById(R.id.tv_strIngredient13);
        mealIngredient14 = findViewById(R.id.tv_strIngredient14);
        mealIngredient15 = findViewById(R.id.tv_strIngredient15);
        mealIngredient16 = findViewById(R.id.tv_strIngredient16);
        mealIngredient17 = findViewById(R.id.tv_strIngredient17);
        mealIngredient18 = findViewById(R.id.tv_strIngredient18);
        mealIngredient19 = findViewById(R.id.tv_strIngredient19);
        mealIngredient20 = findViewById(R.id.tv_strIngredient20);
        mealYoutube = findViewById(R.id.tv_strYoutube);

        Intent intent1 = getIntent();
        Log.i(TAG, "daily object" + intent1.hasExtra("mealDetailsObject"));

        Meal randomMeal = (Meal) intent1.getSerializableExtra("mealDetailsObject");
        Log.i(TAG, "on card" + randomMeal);
        if (randomMeal != null) {
            setMealDetails(randomMeal);
        }
    }
    public void setMealDetails(Meal meal) {
        Glide.with(this).load(meal.getStrMealThumb()).into(mealImage);
        mealName.setText(meal.getStrMeal());
        mealArea.setText(meal.getStrArea());
        mealCategory.setText(meal.getStrCategory());
        mealDrink.setText(meal.getStrDrinkAlternate());

        String currentInstructions = mealInstructions.getText().toString();
        String newInstructions = currentInstructions + "\n\n" + meal.getStrInstructions();
        mealInstructions.setText(newInstructions);

        String currentIngredient1 = mealIngredient1.getText().toString();
        String newIngredient1 = currentIngredient1 + "  " + meal.getStrIngredient1();
        mealIngredient1.setText(newIngredient1);

        String currentIngredient2 = mealIngredient2.getText().toString();
        String newIngredient2 = currentIngredient2 + "  " + meal.getStrIngredient2();
        mealIngredient2.setText(newIngredient2);

        String currentIngredient3 = mealIngredient3.getText().toString();
        String newIngredient3 = currentIngredient3 + "  " + meal.getStrIngredient3();
        mealIngredient3.setText(newIngredient3);

        String currentIngredient4 = mealIngredient4.getText().toString();
        String newIngredient4 = currentIngredient4 + "  " + meal.getStrIngredient4();
        mealIngredient4.setText(newIngredient4);

        String currentIngredient5 = mealIngredient5.getText().toString();
        String newIngredient5 = currentIngredient5 + "  " + meal.getStrIngredient5();
        mealIngredient5.setText(newIngredient5);

        String currentIngredient6 = mealIngredient6.getText().toString();
        String newIngredient6 = currentIngredient6 + "  " + meal.getStrIngredient6();
        mealIngredient6.setText(newIngredient6);

        String currentIngredient7 = mealIngredient7.getText().toString();
        String newIngredient7 = currentIngredient7 + "  " + meal.getStrIngredient7();
        mealIngredient7.setText(newIngredient7);

        String currentIngredient8 = mealIngredient8.getText().toString();
        String newIngredient8 = currentIngredient8 + "  " + meal.getStrIngredient8();
        mealIngredient8.setText(newIngredient8);

        String currentIngredient9 = mealIngredient9.getText().toString();
        String newIngredient9 = currentIngredient9 + "  " + meal.getStrIngredient9();
        mealIngredient9.setText(newIngredient9);

        String currentIngredient10 = mealIngredient10.getText().toString();
        String newIngredient10 = currentIngredient10 + "  " + meal.getStrIngredient10();
        mealIngredient10.setText(newIngredient10);

        String currentIngredient11 = mealIngredient11.getText().toString();
        String newIngredient11 = currentIngredient11 + "  " + meal.getStrIngredient11();
        mealIngredient11.setText(newIngredient11);

        String currentIngredient12 = mealIngredient12.getText().toString();
        String newIngredient12 = currentIngredient12 + "  " + meal.getStrIngredient12();
        mealIngredient12.setText(newIngredient12);

        String currentIngredient13 = mealIngredient13.getText().toString();
        String newIngredient13 = currentIngredient13 + "  " + meal.getStrIngredient13();
        mealIngredient13.setText(newIngredient13);

        String currentIngredient14 = mealIngredient14.getText().toString();
        String newIngredient14 = currentIngredient14 + "  " + meal.getStrIngredient14();
        mealIngredient14.setText(newIngredient14);

        String currentIngredient15 = mealIngredient15.getText().toString();
        String newIngredient15 = currentIngredient15 + "  " + meal.getStrIngredient15();
        mealIngredient15.setText(newIngredient15);

        String currentIngredient16 = mealIngredient16.getText().toString();
        String newIngredient16 = currentIngredient16 + "  " + meal.getStrIngredient16();
        mealIngredient16.setText(newIngredient16);

        String currentIngredient17 = mealIngredient17.getText().toString();
        String newIngredient17 = currentIngredient17 + "  " + meal.getStrIngredient17();
        mealIngredient17.setText(newIngredient17);

        String currentIngredient18 = mealIngredient18.getText().toString();
        String newIngredient18 = currentIngredient18 + "  " + meal.getStrIngredient18();
        mealIngredient18.setText(newIngredient18);

        String currentIngredient19 = mealIngredient19.getText().toString();
        String newIngredient19 = currentIngredient19 + "  " + meal.getStrIngredient19();
        mealIngredient19.setText(newIngredient19);

        String currentIngredient20 = mealIngredient20.getText().toString();
        String newIngredient20 = currentIngredient20 + "  " + meal.getStrIngredient20();
        mealIngredient20.setText(newIngredient20);

        String currentMealYoutube = mealYoutube.getText().toString();
        String newMealYoutube= currentMealYoutube + "  " + meal.getStrYoutube();
        mealYoutube.setText(newMealYoutube);
    }
}
 */