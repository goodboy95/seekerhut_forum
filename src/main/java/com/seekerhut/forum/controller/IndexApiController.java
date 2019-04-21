package com.seekerhut.forum.controller;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seekerhut.forum.map.ForumMap;
import com.seekerhut.forum.map.PostMap;
import com.seekerhut.forum.model.ForumModel;
import com.seekerhut.forum.model.PostModel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController extends BaseController {
    @Autowired
    private ForumMap forum;
    private PostMap post;

    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    @ApiOperation(value = "Get forum list", httpMethod = "GET", notes = "")
    public @ResponseBody String GetForumList() {
        var forumList = forum.findById(1l);
        return "";
    }

    @RequestMapping(value = "/forum", method = RequestMethod.POST)
    @ApiOperation(value = "Add or edit a forum", httpMethod = "POST", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "forumJson", value = "fourmInfo in json string", paramType = "query", dataType = "String")
    })
    public @ResponseBody String SaveForum(String forumJson) {
        try {
            JSONObject forumJobj = new JSONObject(forumJson);
            ForumModel forumObj = forumJobj.has("id") ? forum.getOne(forumJobj.getLong("id")) : new ForumModel();
            forumObj.setValue(forumJobj);
            forum.save(forumObj);
            return Success("save ok", forumObj);
        }
        catch (JSONException je) { return Fail(-1, "oh no"); }
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public @ResponseBody String SavePost(String postJson) {
        try {
            JSONObject postJobj = new JSONObject(postJson);
            PostModel postObj = postJobj.has("id") ? post.getOne(postJobj.getLong("id")) : new PostModel();
            postObj.setValue(postJobj);
            post.save(postObj);
            return Success("save ok", postObj);
        }
        catch (JSONException je) { return Fail(-1, "oh no"); }
    }

    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    public @ResponseBody String PostList(@RequestParam Long forumId, @RequestParam int pageSize, @RequestParam int pageNum) {
        List<PostModel> res = post.getPosts(forumId,pageSize * (pageNum - 1), pageSize);
        return Success(res);
    }

    public @ResponseBody String ReplyList(Long postId, int pageSize, int pageNum) {
        return "";
    }

}
