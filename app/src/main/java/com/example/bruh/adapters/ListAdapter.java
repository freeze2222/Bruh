package com.example.bruh.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bruh.MainActivity;
import com.example.bruh.R;

import java.io.IOException;
import java.lang.reflect.Field;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.UserViewHolder> {
    static Button[] buttons;
    int counter=0;
    @SuppressLint("StaticFieldLeak")
    static Context context;
    static Field[] fields = R.raw.class.getFields();
    static MediaPlayer mediaPlayer=new MediaPlayer();
    String[] nameTable;
    @SuppressLint("NotifyDataSetChanged")
    public ListAdapter(Context context, String[] nameTable){
        ListAdapter.context =context;
        this.nameTable=nameTable;
        this.notifyDataSetChanged();
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
    class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView play;
        ImageView fav;
        TextView nameView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            play=itemView.findViewById(R.id.play);
            fav=itemView.findViewById(R.id.fav);
            nameView=itemView.findViewById(R.id.name);

        }

        @SuppressLint("ClickableViewAccessibility")
        public void bind() throws IllegalAccessException{
                @RawRes int rawId = (Integer)fields[counter].get(null);
                String name = fields[counter].getName();
                Log.e("COUNTER", String.valueOf(counter));
                Log.e("rawId", String.valueOf(rawId));
                mediaPlayer.setOnPreparedListener(MediaPlayer::start);
                play.setOnClickListener(view -> {
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
                });
                fav.setOnClickListener(view -> {
                    LayoutInflater inflater = (LayoutInflater)
                            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.popup_choose_window, null);

                    int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    int height = LinearLayout.LayoutParams.WRAP_CONTENT;

                    final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

                    popupWindow.setAnimationStyle(R.style.popup_window_animation);
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                    popupView.setOnTouchListener((View v, @SuppressLint("ClickableViewAccessibility") MotionEvent event) -> {
                        popupWindow.dismiss();
                        return true;
                    });
                    buttons= new Button[]{
                            popupView.findViewById(R.id.bp1),
                            popupView.findViewById(R.id.bp2),
                            popupView.findViewById(R.id.bp3),
                            popupView.findViewById(R.id.bp4),
                            popupView.findViewById(R.id.bp5),
                            popupView.findViewById(R.id.bp6),
                            popupView.findViewById(R.id.bp7),
                            popupView.findViewById(R.id.bp8),
                            popupView.findViewById(R.id.bp9),
                            popupView.findViewById(R.id.bp10)
                    };
                    for (int i = 0; i < 10; i++) {
                        int finalI = i;
                        buttons[i].setOnClickListener(view1 -> {
                            SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(context);
                            SharedPreferences.Editor editor = saved_values.edit();
                            editor.putInt("b"+ finalI, rawId);
                            editor.putInt("mpb"+ finalI, -1);
                            editor.apply();
                            popupWindow.dismiss();
                        });
                        SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(context);
                        int res = saved_values.getInt("b"+ i, -1);
                        if (res!=-1){
                            buttons[i].setText(nameTable[i]);
                        }
                        else {
                            Uri uri=Uri.parse(saved_values.getString("mpb"+i,"null"));
                            if (uri!=null){
                                buttons[i].setText(nameTable[i]);

                            }
                        }
                    }

                });
            nameView.setText(name);
        }
    }
}
