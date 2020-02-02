package com.seekerhut.controller;

import com.alibaba.fastjson.JSON;

import com.seekerhut.model.ForumPost;
import com.seekerhut.model.ForumReply;
import com.seekerhut.model.ForumSection;
import com.seekerhut.service.AuthService;
import com.seekerhut.service.ForumCommonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController extends BaseController {
    @Resource
    private AuthService authService;
    @Resource
    private ForumCommonService forumCommonService;

    @RequestMapping(value = "csrf_token_generator", method = RequestMethod.GET)
    public @ResponseBody String csrfTokenGenerator() {
        return Success("");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "passhash", value = "", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "verifyCode", value = "", paramType = "form", dataType = "String"),
    })
    public @ResponseBody String register(String username, String passhash, String verifyCode) {
        int result1 = authService.registerLv1("ip", "token", verifyCode);
        if (result1 == 0) {
            int result2 = authService.registerLv2(username, passhash);
            if (result2 == 0) {
                return Success("");
            }
        }
        return Fail(-1, "register failed");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "passhash", value = "", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "verifyCode", value = "", paramType = "form", dataType = "String"),
    })
    public @ResponseBody String login(String username, String passhash, String verifyCode) {
        int result1 = 0;
        if (result1 == 0) {
            int result2 = authService.login(username, passhash, "ip");
            if (result2 == 0) {
                return Success("");
            }
        }
        return Fail(-1, "login failed");
    }
}
