package com.milosun.myblog.visitors.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.ui.Model;

import com.milosun.myblog.visitors.service.VisitorsBlogService;
import com.milosun.myblog.visitors.service.VisitorsCategoryService;
import com.milosun.myblog.visitors.service.VisitorsTagService;

public abstract class BaseController {

	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected VisitorsCategoryService categoryService;
	
	@Autowired
	protected VisitorsBlogService blogService;
	
	@Autowired
	protected VisitorsTagService tagService;
	
	protected void pageSideLayoutModel(Model model) {
		
		logger.info("into BaseController pageSideLayoutModel...");
		
		model.addAttribute("pageSideLayoutTags", this.tagService.findAll());
		model.addAttribute("pageSideLayoutBlogs", this.blogService.findAll(PageRequest.of(0, 10, Sort.by(Order.desc("countViews")))));
		model.addAttribute("pageSideLayoutCategorys", this.categoryService.findAll());
	}
}
