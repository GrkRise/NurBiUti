package com.rizzhivaykini.nurbiuti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jakewharton.salvage.RecyclingPagerAdapter;
import com.rizzhivaykini.nurbiuti.utils.ListUtils;

import java.util.List;

/**
 * Created by GrkRise on 18.07.2016.
 */

public class ImagePagerAdapter extends RecyclingPagerAdapter {
    private Context context;
    private List<Integer> imageIdList;
    private int size;

    private boolean isInfinityLoop;

    public ImagePagerAdapter(Context context, List<Integer> imageIdList){
        this.context = context;
        this.imageIdList = imageIdList;
        this.size = ListUtils.getSize(imageIdList);
        this.isInfinityLoop = false;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = holder.imageView = new ImageView(context);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(imageIdList.get(getPosition(position)));
        return convertView;
    }

    @Override
    public int getCount() {
        return isInfinityLoop ? Integer.MAX_VALUE : ListUtils.getSize(imageIdList);
    }

    public int getPosition(int position){
        return isInfinityLoop ? position % size : position;
    }

    private static class ViewHolder{
        ImageView imageView;
    }


    public boolean isInfinityLoop() {
        return isInfinityLoop;
    }

    public ImagePagerAdapter setInfiniteLoop(boolean isInfinityLoop){
        this.isInfinityLoop = isInfinityLoop;
        return this;
    }

}
