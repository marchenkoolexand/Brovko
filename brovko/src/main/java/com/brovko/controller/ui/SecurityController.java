package com.brovko.controller.ui;

import com.brovko.domain.User;
import com.brovko.repository.UserRepository;
import com.brovko.service.SecurityService;
import com.brovko.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SecurityController {

    final static Logger logger = Logger.getLogger(SecurityController.class);

    @Autowired
    SecurityService securityService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("recoveryEmail") String recoveryEmail
    ) {
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRecoveryEmail(recoveryEmail);

        User userFromDb = userRepository.findUserByEmail(email);

        if (userFromDb == null) {
            userService.create(user);
        }

        securityService.autoLogin(user.getEmail(), user.getPasswordHash(),request);
        return "welcome";
    }
}
