package com.example.helloworld;
//package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;


//public class HelloworldController {

//    @GetMapping("/hello")
//    public String hellow() {
//        return "hello world";
//    }
//
//    @GetMapping("/japan")
//    public String japan() {
//        return "ハロー日本";
//    }
//
//    @GetMapping("/us")
//    public String us() {
//        return "ハローus";
//    }
//
//    @GetMapping("/france")
//    public String france() {
//        return "ハローフランス";
//    }
//
//    @GetMapping("/korea")
//    public String korea() {
//        return "ハロー韓国";
//    }

//    @GetMapping("/")
//    public String greeting() {
//        return "greeting"; //greeting.htmlを表示する。
//    }
//
//    String msg2;
//
//    @GetMapping("/greeting?{country}")
//    public String greeting(@RequestParam("country") String msg) {
//
////        Object country = null;
//        return msg2;
//    }


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "country", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/localtime")
    String datetime() {

        // 現在日時を取得
        LocalDateTime date1 = LocalDateTime.now();
//        System.out.println(date1); // 2021-10-06T23:47:22.175049200
        // 表示形式を指定
        DateTimeFormatter dtformat =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

        String fdate1 = dtformat.format(date1); //表示形式+Stringに変換

//        System.out.println(fdate1); // 2021/10/06 23:47:22.175
        return fdate1;
    }


}
