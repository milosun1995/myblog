package com.milosun.myblog.visitors.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.milosun.myblog.common.wrapper.PageWrapper;
import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.visitors.service.VisitorsBlogService;


/**
 * 首页 - 访问控制器
 * @author MiloSun
 *
 */
@Controller
public class IndexController {

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private VisitorsBlogService visitorsBlogService;
	
	@GetMapping("/")
	public String index(Model model,@PageableDefault(value = 5, sort = { "createTime" }, direction = Sort.Direction.DESC) Pageable pageable) {
		
		logger.info("Into index~~");
		logger.info("pageable.getPageSize():{}",pageable.getPageSize());
		logger.info("pageable.getPageNumber():{}",pageable.getPageNumber());
	
		Page<Blog> blogPage = this.visitorsBlogService.findAll(pageable);
		PageWrapper<Blog> page = new PageWrapper<>(blogPage, "/");
		model.addAttribute("blogs", blogPage.getContent());
		model.addAttribute("page", page);
		logger.info("totalPages:{}",blogPage.getTotalPages());
		logger.info("getTotalElements:{}",blogPage.getTotalElements());
		logger.info("isFirstPage:{}",page.isFirstPage());
		return "index";
	}
	
	
	@GetMapping("/blog/{id}")
	public String showBlogDetail(@PathVariable Long id,Model model) {
		logger.info("Into showBlogDetail~~");
		return "blog";
	}
}



