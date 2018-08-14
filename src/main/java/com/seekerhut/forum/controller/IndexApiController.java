package com.seekerhut.forum.controller;

import com.seekerhut.forum.map.ForumMap;
import com.seekerhut.forum.model.ForumModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController {
    @Autowired
    private ForumMap forum;
    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    public @ResponseBody String GetForumList() {
        var z = new ForumModel();
        z.setAdminName("");
        z.setCreatorID(1);
        z.setName("ccc");
        z.setPostLevel(1);
        z.setStatus(1);
        z.setViewLevel(1);
        var l = new LinkedList<Long>();
        l.add((long)11);
        l.add((long)22);
        z.setReplyId(l);
        forum.save(z);
        var x = forum.count();
        return Long.toString(x);
    }

    @RequestMapping(value = "/forumGet", method = RequestMethod.GET)
    public @ResponseBody String GetSubList(String nm) {
        var z = forum.findSomeByName("ccc", 2);
        var zi = z.iterator();
        var m = zi.next();
        return m.getName();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody String SaveForum() {
        return "";
    }
}
