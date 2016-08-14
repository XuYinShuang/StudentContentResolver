package com.zhiyuan3g.studentcontentresolver.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhiyuan3g.studentcontentresolver.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnInsert:
                intent = new Intent();
                intent.setClass(MainActivity.this, InsertActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnDelete:
                intent = new Intent();
                intent.setClass(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnUpdate:
                intent = new Intent();
                intent.setClass(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnQuery:
                intent = new Intent();
                intent.setClass(MainActivity.this, SelectActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}