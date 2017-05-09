package com.brovko.controller.ui;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class SecurityController {

    final static Logger logger = Logger.getLogger(SecurityController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration() {
        //TODO
       //securityService.autologin(user.getUsername(), user.getPassword());
        return "welcome";
    }

    @RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
    public String invalidSession(HttpServletRequest request, HttpServletResponse response) {
        return " ";
    }

    @RequestMapping(value = "/sessionError", method = RequestMethod.GET)
    public String sessionError(HttpServletRequest request, HttpServletResponse response) {
        return " ";
    }
}
