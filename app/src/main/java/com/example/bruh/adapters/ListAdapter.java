package com.example.bruh.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bruh.R;

import java.io.IOException;
import java.lang.reflect.Field;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.UserViewHolder> {
    static int counter=0;
    static Context context;
    static Field[] fields = R.raw.class.getFields();
    static MediaPlayer mediaPlayer=new MediaPlayer();
    public ListAdapter(Context context){
        this.context=context;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new UserViewHolder(view);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        try {
            holder.bind();
            counter++;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public int getItemCount() {
        return R.raw.class.getFields().length;
    }
    static class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView play;
        ImageView fav;
        TextView nameView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            play=itemView.findViewById(R.id.play);
            fav=itemView.findViewById(R.id.fav);
            nameView=itemView.findViewById(R.id.name);
        }

        public void bind() throws IllegalAccessException, IOException {
                @RawRes int rawId = (Integer)fields[counter].get(null);
                String name = fields[counter].getName();
                Log.e("COUNTER", String.valueOf(counter));
                Log.e("rawId", String.valueOf(rawId));
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mediaPlayer.isPlaying()){
                            try {
                                mediaPlayer.reset();
                                mediaPlayer.setDataSource(context,Uri.parse("android.resource://com.example.bruh/raw/"+rawId));
                                mediaPlayer.prepareAsync();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        else {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            try {
                                mediaPlayer.setDataSource(context,Uri.parse("android.resource://com.example.bruh/raw/"+rawId));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mediaPlayer.prepareAsync();
                        }
                    }
                });
                fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO
                    }
                });
                nameView.setText(name);


        }


    }
}
