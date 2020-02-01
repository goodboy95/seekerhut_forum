package com.seekerhut.controller;

import com.alibaba.fastjson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Console;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class BaseController {
    public <T extends Serializable>T JObjectParse(JSONObject jobj) {
        return null;
    }

    protected String Success(String msg, Object data) {
        try {
            var dataStr = JSON.toJSONString(data);
            System.out.println(dataStr);
            var jobj = new JSONObject();
            jobj.put("Code", 0);
            jobj.put("Message", msg);
            if (dataStr.substring(0, 1).equals("[")) jobj.put("Data", new JSONArray(dataStr));
            else if (dataStr.substring(0, 1).equals("{")) jobj.put("Data", new JSONObject(dataStr));
            else jobj.put("Data", new JSONObject());
            return jobj.toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    protected String Success(Object data) {
        return Success("", data);
    }

    protected String Fail(int errCode, String msg) {
        try {
            var jobj = new JSONObject();
            jobj.put("Code", errCode);
            jobj.put("Message", msg);
            jobj.put("Data", new JSONObject());
            return jobj.toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    protected String Fail(String msg) {
        return Fail(-1, msg);
    }
}
