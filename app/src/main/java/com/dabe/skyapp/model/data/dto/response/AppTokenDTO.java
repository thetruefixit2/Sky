package com.dabe.skyapp.model.data.dto.response;

import com.dabe.skyapp.mock.MockData;
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

    private AppTokenDTO(Builder builder) {
        customerId = builder.customerId;
        token = builder.token;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getToken() {
        return token;
    }


    public static final class Builder {
        private long customerId;
        private String token;

        public Builder() {
        }

        public Builder customerId(long val) {
            customerId = val;
            return this;
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public AppTokenDTO build() {
            return new AppTokenDTO(this);
        }

        public AppTokenDTO mockSuccess() {
            customerId(MockData.CUSTOMER_ID);
            token(MockData.APP_TOKEN);
            return new AppTokenDTO(this);
        }
    }
}
