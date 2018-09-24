package com.orosales;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WebMain {
    public static void main(String[] args) {
        log.debug("I am here in main");
        SpringApplication.run(WebMain.class, args);
    }
}
