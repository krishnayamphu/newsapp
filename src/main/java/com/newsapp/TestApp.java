package com.newsapp;

import com.newsapp.javamail.Mail;
import com.newsapp.utils.PostExcerpt;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;

public class TestApp {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        String hash = DigestUtils.sha256Hex("a");
        String name = "Aptech";
        String email = "dev@aptechlalitpur.com";
        String subject = "Testing Java mail api";
        String message = "hello world, this is sample emails message for java mail api";
        Mail.sendMail(name, email, subject, message);
    }
}
