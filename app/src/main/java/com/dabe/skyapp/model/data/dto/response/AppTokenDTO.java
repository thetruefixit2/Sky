package com.dabe.skyapp.model.data.dto.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:23.
 * Project: SkyApp; Skype: pandamoni1
 */

public class AppTokenDTO extends ResponseDataDTO {

    @Expose
    @SerializedName("customer_id")
    private long customerId;

    @Expose
    @SerializedName("token")
    private String token;

    public long getCustomerId() {
        return customerId;
    }

    public String getToken() {
        return token;
    }
}
