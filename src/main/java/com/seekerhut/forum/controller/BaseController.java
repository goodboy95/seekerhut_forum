package com.seekerhut.forum.controller;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Console;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BaseController {
    public <T extends Serializable>T JObjectParse(JSONObject jobj) {
        return null;
    }

    protected String Success(String msg, Object data) {
        var dataStr = new Gson().toJson(data);
        System.out.println(dataStr);
        var jobj = new JSONObject();
        jobj.put("Code", 0);
        jobj.put("Message", msg);
        if (dataStr.substring(0, 1).equals("[")) jobj.put("Data", new JSONArray(dataStr));
        else if (dataStr.substring(0, 1).equals("{")) jobj.put("Data", new JSONObject(dataStr));
        else jobj.put("Data", new JSONObject());
        return jobj.toString();
    }

    protected String Success(Object data) {
        return Success("", data);
    }

    protected String Fail(int errCode, String msg) {
        var jobj = new JSONObject();
        jobj.put("Code", errCode);
        jobj.put("Message", msg);
        jobj.put("Data", new JSONObject());
        return jobj.toString();
    }

    protected String Fail(String msg) {
        return Fail(-1, msg);
    }
}
