package com.seekerhut.forum.controller;

import com.seekerhut.forum.map.ForumMap;
import com.seekerhut.forum.model.ForumModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController {
    @Autowired
    private ForumMap forum;
    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    public @ResponseBody String GetForumList() {

        return "frfrfrfr";
    }
}
