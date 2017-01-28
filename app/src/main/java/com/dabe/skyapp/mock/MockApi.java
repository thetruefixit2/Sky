package com.dabe.skyapp.mock;

import com.dabe.skyapp.model.api.interfaces.ISkyApi;
import com.dabe.skyapp.model.data.dto.response.AppTokenDTO;
import com.dabe.skyapp.model.data.dto.response.AuthTokenDTO;
import com.dabe.skyapp.model.data.dto.response.ProductsDTO;
import com.dabe.skyapp.model.data.dto.response.Response;
import com.dabe.skyapp.model.data.enums.ErrorTypesEnum;
import com.dabe.skyapp.utils.RandomUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * /**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 * <p>
 * Класс заменяющий стандартный ретрофит.
 * Серилизацию и десериализацию делать не стал, но в dto показал, что мог бы :)
 * Интернет мокаю криво, так как не хотелось сюда пробрасывать контекст, чтобы реальное соединение смотреть.
 * А в презентерах было бы некрасиво :(
 */

public class MockApi implements ISkyApi {

    @Override
    public Observable<Response> easyLogin(String email) {
        boolean isInternetAvailable = mockInternetLost();
        if (email.equals(MockData.USER_EASY) && isInternetAvailable) {
            return mockDelay()
                    .map(aLong
                            -> new Response.Builder()
                            .result(new AuthTokenDTO.Builder().mockSuccess())
                            .errorMessage("")
                            .statusCode(200)
                            .build());


        } else {
            if (!isInternetAvailable) {
                return generateSomeError(ErrorTypesEnum.INTERNET);
            } else {
                return generateSomeError(ErrorTypesEnum.EMAIL);
            }
        }
    }

    @Override
    public Observable<Response> hardLogin(String email, String password) {
        boolean isInternetAvailable = mockInternetLost();
        if (email.equals(MockData.USER_HARD) && password.equals(MockData.USER_PASSWORD) && isInternetAvailable) {
            return mockDelay()
                    .map(aLong
                            -> new Response.Builder()
                            .result(new AppTokenDTO.Builder().mockSuccess())
                            .errorMessage("")
                            .statusCode(200)
                            .build()); // return appToken
        } else {
            if (!isInternetAvailable) {
                return generateSomeError(ErrorTypesEnum.INTERNET);
            } else {
                return generateSomeError(ErrorTypesEnum.EMAIL_PASSWORD);
            }
        }
    }


    @Override
    public Observable<Response> verifyCode(String code, String authToken) {
        boolean isInternetAvailable = mockInternetLost();
        if (authToken.equals(MockData.AUTH_TOKEN) && code.equals(MockData.PHONE_CODE) && isInternetAvailable) {
            return mockDelay()
                    .map(aLong
                            -> new Response.Builder()
                            .result(new AppTokenDTO.Builder().mockSuccess())
                            .errorMessage("")
                            .statusCode(200)
                            .build()); // return appToken
        } else {
            if (!isInternetAvailable) {
                return generateSomeError(ErrorTypesEnum.INTERNET);
            } else {
                return generateSomeError(ErrorTypesEnum.CODE);
            }
        }
    }

    @Override
    public Observable<Response> syncData(String appToken) {
        boolean isInternetAvailable = mockInternetLost();
        if (appToken.equals(MockData.APP_TOKEN) && isInternetAvailable) {
            return mockDelay()
                    .map(aLong
                            -> new Response.Builder()
                            .result(new ProductsDTO())
                            .errorMessage("")
                            .statusCode(200)
                            .build());
        } else {
            if (!isInternetAvailable) {
                return generateSomeError(ErrorTypesEnum.INTERNET);
            } else {
                return generateSomeError(ErrorTypesEnum.TOKEN);
            }
        }
    }

    /**
     * Процедура генерации задержки для моков
     */
    private Observable<Long> mockDelay() {
        int delay = RandomUtils.getMockRandomDelay(); // рандомим задержку
        return Observable.interval(1, TimeUnit.SECONDS) // создаем интервал с задержкой в 1 секунду
                .filter(aLong -> aLong == delay); // пропускаем элементы, пока не получим наш delay
    }

    /**
     * Процедура генерации отсутствия инета
     */
    private boolean mockInternetLost() {
        return RandomUtils.getMockRandomUnavailable() % 3 != 0; // если троичка, то будет на инет валиться. Испытай свою удачу :)
    }

    private Observable<Response> generateSomeError(ErrorTypesEnum errorType) {
        return mockDelay()
                .map(new Func1<Long, Response>() {
                    @Override
                    public Response call(Long aLong) {
                        throw new ResponseException(errorType);
                    }
                });
    }

}
