package net.capsulestudio.jsonparsingdemo.Model;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("message")
    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
