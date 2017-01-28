package com.dabe.skyapp.model.api.interfaces;

import com.dabe.skyapp.model.data.dto.response.Response;

import rx.Observable;

/**
 * Created by Daniil Belevtsev on 25.01.2017 20:55.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface ISkyApi {
    /**
     * Запрос на быстрый логин
     *
     * @param email - мыло юзера
     * @return возвращает AuthTokenDTO
     */
    Observable<Response> easyLogin(String email);
    Observable<Response> hardLogin(String email, String password);
    Observable<Response> verifyCode(String code, String authToken);
    Observable<Response> syncData(String appToken);
}
