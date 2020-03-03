package com.hanif.adminapp.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("value")
    String value;

    @SerializedName("message")
    String message;

//    @SerializedName("result")
//    List<Auction> result;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
