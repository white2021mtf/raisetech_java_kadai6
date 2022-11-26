package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class HelloworldController {

    @GetMapping("/hellow")
    public String hellow() {
        return "hello world";
    }

    @GetMapping("/japan")
    public String japan() {
        return "ハロー日本";
    }

    @GetMapping("/us")
    public String us() {
        return "ハローus";
    }

    @GetMapping("/france")
    public String france() {
        return "ハローフランス";
    }

    @GetMapping("/korea")
    public String korea() {
        return "ハロー韓国";
    }


    @GetMapping("/localtime")
    String datetime() {

        // 現在日時を取得
        LocalDateTime date1 = LocalDateTime.now();
        System.out.println(date1); // 2021-10-06T23:47:22.175049200
        // 表示形式を指定
        DateTimeFormatter dtformat =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

        String fdate1 = dtformat.format(date1); //表示形式+Stringに変換

        System.out.println(fdate1); // 2021/10/06 23:47:22.175
        return fdate1;
    }


}
