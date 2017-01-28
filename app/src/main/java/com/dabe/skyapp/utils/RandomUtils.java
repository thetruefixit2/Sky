package com.dabe.skyapp.utils;

import java.util.Random;

/**
 * Created by Daniil Belevtsev on 28.01.2017 0:27.
 * Project: SkyApp; Skype: pandamoni1
 */

public class RandomUtils {

    public static int getMockRandomDelay() {
        Random r = new Random();
        return r.nextInt(5 - 2) + 2;
    }

    public static int getMockRandomUnavailable() {
        Random r = new Random();
        return r.nextInt(5 - 2) + 2;
    }

}
