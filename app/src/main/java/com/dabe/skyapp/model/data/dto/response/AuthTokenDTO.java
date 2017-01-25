package com.dabe.skyapp.model.data.dto.response;

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
    @SerializedName("auth_token")
    private String token;

    public CodeTypeEnum getCodeType() {
        return codeType;
    }

    public String getToken() {
        return token;
    }
}
