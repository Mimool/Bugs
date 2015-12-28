package com.mimool.bugs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mimool.bugs.R;

import java.util.ArrayList;
import java.util.Collections;

public class HouseActivity extends AppCompatActivity {

    final int imgBtnIdList[] = {
            R.id.imgbtn_kitchen,
            R.id.imgbtn_bedroom,
            R.id.imgbtn_toilet,
            R.id.imgbtn_pipe
    };

    ArrayList<TextView> imgBtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        imgBtns = new ArrayList<>();

        Collections.addAll(imgBtns, getBtnList());

        addTouchListener();
    }

    private TextView[] getBtnList() {
        TextView[] tvList = new TextView[imgBtnIdList.length];
        Toast.makeText(getApplicationContext(), "" + tvList.length, Toast.LENGTH_SHORT).show();
        for(int i=0; i<imgBtnIdList.length; i++) {
            tvList[i] = (TextView)findViewById(imgBtnIdList[i]);
        }
        return tvList;
    }

    private View.OnTouchListener activityChange = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Intent intent = new Intent(HouseActivity.this, BugListActivity.class);
            int index = imgBtns.indexOf(v);
            intent.putExtra("location_id", index);
            startActivity(intent);
            return false;
        }
    };

    private void addTouchListener() {
        for(int i=0; i<imgBtns.size(); i++) {
            imgBtns.get(i).setOnTouchListener(activityChange);
    }
    }
}
