package com.brovko.controller.ui;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET)
    public String cabinet(Map<String, Object> model) {
        return "cabinet";
    }


    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public String getUserPage(@PathVariable Long id) {
        return "cabinet";
    }


}
