package com.milosun.myblog.admin.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	private static Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		logger.info("Into BlogController edit");
		return "blog/blog_edit";
	}
}
