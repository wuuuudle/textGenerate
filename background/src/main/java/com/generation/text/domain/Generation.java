package com.generation.text.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Generation {
    private static String getKeyword = "http://jiuge.thunlp.cn/getKeyword";
    private static String sendPoem = "http://jiuge.thunlp.cn/sendPoem";
    private static String getPoem = "http://jiuge.thunlp.cn/getPoem";


    private static String Http_post(String url, String param) {
        try {
            URL realer = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realer.openConnection();
            connection.setRequestMethod("POST");

            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(param.getBytes());
            os.flush();
            os.close();
            InputStream is = connection.getInputStream();

            return new String(is.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getPoemByHeadWords(String length, String body) {
        try {
            var result = Unirest.post(getKeyword)
                    .field("level", "1")
                    .field("genre", "2")
                    .field("keywords", body)
                    .asString().getBody();
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (!jsonObject.getString("code").equals("0")) {
                ArrayList<String> tp = new ArrayList<>();
                tp.add("无法生成诗词");
                return tp;
            }
            String user_id = UUID.randomUUID().toString().replace("-", "");
            result = Unirest.post(sendPoem)
                    .field("style", "-1")
                    .field("genre", "2")
                    .field("yan", length)
                    .field("keywords", jsonObject.getString("data"))
                    .field("user_id", user_id)
                    .asString()
                    .getBody();

            while (true) {
                result = Unirest.post(getPoem)
                        .field("style", "-1")
                        .field("genre", "2")
                        .field("yan", length)
                        .field("keywords", jsonObject.getString("data"))
                        .field("user_id", user_id)
                        .asString()
                        .getBody();
                JSONObject jsonObject1 = JSONObject.parseObject(result);
                if (jsonObject1.getString("code").equals("0")) {
                    return jsonObject1.getJSONObject("data")
                            .getJSONArray("poem")
                            .stream()
                            .map(item -> (String) item)
                            .collect(Collectors.toList());
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            ArrayList<String> tp = new ArrayList<>();
            tp.add("服务器错误");
            return tp;
        }
    }

    public static List<String> getPoemByKeyWords(String length, String keywords, String style) {
        try {
            var result = Unirest.post(getKeyword)
                    .field("level", "1")
                    .field("genre", "4")
                    .field("keywords", keywords)
                    .asString().getBody();
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (!jsonObject.getString("code").equals("0")) {
                ArrayList<String> tp = new ArrayList<>();
                tp.add("无法生成诗词");
                return tp;
            }
            String user_id = UUID.randomUUID().toString().replace("-", "");
            result = Unirest.post(sendPoem)
                    .field("style", style)
                    .field("genre", "4")
                    .field("yan", length)
                    .field("keywords", jsonObject.getString("data"))
                    .field("user_id", user_id)
                    .asString()
                    .getBody();

            while (true) {
                result = Unirest.post(getPoem)
                        .field("style", style)
                        .field("genre", "4")
                        .field("yan", length)
                        .field("keywords", jsonObject.getString("data"))
                        .field("user_id", user_id)
                        .asString()
                        .getBody();
                JSONObject jsonObject1 = JSONObject.parseObject(result);
                if (jsonObject1.getString("code").equals("0")) {
                    return jsonObject1.getJSONObject("data")
                            .getJSONArray("poem")
                            .stream()
                            .map(item -> (String) item)
                            .collect(Collectors.toList());
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            ArrayList<String> tp = new ArrayList<>();
            tp.add("服务器错误");
            return tp;
        }
    }

}
