package com.milosun.myblog.visitors.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.milosun.myblog.visitors.service.VisitorsBlogCategoryService;
import com.milosun.myblog.visitors.service.VisitorsBlogService;

public abstract class BaseController {

	@Autowired
	private VisitorsBlogCategoryService categoryService;
	
	@Autowired
	private VisitorsBlogService blogService;
	
	protected void pageSideLayoutModel(Model model) {
		System.out.println(this.categoryService.findAll().get(0).getId());
		model.addAttribute("pageSideLayoutBlogs", this.blogService.findAll());
		model.addAttribute("pageSideLayoutCategorys", this.categoryService.findAll());
	}
}
