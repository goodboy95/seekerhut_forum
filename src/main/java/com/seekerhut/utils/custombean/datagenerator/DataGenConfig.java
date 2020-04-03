package com.seekerhut.utils.custombean.datagenerator;


import com.seekerhut.utils.EnumAndConstData.HTTPMethod;

import java.util.HashMap;

public class DataGenConfig {
    private HTTPMethod method;
    private String url;
    private int times;
    private int interval;
    private HashMap<String, FieldMetaData> fieldData;

    public HTTPMethod getMethod() {
        return method;
    }

    public void setMethod(HTTPMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, FieldMetaData> getFieldData() {
        return fieldData;
    }

    public void setFieldData(HashMap<String, FieldMetaData> fieldData) {
        this.fieldData = fieldData;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}