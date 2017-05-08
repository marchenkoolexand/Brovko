package com.brovko.controller.ui;

import com.brovko.domain.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    String index(Map<String, Object> model) {
        return "index";
    }
}
