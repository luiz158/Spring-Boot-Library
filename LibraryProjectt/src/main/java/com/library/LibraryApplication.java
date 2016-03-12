package com.library;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@EnableAspectJAutoProxy
@SpringBootApplication
//@Configuration
//@ComponentScan({"com.library.controllers", "com.library.domain","com.library.aop"})
//@ComponentScan({"com.library.aop"})
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
