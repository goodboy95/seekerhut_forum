package com.seekerhut.controller;

import com.seekerhut.utils.JedisHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/test")
public class TestController {
    @RequestMapping(value = "base_test", method = RequestMethod.GET)
    public @ResponseBody String baseTest(@RequestParam String key, @RequestParam String val) {
        JedisHelper.set(key, val);
        return "";
    }
}
