package com.seekerhut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class AdminController extends BaseController {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public @ResponseBody String GetUsers() {
        return Success("");
    }
    public @ResponseBody String CheckUserPosts() {
        return Success("");
    }
}
