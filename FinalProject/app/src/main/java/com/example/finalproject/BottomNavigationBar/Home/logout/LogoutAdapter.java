package com.example.finalproject.BottomNavigationBar.Home.logout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

public class LogoutAdapter extends RecyclerView.Adapter<LogoutAdapter.ViewHolder> {
    private Context context;
    private OnLogoutClickListener listener;
    private static final String TAG = "LogoutAdapter";
    public LogoutAdapter(Context _context , OnLogoutClickListener _listener){
        this.context = _context;
        this.listener = _listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logoutImage;
        public LinearLayout linearLayout;
        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            logoutImage = v.findViewById(R.id.iv_logout);

            linearLayout = v.findViewById(R.id.ll_top_part);

        }
    }
}


/*
public class RandomMealsAdapter extends RecyclerView.Adapter<RandomMealsAdapter.ViewHolder> {
    private List<Meal> randomMeals;
    private Context context;
    private OnMealClickListener listener;

    private static final String TAG = "RandomMealsAdapter";
    public RandomMealsAdapter(List<Meal> _randomMeals, Context _context , OnMealClickListener _listener){
        this.randomMeals = _randomMeals;
        this.context = _context;
        this.listener = _listener;
        //randomMeals = new ArrayList<Meal>();
    }

    public void setMeal(List<Meal> meals) {
        this.randomMeals = meals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_random_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomMealsAdapter.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");

        Meal current = randomMeals.get(position);
        Glide.with(context).load(current.getStrMealThumb()).into(holder.randomImage);
        holder.randomName.setText(current.getStrMeal());
        holder.addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMealClick(current);
            }
        });

        /*
         holder.btnAddToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAllProdClick(current);
            }
        });
         */
/*
    }

@Override
public int getItemCount() {
        return randomMeals.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {
    ImageView randomImage;

    TextView randomName;
    Button addFav;
    public LinearLayout linearLayout;
    public View layout;

    public ViewHolder(@NonNull View v) {
        super(v);
        layout = v;
        randomImage = v.findViewById(R.id.iv_rand_meal);
        randomName = v.findViewById(R.id.tv_random_category);
        addFav = v.findViewById(R.id.btn_add_fav_rand);
        linearLayout = v.findViewById(R.id.ll_random_row);

    }
}
}
 */