package com.dabe.skyapp.model.data.dto.response;

import com.dabe.skyapp.mock.MockData;
import com.dabe.skyapp.model.data.enums.CodeTypeEnum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:08.
 * Project: SkyApp; Skype: pandamoni1
 */

public class AuthTokenDTO extends ResponseDataDTO {

    @Expose
    @SerializedName("code_type")
    private CodeTypeEnum codeType;

    @Expose
    @SerializedName("recipient")
    private String recipient;

    @Expose
    @SerializedName("auth_token")
    private String token;

    private AuthTokenDTO(Builder builder) {
        codeType = builder.codeType;
        token = builder.token;
        recipient = builder.recipient;
    }

    public CodeTypeEnum getCodeType() {
        return codeType;
    }

    public String getToken() {
        return token;
    }

    public String getRecipient() {
        return recipient;
    }

    public static final class Builder {
        private CodeTypeEnum codeType;
        private String token;
        private String recipient;

        public Builder() {
        }

        public Builder codeType(CodeTypeEnum val) {
            codeType = val;
            return this;
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Builder recipient(String val) {
            recipient = val;
            return this;
        }

        public AuthTokenDTO build() {
            return new AuthTokenDTO(this);
        }

        public AuthTokenDTO mockSuccess() {
            codeType(CodeTypeEnum.PHONE);
            token(MockData.AUTH_TOKEN);
            recipient(MockData.PHONE_NUMBER);
            return new AuthTokenDTO(this);
        }
    }
}
