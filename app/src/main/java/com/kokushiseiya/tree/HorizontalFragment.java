package com.kokushiseiya.tree;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class HorizontalFragment extends Fragment {

    private FeatureCoverFlow ideaFlow;
    private DataAdapter adapter;
    private ArrayList<Idea> ideas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingDummyData();
        ideaFlow = (FeatureCoverFlow)getActivity().findViewById(R.id.ideaflow);
        adapter = new DataAdapter(getActivity(), ideas);
        ideaFlow.setAdapter(adapter);
        ideaFlow.setOnScrollPositionListener(onScrollListener());
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
            Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
            Log.i("MainActivity", "scrolling");
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_horizontal, container, false);
    }

    private void settingDummyData() {
        User user1 = new User("fukai");
        User user2 = new User("ronn");
        User user3 = new User("kuroko");
        User user4 = new User("ziaru");

        ideas = new ArrayList<>();
        ideas.add(new Idea(user1, "hellow world", 4, false));
        ideas.add(new Idea(user2, "hellow world!", 4, false));
        ideas.add(new Idea(user3, "hellow world", 4, false));
        ideas.add(new Idea(user4, "hellow world!", 4, false));
    }
}
