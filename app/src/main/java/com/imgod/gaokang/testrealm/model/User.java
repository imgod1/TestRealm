package com.imgod.gaokang.testrealm.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by imgod on 2016/5/26.
 */
public class User extends RealmObject {
    private String name;
    private int age;
    @PrimaryKey
    private int id;

    private RealmList<RealmString> thingList;

    public RealmList<RealmString> getThingList() {
        return thingList;
    }

    public void setThingList(RealmList<RealmString> thingList) {
        this.thingList = thingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", thingList=" + thingList.size() +
                '}';
    }
}
