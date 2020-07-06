package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.bt_1);
        final TextView tv = findViewById(R.id.tv_1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("I feel confused!");
            }
        });
        Log.i("button set", "onCreate: btn set");
        Switch sw1 = findViewById(R.id.switch_1);
        final ImageView imv=findViewById(R.id.im_1);
        sw1.setChecked(TRUE);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    imv.setVisibility(VISIBLE);//这个函数可以设置image是否显示
                }else {//图片变为不显示，并关闭音乐
                    imv.setVisibility(INVISIBLE);
                    player.release();
                }
            }
        });
        Log.i("switch set", "onCreate: switch set");
        player= MediaPlayer.create(this, R.raw.dbz);
        //循环播放
        //player.setLooping(true);
        // //播放
        player.start();
    }

}