package com.seekerhut.controller;

import com.alibaba.fastjson.JSON;

import com.seekerhut.model.ForumPost;
import com.seekerhut.model.ForumReply;
import com.seekerhut.model.ForumSection;
import com.seekerhut.service.ForumCommonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/api/forum")
public class ForumApiController extends BaseController {
    @Resource
    private ForumCommonService forumCommonService;

    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    @ApiOperation(value = "Get forum list", httpMethod = "GET", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "", paramType = "query", dataType = "String"),
    })
    public @ResponseBody String GetForumList(@RequestParam int pageIndex, @RequestParam int pageSize) {
        var forumList = forumCommonService.getSectionList(pageIndex, pageSize);
        return Success(forumList);
    }

    public String prolongString(String src) {
        return src + " ";
    }

    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    @ApiOperation(value = "", httpMethod = "GET", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "forumId", value = "", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "", paramType = "query", dataType = "String"),
    })
    public @ResponseBody String PostList(@RequestParam Long forumId, @RequestParam int pageIndex, @RequestParam int pageSize) {
        List<ForumPost> res = forumCommonService.getPostList(forumId, pageIndex, pageSize);
        return Success(res);
    }

    @RequestMapping(value = "/replyList", method = RequestMethod.GET)
    @ApiOperation(value = "", httpMethod = "GET", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postId", value = "", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "", paramType = "query", dataType = "String"),
    })
    public @ResponseBody String ReplyList(@RequestParam Long postId, @RequestParam int pageIndex, @RequestParam int pageSize) {
        var res = forumCommonService.getReplyList(postId, pageIndex, pageSize);
        return Success(res);
    }

    @RequestMapping(value = "/forum", method = RequestMethod.POST)
    @ApiOperation(value = "Add or edit a forum", httpMethod = "POST", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "forumJson", value = "fourmInfo in json string", paramType = "form", dataType = "String")
    })
    public @ResponseBody String SaveForum(String forumJson) {
        try {
            var forumObj = JSON.parseObject(forumJson, ForumSection.class);
            forumCommonService.saveSection(forumObj);
            return Success("save ok", forumObj);
        }
        catch (Exception e) { return Fail(-1, "oh no"); }
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postJson", value = "", paramType = "form", dataType = "String"),
    })
    public @ResponseBody String SavePost(String postJson) {
        try {
            var postObj = JSON.parseObject(postJson, ForumPost.class);
            forumCommonService.savePost(postObj);
            return Success("save ok", postObj);
        }
        catch (Exception e) {
            return Fail(-1, String.join(",", Arrays.stream(e.getStackTrace()).map(s -> s.toString()).toArray(String[] :: new)));
        }
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replyJson", value = "", paramType = "form", dataType = "String"),
    })
    public @ResponseBody String SaveReply(String replyJson) {
        try {
            var postObj = JSON.parseObject(replyJson, ForumReply.class);
            forumCommonService.saveReply(postObj);
            return Success("save ok", postObj);
        }
        catch (Exception e) {
            return Fail(-1, String.join(",", Arrays.stream(e.getStackTrace()).map(s -> s.toString()).toArray(String[] :: new)));
        }
    }
}
