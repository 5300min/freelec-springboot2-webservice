package com.msuk.samplePractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /* 자동설정 / Bean 읽기와 생성 자동설정 / 해당위치부터 설정을 읽으므로 최상단에 위치해야만 한다. */
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); /* SpringApplication > 내장 was 사용하도록 함 */
    }
}
