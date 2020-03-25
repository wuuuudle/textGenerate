package com.generation.text.controller;

import com.generation.text.domain.Generation;
import com.generation.text.domain.dotGenerate;
import com.generation.text.service.ResponseService;
import com.generation.text.service.paragraphResponseService;
import com.generation.text.service.poemResponseService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class GenerationControll {

    @PostMapping("headWord")
    public String getPoemByHeadWord(@RequestParam("length") String length, @RequestParam("keyword") String keyword, HttpServletResponse httpServletResponse) {
        List<String> response = new ArrayList<>();
        if (!length.equals("7") && !length.equals("5")) {
            response.add("只能是五言或七言绝句哦～");
            return new poemResponseService(ResponseService.ResponseCode.FAILED,
                    null,
                    (ArrayList<String>) response).getJSON();
        }
        response = Generation.getPoemByHeadWords(length, keyword);
        ResponseService.ResponseCode responseCode;
        if (response.size() == 1)
            responseCode = ResponseService.ResponseCode.FAILED;
        else
            responseCode = ResponseService.ResponseCode.SUCCESS;
        System.out.println(response);
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");

        return new poemResponseService(responseCode,
                null,
                (ArrayList<String>) response).getJSON();
    }

    @PostMapping("keyWord")
    public String getPoemByKeyWord(@RequestParam("length") String length, @RequestParam("keyword") String keywords, @RequestParam("style") String style, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        List<String> response = new ArrayList<>();
        if (!length.equals("7") && !length.equals("5")) {
            response.add("只能是五言或七言绝句哦～");
            return new poemResponseService(ResponseService.ResponseCode.FAILED,
                    null,
                    (ArrayList<String>) response).getJSON();
        }
        response = Generation.getPoemByKeyWords(length, keywords, style);
        String head = null;
        if (response.size() == 5) {
            head = response.get(0);
            response.remove(0);
        }
        return new poemResponseService(ResponseService.ResponseCode.SUCCESS,
                head,
                (ArrayList<String>) response).getJSON();
    }

    @PostMapping("getParagraph")
    public String getParagraph(@RequestParam("theme") String theme, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        return new paragraphResponseService(ResponseService.ResponseCode.SUCCESS,
                dotGenerate.generateText(theme)).getJSON();
    }
}
