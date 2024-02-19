package com.example.finalproject.BottomNavigationBar.MealsOfCountry.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.BottomNavigationBar.MealScreen.view.MealScreenActivity;
import com.example.finalproject.R;
import com.example.finalproject.StartActivity;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

import java.util.List;

public class MealsOfCountryAdapter extends RecyclerView.Adapter<MealsOfCountryAdapter.ViewHolder> {
    private List<Meal> meals;
    private Context context;
    OnMealCountClickListener listener;
    private static final String TAG = "MealsOfCountryAdapter";

    public static final String EXTRA_MEAL_DETAILS = "mealDetails";
    MealPlan plan = new MealPlan();

    public MealsOfCountryAdapter(List<Meal> meal, Context context , OnMealCountClickListener listener) {
        this.meals = meal;
        this.context = context;
        this.listener = listener;
    }

    public void setList(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.meal_of_list_of_country_card, parent, false);

        MealsOfCountryAdapter.ViewHolder viewHolder = new MealsOfCountryAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meal current = meals.get(position);
        Glide.with(context).load(current.getStrMealThumb()).into(holder.mealImage);
        holder.mealName.setText(current.getStrMeal());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MealScreenActivity.class);
                intent.putExtra(EXTRA_MEAL_DETAILS, current);
                Log.i(TAG, "onClick: in random" + intent.hasExtra(EXTRA_MEAL_DETAILS));
                context.startActivity(intent);
            }
        });
        holder.addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StartActivity.iisGuest == true){
                    Toast.makeText(context, "You Cant Add To Plan", Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Select Day of the Week");

                    final String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                    builder.setItems(daysOfWeek, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int selectedDay = which + 1; // Days in SQLite are typically 1-based
                            if (selectedDay == 1) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Sunday");
                                listener.addMealToPlan(plan);

                            } else if (selectedDay == 2) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Monday");
                                listener.addMealToPlan(plan);

                            } else if (selectedDay == 3) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Tuesday");
                                listener.addMealToPlan(plan);
                            } else if (selectedDay == 4) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Wednesday");
                                listener.addMealToPlan(plan);
                            } else if (selectedDay == 5) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Thursday");
                                listener.addMealToPlan(plan);
                            } else if (selectedDay == 6) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Friday");
                                listener.addMealToPlan(plan);
                            } else if (selectedDay == 7) {
                                plan.setIdMeal(current.getIdMeal());
                                plan.setStrMeal(current.getStrMeal());
                                plan.setStrArea(current.getStrArea());
                                plan.setStrCategory(current.getStrCategory());
                                plan.setStrIngredient1(current.getStrIngredient1());
                                plan.setStrIngredient2(current.getStrIngredient2());
                                plan.setStrIngredient3(current.getStrIngredient3());
                                plan.setStrIngredient4(current.getStrIngredient4());
                                plan.setStrIngredient5(current.getStrIngredient5());
                                plan.setStrIngredient6(current.getStrIngredient6());
                                plan.setStrIngredient7(current.getStrIngredient7());
                                plan.setStrIngredient8(current.getStrIngredient8());
                                plan.setStrIngredient9(current.getStrIngredient9());
                                plan.setStrIngredient10(current.getStrIngredient10());
                                plan.setStrIngredient11(current.getStrIngredient11());
                                plan.setStrIngredient12(current.getStrIngredient12());
                                plan.setStrIngredient13(current.getStrIngredient13());
                                plan.setStrIngredient14(current.getStrIngredient14());
                                plan.setStrYoutube(current.getStrYoutube());
                                plan.setDayMeal("Saturday");
                                listener.addMealToPlan(plan);
                            }
                        }
                    });

                    builder.show();
                }
            }
        });


        Log.i(TAG, "onBindViewHolder: ");


    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mealImage;
        TextView mealName;

        LinearLayout linearLayout;
        public View layout;
        public CardView cardView;
        Button addPlan;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            mealImage = v.findViewById(R.id.iv_meal_loco);
            mealName = v.findViewById(R.id.tv_meal_loco);
            linearLayout = v.findViewById(R.id.ll_of_loco_meals);
            cardView = v.findViewById(R.id.card_meal_loco);
            addPlan = v.findViewById(R.id.btn_add_plan_cout);
        }
    }
}

