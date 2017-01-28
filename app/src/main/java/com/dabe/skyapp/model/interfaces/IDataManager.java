package com.dabe.skyapp.model.interfaces;

import com.dabe.skyapp.model.data.dto.response.AppTokenDTO;
import com.dabe.skyapp.model.data.dto.response.AuthTokenDTO;
import com.dabe.skyapp.model.data.dto.response.ProductsDTO;

import rx.Observable;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface IDataManager {
    Observable<AuthTokenDTO> postEasyLogin(String email);

    Observable<AppTokenDTO> postHardLogin(String email, String password);

    Observable<AppTokenDTO> postVerifyCode(String code, String authToken);

    Observable<ProductsDTO> postSyncData(String token);


}
