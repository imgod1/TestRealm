package com.imgod.gaokang.testrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_add, txt_del, txt_update, txt_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        txt_add.setOnClickListener(this);
        txt_del.setOnClickListener(this);
        txt_update.setOnClickListener(this);
        txt_query.setOnClickListener(this);
    }

    private void initView() {
        txt_add = (TextView) findViewById(R.id.txt_add);
        txt_del = (TextView) findViewById(R.id.txt_del);
        txt_update = (TextView) findViewById(R.id.txt_update);
        txt_query = (TextView) findViewById(R.id.txt_query);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_add:
                Toast.makeText(MainActivity.this, "txt_add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_del:
                Toast.makeText(MainActivity.this, "txt_del", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_update:
                Toast.makeText(MainActivity.this, "txt_update", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_query:
                Toast.makeText(MainActivity.this, "txt_query", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
