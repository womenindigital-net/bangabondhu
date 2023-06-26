package com.womenindigital.staytuned.Model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("id") private String id;
    @SerializedName("caption") private String caption;

    public String getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }
}
