package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    MathService mathService;

    @GetMapping("api/math/factorial")
    public Integer factorial(@RequestParam(value = "n", defaultValue = "1", required = false) Integer n) {
        return mathService.factorial(n);
    }

}
