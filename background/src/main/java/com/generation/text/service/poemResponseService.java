package com.generation.text.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class poemResponseService extends ResponseService {
    private String head;
    private ArrayList<String> body;

    public poemResponseService(ResponseCode resonseCode, String head, ArrayList<String> body) {
        super(resonseCode);
        this.head = head;
        this.body = body;
    }

    @Override
    public String getJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", this.resonseCode.code);
        jsonObject.put("head", this.head);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(body);
        jsonObject.put("body", jsonArray);
        return jsonObject.toString();
    }
}
