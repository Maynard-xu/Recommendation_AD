package com.xujin.ad_sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* Description:
 * \* User: xujin
 * \* Date: 2018/1/30
 * \* Time: 11:19
 * \
 */
@Controller
public class load_search {

    @GetMapping("/")
    public String ad_index() {
        return "ad_index";
    }

    @GetMapping("/baidu")
    @ResponseBody
    public Map<String, Object> loadSearch() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xujin");
        map.put("age", 24);
        return map;
    }

//    @GetMapping("/getHtml")
//    @ResponseBody
//    public StringBuffer getHtml() {
//        try {
//            URL url = new URL("http://www.baidu.com");
//            InputStream inputStream = url.openStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuffer str = new StringBuffer();
//            String t;
//            while ((t = bufferedReader.readLine()) != null) {
//                str.append(t);
//            }
//            System.out.println(str);
//            bufferedReader.close();
//            inputStreamReader.close();
//            inputStream.close();
//            return str;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @PostMapping("/get_search")
    @ResponseBody
    public List<String> get_search(String keyword, String PrePageNum) {
        try {
            String[] args = new String[]{"python3.6", "/Users/xujin/Desktop/毕业设计/implement_code/ad_sender/src/main/java/com/xujin/ad_sender/py/searchData.py", keyword, PrePageNum};
            System.out.println("start_search.................");
            Process pr = Runtime.getRuntime().exec(args);
            InputStreamReader inputStreamReader = new InputStreamReader(pr.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String t;
            StringBuffer str = new StringBuffer();
            while ((t = bufferedReader.readLine()) != null) {
                str.append(t);
            }
            bufferedReader.close();
            inputStreamReader.close();
            pr.waitFor();
            System.out.println("end_search.................");
            return splitStr(str.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> splitStr(String str) {
        Pattern r = Pattern.compile("(^\\[)(.*)(]$)");
        Matcher matcher = r.matcher(str);
        String[] aa = new String[0];
        List<String> search_list = new ArrayList<>();
        if (matcher.find()) {
            aa = matcher.group(2).split(", ");
        }
        for (String tt : aa) {
            search_list.add(tt.replaceAll("\'", "\""));
        }
        return search_list;
    }
}

