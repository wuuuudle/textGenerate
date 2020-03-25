package com.generation.text.service;

import com.alibaba.fastjson.JSONObject;

public class paragraphResponseService extends ResponseService {
    private String text;

    public paragraphResponseService(ResponseCode resonseCode, String text) {
        super(resonseCode);
        this.text = text;
    }

    @Override
    public String getJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", this.resonseCode.code);
        jsonObject.put("text", this.text);
        return jsonObject.toString();
    }
}
