package com.tulip.blogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.modelmapper.ModelMapper;
@SpringBootApplication
public class BlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
