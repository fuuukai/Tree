package com.kokushiseiya.tree;

import android.widget.BaseAdapter;

<<<<<<< HEAD
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
=======
import android.app.Fragment;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
>>>>>>> 9a2ebe413e36a9104e2b77bc7bc96ca405b8ad5f
import android.widget.TextView;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Created by fukai on 16/05/04.
 */
public class DataAdapter extends BaseAdapter {


    private ArrayList<Idea> data;
    private AppCompatActivity activity;

    public DataAdapter(AppCompatActivity context, ArrayList<Idea> objects) {
        this.activity = context;
        this.data = objects;
=======
 * アダプター
 */
public class DataAdapter extends BaseAdapter {

    private ArrayList<Idea> data;
    private AppCompatActivity activity;

    private static class ViewHolder {
        private TextView ideaTitle;
        private TextView ideaNote;
        private TextView editer;
        private TextView likeNum;
        private ImageButton likeButton;
        private ImageButton closeButton;

        public ViewHolder(View view) {
            ideaTitle = (TextView) view.findViewById(R.id.titleText);
            ideaNote = (TextView) view.findViewById(R.id.textBox);
            editer = (TextView) view.findViewById(R.id.userName);
            likeNum = (TextView) view.findViewById(R.id.likeNum);
            likeButton = (ImageButton) view.findViewById(R.id.like);
            closeButton = (ImageButton) view.findViewById(R.id.closed);
        }
    }

    public DataAdapter(AppCompatActivity context, ArrayList<Idea> objects) {
        activity = context;
        data = objects;
>>>>>>> 9a2ebe413e36a9104e2b77bc7bc96ca405b8ad5f
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Idea getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
<<<<<<< HEAD

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.card, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.gameImage.setImageResource(data.get(position).getImageSource());
        viewHolder.gameName.setText(data.get(position).getName());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_game_info);
                dialog.setCancelable(true); // dimiss when touching outside
                dialog.setTitle("Idea Details");

                TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(getItem(position).getName());
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(getItem(position).getImageSource());

                dialog.show();
            }
        };
    }


    private static class ViewHolder {



        private TextView gameName;
        private ImageView gameImage;

        public ViewHolder(View v) {
            gameImage = (User) v.findViewById(R.id.image);
            gameName = (TextView) v.findViewById(R.id.name);
        }
    }
}

=======
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.card, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ideaTitle.setText("");
        viewHolder.ideaNote.setText("");
        viewHolder.likeNum.setText("");
        viewHolder.editer.setText("");
        viewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        viewHolder.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
>>>>>>> 9a2ebe413e36a9104e2b77bc7bc96ca405b8ad5f
