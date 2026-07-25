package com.mg_devjoint.auth_service.service;

public interface MailService {
    boolean sendTemporaryPasswordEmail(String email, String sendTemporaryPasswordEmail);
}
