package com.hanif.adminapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("value")
    String value;

    @SerializedName("message")
    String message;

    @SerializedName("id_level")
    String idLevel;

    @SerializedName("result")
    List<Stuff> result;

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

    public String getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(String idLevel) {
        this.idLevel = idLevel;
    }

    public List<Stuff> getResult() {
        return result;
    }

    public void setResult(List<Stuff> result) {
        this.result = result;
    }
}
