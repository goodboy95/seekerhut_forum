package com.seekerhut.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.seekerhut.service.ForumCommonService;
import com.seekerhut.utils.CommonFunctions;
import com.seekerhut.utils.EnumAndConstData.HTTPMethod;
import com.seekerhut.utils.custombean.datagenerator.DataGenConfig;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@Controller
@RequestMapping(value = "/api/test")
public class TestController extends BaseController {
    @Resource
    private ForumCommonService forumCommonService;

    @RequestMapping(value = "base_test", method = RequestMethod.GET)
    public @ResponseBody String baseTest() {
        return Success("");
    }

    @RequestMapping(value = "api_call_test", method = RequestMethod.POST)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "generatorConfig", value = "", paramType = "form", dataType = "String")
    })
    public @ResponseBody String apiCallTest(String generatorConfig) throws IOException {
        CloseableHttpClient hc = HttpClients.createDefault();
        int currentPercent = 0;
        DataGenConfig config = JSON.parseObject(generatorConfig, DataGenConfig.class);
        HTTPMethod method = config.getMethod();
        String url = config.getUrl();
        int cycles = config.getTimes();
        int interval = config.getInterval();
        var fieldsConfig = config.getFieldData();
        try {
            for (int i = 1; i <= cycles; i++) {
                var generatedParams = CommonFunctions.generateQueryDataByConfig(fieldsConfig);
                var finalParams = generatedParams.entrySet().stream()
                    .map(e -> (NameValuePair)new BasicNameValuePair(e.getKey(), e.getValue()))
                    .collect(Collectors.toList());
                if (method == HTTPMethod.get) {
                    URIBuilder builder = new URIBuilder(url);
                    builder.addParameters(finalParams);
                    HttpGet getObj = new HttpGet(builder.build());
                    hc.execute(getObj).close();
                } else if (method == HTTPMethod.post) {
                    HttpPost postObj = new HttpPost(url);
                    postObj.setEntity(new UrlEncodedFormEntity(finalParams, StandardCharsets.UTF_8));
                    hc.execute(postObj).close();
                } else {
                    //TODO: add other query methods
                }
                Thread.sleep(interval);
                if (i * 100 / cycles > currentPercent) {
                    currentPercent = i * 100 / cycles;
                    System.out.println(String.format("Executed %d/%d iterations (%d%%)", i, cycles, currentPercent));
                }
            }
            return Success("");
        } catch (Exception e) {
            return Fail(-1, e.getMessage());
        } finally {
            hc.close();
        }
        
        
    }
}
