/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.dto;

public class ResponseServices {

    private String responseCode;
    private String responseDesc;
    private String dataLogger;
    private String dataHcms;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getDataLogger() {
        return dataLogger;
    }

    public void setDataLogger(String dataLogger) {
        this.dataLogger = dataLogger;
    }

    public String getDataHcms() {
        return dataHcms;
    }

    public void setDataHcms(String dataHcms) {
        this.dataHcms = dataHcms;
    }
}
