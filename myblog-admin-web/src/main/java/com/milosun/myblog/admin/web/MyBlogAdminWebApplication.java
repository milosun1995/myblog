package com.milosun.myblog.admin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.milosun.myblog.common.MyblogCommonConfig;

@SpringBootApplication
@Import({MyblogCommonConfig.class})
public class MyBlogAdminWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyBlogAdminWebApplication.class, args);
	}
}
