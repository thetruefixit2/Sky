package com.dabe.skyapp.model.api;

import com.dabe.skyapp.model.api.interfaces.ISkyApi;
import com.dabe.skyapp.model.data.dto.response.Response;
import com.dabe.skyapp.utils.MockData;

import rx.Observable;

/**
 /**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 *
 * Класс заменяющий стандартный ретрофит.
 * Серилизацию и десериализацию делать не стал, но в dto показал, что мог бы :)
 */

public class MockApi implements ISkyApi {

    @Override
        public Observable<Response> easyLogin(String email) {
            if(email.equals(MockData.USER_EASY)) {
                return null; // return authToken + codeType
            } else {
                return generateSomeError();
            }
        }

        @Override
        public Observable<Response> hardLogin(String email, String password) {
            if(email.equals(MockData.USER_HARD) && password.equals(MockData.USER_PASSWORD)) {
                return null; // return appToken
            } else {
                return generateSomeError();
            }
        }


    @Override
    public Observable<Response> verifyCode(String code, String authToken) {
        if(authToken.equals(MockData.AUTH_TOKEN) && code.equals(MockData.SMS_CODE)) {
            return null; // return appToken
        } else {
            return generateSomeError();
        }
    }

    @Override
    public Observable<Response> syncData(String appToken) {
        return null; // return some data
    }


    private Observable<Response> generateSomeError() {
        return null;
    }

}
