package com.imgod.gaokang.testrealm.model;

import io.realm.RealmObject;

/**
 * 项目名称：TestRealm
 * 包名称：com.imgod.gaokang.testrealm.model
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-05-27 11:55
 * 修改人：gaokang
 * 修改时间：2016-05-27 11:55
 * 修改备注：
 */
public class RealmString extends RealmObject {
    private String thing;

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
