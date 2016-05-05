package com.kokushiseiya.tree;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Firebase mRootRef;
    private String userName;
    private Fragment horizontalFragment;
    private Fragment verticalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // firebaseの設定
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase(BuildConfig.FIREBASE_URL);

        // Loginで設定したuser情報を取得
        SharedPreferences data = getSharedPreferences("USERDATA", Context.MODE_PRIVATE);
        userName = data.getString("USERNAME", null);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (verticalFragment == null) {
            verticalFragment = new VerticalFragment();
        }
        fragmentTransaction.replace(R.id.fragment_container, verticalFragment);
        fragmentTransaction.commit();

    }

        /**
         * 画面回転を検出
         */
        @Override
        public void onConfigurationChanged(Configuration newConfig) {

            // Fragmentの動的追加
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (newConfig.orientation) {
                case Configuration.ORIENTATION_PORTRAIT:  // 縦長


                    if (verticalFragment == null) {
                        verticalFragment = new VerticalFragment();
                    }
                    fragmentTransaction.replace(R.id.fragment_container, verticalFragment);
                    fragmentTransaction.commit();

                    break;
                case Configuration.ORIENTATION_LANDSCAPE:  // 横長

                    if (horizontalFragment == null) {
                        horizontalFragment = new HorizontalFragment();
                    }
                    fragmentTransaction.replace(R.id.fragment_container, horizontalFragment);
                    fragmentTransaction.commit();

                    break;
                default:
                    break;
            }
            super.onConfigurationChanged(newConfig);
        }







}