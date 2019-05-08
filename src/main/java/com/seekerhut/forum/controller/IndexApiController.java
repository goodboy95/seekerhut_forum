package com.seekerhut.forum.controller;

import com.alibaba.fastjson.JSON;
import com.seekerhut.forum.map.ForumMap;
import com.seekerhut.forum.map.PostMap;
import com.seekerhut.forum.map.ReplyMap;
import com.seekerhut.forum.model.ForumModel;
import com.seekerhut.forum.model.PostModel;
import com.seekerhut.forum.model.ReplyModel;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController extends BaseController {
    @Autowired
    private ForumMap forum;
    @Autowired
    private PostMap post;
    @Autowired
    private ReplyMap reply;

    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    @ApiOperation(value = "Get forum list", httpMethod = "GET", notes = "")
    public @ResponseBody String GetForumList() {
        var forumList = forum.findAll();
        return Success(forumList);
    }

    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    public @ResponseBody String PostList(@RequestParam Long forumId, @RequestParam int pageSize, @RequestParam int pageNum) {
        List<PostModel> res = post.getPosts(forumId, pageSize * (pageNum - 1), pageSize);
        return Success(res);
    }

    @RequestMapping(value = "/replyList", method = RequestMethod.GET)
    public @ResponseBody String ReplyList(@RequestParam Long postId, @RequestParam int pageSize, @RequestParam int pageNum) {
        var res = reply.getReply(postId, pageSize * (pageNum - 1), pageSize);
        return Success(res);
    }

    @RequestMapping(value = "/forum", method = RequestMethod.POST)
    @ApiOperation(value = "Add or edit a forum", httpMethod = "POST", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "forumJson", value = "fourmInfo in json string", paramType = "query", dataType = "String")
    })
    public @ResponseBody String SaveForum(@RequestParam String forumJson) {
        try {
            var forumObj = JSON.parseObject(forumJson, ForumModel.class);
            forum.save(forumObj);
            return Success("save ok", forumObj);
        }
        catch (Exception e) { return Fail(-1, "oh no"); }
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public @ResponseBody String SavePost(@RequestParam String postJson) {
        try {
            var postObj = JSON.parseObject(postJson, PostModel.class);
            post.save(postObj);
            return Success("save ok", postObj);
        }
        catch (Exception e) { 
            return Fail(-1, String.join(",", Arrays.stream(e.getStackTrace()).map(s -> s.toString()).toArray(String[] :: new))); 
        }
    }

    public @ResponseBody String SaveReply(@RequestParam String replyJson) {
        try {
            var postObj = JSON.parseObject(replyJson, ReplyModel.class);
            reply.save(postObj);
            return Success("save ok", postObj);
        }
        catch (Exception e) {
            return Fail(-1, String.join(",", Arrays.stream(e.getStackTrace()).map(s -> s.toString()).toArray(String[] :: new))); 
        }
    }

}
