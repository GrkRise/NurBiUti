package com.rizzhivaykini.nurbiuti.Adapters;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rizzhivaykini.nurbiuti.Entities.Bubble;
import com.rizzhivaykini.nurbiuti.R;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

import static com.rizzhivaykini.nurbiuti.R.color.colorPrimary;

/**
 * Created by GrkRise on 14.07.2016.
 */

public class BubblesCardAdapter extends RecyclerView.Adapter<BubblesCardAdapter.BubblesViewHolder> {
    private List<Bubble> bubbles;

    public BubblesCardAdapter(List<Bubble> bubbles){
        this.bubbles = bubbles;
    }

    @Override
    public BubblesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.bubble_card, parent, false);




        return new BubblesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BubblesViewHolder holder, int position) {
        Bubble bubble = bubbles.get(position);
        holder.textView_title.setText(bubble.getTitle());
    }

    @Override
    public int getItemCount() {
        return bubbles.size();
    }

    public static class BubblesViewHolder extends RecyclerView.ViewHolder{

        protected TextView textView_title;

        public BubblesViewHolder(View itemView) {
            super(itemView);

            textView_title = (TextView) itemView.findViewById(R.id.title_bubble);
            Random random = new Random();
            TypedArray backs = itemView.getResources().obtainTypedArray(R.array.backs);
            textView_title.setBackground(backs.getDrawable(random.nextInt(backs.length())));


        }
    }
}
