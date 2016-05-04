package com.kokushiseiya.tree;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class VerticalFragment extends Fragment implements View.OnClickListener{

    private ListView listView;
    private DataAdapter adapter;
    private ArrayList<Idea> ideas;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
        listView = (ListView) getActivity().findViewById(R.id.listView);
        adapter = new DataAdapter(getActivity(), ideas);
        listView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vertical, container, false);
    }

    @Override
    public void onClick(View v) {
        // 押下時の処理
        Log.d("fukai", "fukai");
    }



    private void setData() {
        User user1 = new User("fukai");
        User user2 = new User("ronn");
        User user3 = new User("kuroko");
        User user4 = new User("ziaru");

        ideas = new ArrayList<>();

        ideas.add(new Idea(user1, "hellow world", 4, false));
        ideas.add(new Idea(user2, "hellow world!", 4, false));
        ideas.add(new Idea(user3, "hellow world", 4, false));
        ideas.add(new Idea(user4, "hellow world!", 4, false));
        ideas.add(new Idea(user4, "hellow world!", 4, false));
        ideas.add(new Idea(user4, "hellow world!", 4, false));

    }
}