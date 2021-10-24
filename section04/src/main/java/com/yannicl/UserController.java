package com.yannicl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("api/hello")
    public String getHello() {
        return "Hello You!";
    }

    @PostMapping("api/user")
    public String setUser(@RequestParam(value = "name") String name) {
        return "OK";
    }

}
