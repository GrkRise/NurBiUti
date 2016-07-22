package com.rizzhivaykini.nurbiuti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rizzhivaykini.nurbiuti.Classes.Cheeses;
import com.rizzhivaykini.nurbiuti.R;

import java.util.List;

/**
 * Created by GrkRise on 08.07.2016.
 */

public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {
    private final TypedValue typedValue = new TypedValue();
    private int mBackground;
    private List<String> mValues;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mBoundString = mValues.get(position);
        holder.textView.setText(mValues.get(position));
        Glide.with(holder.imageView.getContext())
                .load(Cheeses.getRandomCheesesDrawable())
                .fitCenter()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public String getValueAt(int position){
        return mValues.get(position);
    }

    public SimpleStringRecyclerViewAdapter(Context context, List<String> mValues) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        this.mValues = mValues;

        this.mBackground = typedValue.resourceId;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String mBoundString;

        public final View view;
        public final ImageView imageView;
        public final TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = (ImageView) view.findViewById(R.id.avatar);
            textView = (TextView) view.findViewById(R.id.service);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textView.getText();
        }
    }
}
