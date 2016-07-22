package com.rizzhivaykini.nurbiuti.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rizzhivaykini.nurbiuti.Adapters.SimpleStringRecyclerViewAdapter;
import com.rizzhivaykini.nurbiuti.Classes.Cheeses;
import com.rizzhivaykini.nurbiuti.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by GrkRise on 13.07.2016.
 */

public class PagerFragment extends Fragment {

    public static PagerFragment newInstance(){
        Bundle args = new Bundle();

        PagerFragment pagerFragment = new PagerFragment();
        pagerFragment.setArguments(args);
        return pagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        setupRecyclerView(recyclerView);
        return root;
    }

    public void setupRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
                getRandomSubList(Cheeses.sCheeseString, 30)));
    }

    private List<String> getRandomSubList(String[] strings, int amount){
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount){
            list.add(strings[random.nextInt(strings.length)]);
        }
        return list;
    }
}
