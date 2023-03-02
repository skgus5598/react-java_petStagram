package com.project.petstagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = DataSourceAutoConfiguration.class) // 디비 잠시 필요하지 않아서
public class PetStagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetStagramApplication.class, args);
    }

}
