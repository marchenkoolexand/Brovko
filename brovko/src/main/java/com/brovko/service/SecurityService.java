package com.brovko.service;

import javax.servlet.http.HttpServletRequest;

public interface SecurityService {

    public String findLoggedInUsername();

    public void autoLogin(String email, String password,HttpServletRequest request);
}
