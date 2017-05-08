package com.brovko.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    String admin(Map<String, Object> model) {
        return "admin";
    }

}
