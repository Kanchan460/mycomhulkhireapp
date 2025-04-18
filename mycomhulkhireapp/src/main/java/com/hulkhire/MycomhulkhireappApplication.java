package com.hulkhire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.mycomp.outsidepackage", "com.hulkhire"})


public class MycomhulkhireappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycomhulkhireappApplication.class, args);
	}

}
