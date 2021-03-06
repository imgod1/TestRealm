package com.imgod.gaokang.testrealm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.imgod.gaokang.testrealm.model.RealmString;
import com.imgod.gaokang.testrealm.model.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_add, txt_del, txt_update, txt_query, txt_result;
    private Realm realm;

    private int id;

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
        txt_result = (TextView) findViewById(R.id.txt_result);
        realm = Realm.getInstance(new RealmConfiguration.Builder(MainActivity.this
        ).name("kk.realm").build());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_add:
                Toast.makeText(MainActivity.this, "txt_add", Toast.LENGTH_SHORT).show();
                realmAdd();
//                id++;
                break;
            case R.id.txt_del:
                Toast.makeText(MainActivity.this, "txt_del", Toast.LENGTH_SHORT).show();
                realmDelete();
                break;
            case R.id.txt_update:
                Toast.makeText(MainActivity.this, "txt_update", Toast.LENGTH_SHORT).show();
                realmUpdate();
                break;
            case R.id.txt_query:
                Toast.makeText(MainActivity.this, "txt_query", Toast.LENGTH_SHORT).show();
                realmQuery();
                break;
        }
    }

    private void realmAdd() {
        Log.e("realmAdd", "id:" + id);
        //这是推荐做法, realm.createObject()不好用.有默认值容易出错
        User user = new User();
        user.setId(id++);
        user.setName("kk0");
        user.setAge(20);
        RealmList<RealmString> list = new RealmList<>();
        for (int i = 0; i < id; i++) {
            RealmString thing = new RealmString();
            thing.setThing("xxx");
            list.add(thing);
        }
        user.setThingList(list);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    private void realmDelete() {
        realm.beginTransaction();
        realm.where(User.class).equalTo("id", 0).findFirst().deleteFromRealm();
        realm.commitTransaction();
    }

    private void realmUpdate() {
        //这种更新也可以,但是太费劲
//        User user = new User();
//        user.setId(1);
//        user.setName("gaokang");
//        user.setAge(888);

        //还是这种更新比较轻松
        realm.beginTransaction();
        // realm.copyToRealmOrUpdate(user);
        realm.where(User.class).equalTo("id", 1).findFirst().setName("gaokang");
        realm.commitTransaction();
    }

    private void realmQuery() {
        //beginsWith("name", "kk")
        List<User> userList = realm.where(User.class).findAllSorted("id", Sort.ASCENDING);
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : userList) {
            Log.e("realmQuery", user.toString());
            stringBuilder.append(user.toString() + "\n");
        }
        txt_result.setText(stringBuilder.toString());
    }

}
