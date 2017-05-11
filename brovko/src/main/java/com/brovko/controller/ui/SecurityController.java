package com.brovko.controller.ui;

import com.brovko.domain.Sex;
import com.brovko.domain.User;
import com.brovko.domain.UserSocialInfo;
import com.brovko.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class SecurityController {

    final static Logger logger = Logger.getLogger(SecurityController.class);

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("recoveryEmail") String recoveryEmail,
                               @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("preferedLang") String preferedLang,
                               @RequestParam("sex") String sex,
                               @RequestParam("dateOfBirth") String dateOfBirth,
                               @RequestParam("aboutYourSelf") String aboutYourSelf,
                               @RequestParam("fbLink") String fbLink,
                               @RequestParam("vkLink") String vkLink,
                               @RequestParam("skype") String skype,
                               @RequestParam("gplus") String gplus,
                               @RequestParam("twitter") String twitter
    ) {
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRecoveryEmail(recoveryEmail);
        user.setPhoneNumber(phoneNumber);
        user.setUserPreferedLanguage(preferedLang);
        user.setSex(Sex.valueOf(sex));
        // user.setDateOfBirth(dateOfBirth);
        user.setAboutYourSelf(aboutYourSelf);
        UserSocialInfo userSocialInfo = new UserSocialInfo();
        userSocialInfo.setFacebookLink(fbLink);
        userSocialInfo.setVkLink(vkLink);
        userSocialInfo.setSkype(skype);
        userSocialInfo.setGooglePlusLink(gplus);
        userSocialInfo.setTwitterLink(twitter);
        user.setUserSocialInfo(userSocialInfo);



        User user1 = userService.findByEmail(email);
        if (user1 == null){
            userService.save(user);
        }


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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response) {
        return "test";
    }

}
