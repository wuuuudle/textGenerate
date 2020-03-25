package com.generation.text.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.lang.Nullable;

import java.util.ArrayList;

public abstract class ResponseService {
    public enum ResponseCode {
        SUCCESS(0), FAILED(1);
        protected int code;

        private ResponseCode(int code) {
            this.code = code;
        }
    }

    protected ResponseCode resonseCode;


    public ResponseService(ResponseCode resonseCode) {
        this.resonseCode = resonseCode;
    }

    public abstract String getJSON();

}
