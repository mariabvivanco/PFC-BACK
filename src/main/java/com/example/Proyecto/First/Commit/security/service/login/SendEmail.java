package com.example.Proyecto.First.Commit.security.service.login;

import com.sparkpost.exception.SparkPostException;

public interface SendEmail {

    void sendEmail(String code, String email) throws SparkPostException;
}
