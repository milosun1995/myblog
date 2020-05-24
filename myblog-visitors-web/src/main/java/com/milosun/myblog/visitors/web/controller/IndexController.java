package com.milosun.myblog.visitors.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 首页 - 访问控制器
 * @author MiloSun
 *
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		System.out.println("Into index~~");
		return "index";
	}
	
	
	@GetMapping("/blog/{id}")
	public String showBlogDetail(@PathVariable Long id,Model model) {
		System.out.println("Into showBlogDetail~~");
		return "blog";
	}
}



