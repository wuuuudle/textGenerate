package com.generation.text;

import com.generation.text.domain.Generation;
import com.generation.text.domain.dotGenerate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void headword() {
        List<String> s = Generation.getPoemByHeadWords("7", "无敌真帅");
        s.stream().forEach(System.out::println);
    }

    @Test
    public void keyword() {
        List<String> s = Generation.getPoemByKeyWords("7", " 夜雨 碑碣","0");
        s.stream().forEach(System.out::println);
    }

    @Test
    public void getText() {
        System.out.println(dotGenerate.generateText("掉头发"));
    }
}
