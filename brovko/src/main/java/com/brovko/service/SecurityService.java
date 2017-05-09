package com.brovko.service;

public interface SecurityService {

    public String findLoggedInUsername();

    public void autoLogin(String email, String password);
}
