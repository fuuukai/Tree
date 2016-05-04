package com.kokushiseiya.tree;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class BlankFragment extends Fragment {

    private FeatureCoverFlow coverFlow;
    private DataAdapter adapter;
    private ArrayList<Idea> ideas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        settingDummyData();
        adapter = new DataAdapter(this, ideas);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }



}
