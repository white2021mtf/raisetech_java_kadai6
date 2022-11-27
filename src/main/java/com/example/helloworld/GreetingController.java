package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

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
        // 表示形式を指定
        DateTimeFormatter dtformat =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        String fdate1 = dtformat.format(date1); //表示形式+Stringに変換
        return fdate1;
    }
}
