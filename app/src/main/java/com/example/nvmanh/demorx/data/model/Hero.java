package com.example.nvmanh.demorx.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Hero implements Serializable{
    @SerializedName("ma")
    @Expose
    private String mId;
    @SerializedName("ten1")
    @Expose
    private String mName1;
    @SerializedName("ten2")
    @Expose
    private String mName2;
    @SerializedName("anhDaiDien")
    @Expose
    private String mAvatar;
    @SerializedName("truyenThuyet")
    @Expose
    private String mHistory;

    public Hero() {
    }

    public Hero(String id, String name1, String name2, String avatar, String history) {
        mId = id;
        mName1 = name1;
        mName2 = name2;
        mAvatar = avatar;
        mHistory = history;
    }

    public String getId() {
        return mId;
    }

    public String getName1() {
        return mName1;
    }

    public String getName2() {
        return mName2;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public String getHistory() {
        return mHistory;
    }
}