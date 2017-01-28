package com.dabe.skyapp.model.data.bo;

import android.os.Parcel;
import android.os.Parcelable;

import com.dabe.skyapp.model.data.enums.CodeTypeEnum;

/**
 * Created by Daniil Belevtsev on 28.01.2017 1:23.
 * Project: SkyApp; Skype: pandamoni1
 */

public class RecipientBO implements Parcelable {

    private CodeTypeEnum codeType;
    private String recipient;
    private String recipientLogin;

    public RecipientBO(CodeTypeEnum codeType, String recipient, String recipientLogin) {
        this.codeType = codeType;
        this.recipient = recipient;
        this.recipientLogin = recipientLogin;
    }

    public String getRecipient() {
        return recipient;
    }

    public CodeTypeEnum getCodeType() {
        return codeType;
    }

    public String getRecipientLogin() {
        return recipientLogin;
    }

    protected RecipientBO(Parcel in) {
        codeType = (CodeTypeEnum) in.readValue(CodeTypeEnum.class.getClassLoader());
        recipient = in.readString();
        recipientLogin = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(codeType);
        dest.writeString(recipient);
        dest.writeString(recipientLogin);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<RecipientBO> CREATOR = new Parcelable.Creator<RecipientBO>() {
        @Override
        public RecipientBO createFromParcel(Parcel in) {
            return new RecipientBO(in);
        }

        @Override
        public RecipientBO[] newArray(int size) {
            return new RecipientBO[size];
        }
    };
}