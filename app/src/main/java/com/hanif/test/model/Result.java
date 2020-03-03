package com.hanif.test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("value")
    String value;

    @SerializedName("message")
    String message;

    @SerializedName("result")
    List<Auction> result;

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

    public List<Auction> getResult() {
        return result;
    }

    public void setResult(List<Auction> result) {
        this.result = result;
    }
}
