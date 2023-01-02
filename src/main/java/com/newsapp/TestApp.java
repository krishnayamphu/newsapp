package com.newsapp;

import org.apache.commons.codec.digest.DigestUtils;
import java.security.NoSuchAlgorithmException;

public class TestApp {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String hash = DigestUtils.sha256Hex("a");
        System.out.println(hash);
    }
}
