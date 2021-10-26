package com.yannicl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    public static final String USER_PROFILE = "user-profile";

    @GetMapping("api/hello")
    public String getHello(HttpSession session) {
        session.setAttribute(USER_PROFILE, new UserProfile());
        return "Hello You!";
    }

    @GetMapping("api/user")
    public UserProfile getUser(HttpSession session) {
        UserProfile userProfile = (UserProfile) session.getAttribute(USER_PROFILE);
        return userProfile;
    }

}
