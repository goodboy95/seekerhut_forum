package com.seekerhut.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index(HttpServletRequest req) {
        req.setAttribute("ccc", "1234");
        return "index";
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public @ResponseBody String IndexA() {
        return "hwa";
    }
}
