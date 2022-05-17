package com.course.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

/**
 * @author Yansoul
 * @date 2022/5/11 - 22:34
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@SpringBootApplication
@EnableScheduling
public class Application {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class, args);
    }

    @PreDestroy
    public void close() {
        Application.context.close();
    }
}
