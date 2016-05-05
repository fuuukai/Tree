package com.kokushiseiya.tree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    ImageView closeButton;
    EditText mIdea;
    TextView username;

    public static Intent createIntent(Context context){
        Intent intent = new Intent(context, NewActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.close_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        closeButton = (ImageView)findViewById(R.id.new_close);
        mIdea = (EditText) findViewById(R.id.new_idea);
        username = (TextView) findViewById(R.id.new_user);

        //ログインしているアカウント情報をusernameに表示
        SharedPreferences data = getSharedPreferences("key", Context.MODE_PRIVATE);
        username.setText(data.getString("userName_key", null));
    }


    public void handin(View v){
        //データ保存...未完了
/*        Intent intent = getIntent();
        if(intent != null){
            String str = intent.getStringExtra("parentidea");

            //データをstrの子として割り振ったParentIdeaを持たせておく


        }*/



        //スクロール画面に戻る
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        this.finish();
    }

    public void close(View v){
        //スクロール画面に戻る
        this.finish();
    }


}