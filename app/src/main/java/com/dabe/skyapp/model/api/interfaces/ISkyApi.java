package com.dabe.skyapp.model.api.interfaces;

import com.dabe.skyapp.model.data.dto.response.Response;

import rx.Observable;

/**
 * Created by Daniil Belevtsev on 25.01.2017 20:55.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface ISkyApi {
    /**
     * Запрос на код без пароля
     *
     * @param email - мыло юзера
     * @return возвращает AuthTokenDTO
     */
    Observable<Response> easyLogin(String email);

    /**
     * Запрос на логин с паролем
     *
     * @param email    - мыло
     * @param password - пасс
     * @return возвращает AppTokenDTO
     */
    Observable<Response> hardLogin(String email, String password);

    /**
     * Проверка пина по authToken, который получили при запросе кода
     * @param code - введенный код
     * @param authToken - временный токен авторизации
     * @return возвращает AppTokenDTO
     */
    Observable<Response> verifyCode(String code, String authToken);

    /**
     * Синхронизация данных с сервером
     * @param appToken - токен приложения
     * @return какае-нибудь данные
     */
    Observable<Response> syncData(String appToken);
}
