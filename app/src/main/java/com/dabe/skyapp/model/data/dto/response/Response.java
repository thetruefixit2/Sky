package com.dabe.skyapp.model.data.dto.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:00.
 * Project: SkyApp; Skype: pandamoni1
 */

public class Response {
    @Expose
    @SerializedName("result")
    private ResponseDataDTO result;
    @Expose
    @SerializedName("error")
    private String errorMessage;
    @Expose
    @SerializedName("status_code")
    private int statusCode;

    public ResponseDataDTO getResult() {
        return result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
