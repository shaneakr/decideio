package com.example.kingroberson.decideio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by dummy on 17/01/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private final int VIEW_TYPE_RANK = 2;
    LayoutInflater inflater;
    private Context context;
    public ArrayList<String> currentList;
    String questions;




    public RecyclerAdapter(Context context, String questions) {
        // super(context, R.circular_textview1.mains_row_layout, test_codes);
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.questions = questions;

    }

    @Override
    public int getItemViewType(int position) {

        return VIEW_TYPE_ITEM;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.card_view_item, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            return itemViewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        if (holder1 instanceof ItemViewHolder) {
            ItemViewHolder holder = (ItemViewHolder) holder1;
            try {
                JSONObject jsonObject = new JSONObject(questions);
                JSONArray questions = jsonObject.getJSONArray("questions");
                JSONObject ques = questions.getJSONObject(position);

                holder.questionText.setText(ques.getString("question"));
                holder.answer1Text.setText(ques.getString("answer1"));
                holder.answer2Text.setText(ques.getString("answer2"));
                holder.answer3Text.setText(ques.getString("answer3"));

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }

    }


    @Override
    public int getItemCount() {
        try {
            JSONObject jsonObject = new JSONObject(questions);
            JSONArray questions = jsonObject.getJSONArray("questions");
            return questions.length();
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }



    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView questionText;
        TextView answer1Text;
        TextView answer2Text;
        TextView answer3Text;




        public ItemViewHolder(View itemView) {
            super(itemView);

            questionText = (TextView) (itemView.findViewById(R.id.questionTV));
            answer1Text = (TextView) (itemView.findViewById(R.id.answer1TV));
            answer2Text = (TextView) (itemView.findViewById(R.id.answer2TV));
            answer3Text = (TextView) (itemView.findViewById(R.id.answer3TV));

        }
    }
}
