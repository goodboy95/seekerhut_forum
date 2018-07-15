package com.seekerhut.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController {
    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    public @ResponseBody String GetForumList() {
        return "frfrfrfr";
    }
}
