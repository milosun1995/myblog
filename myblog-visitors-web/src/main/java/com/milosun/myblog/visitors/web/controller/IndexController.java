package com.milosun.myblog.visitors.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String index(@RequestParam(required = false,defaultValue = "0",value = "currentPage")int currentPage , Model model) {
		logger.info("Into index~~");
		
		Pageable pageable =PageRequest.of(currentPage, 8,Sort.by(Order.desc("updateTime")));
		Page<Blog> blogPage = this.visitorsBlogService.findAll(pageable);
		model.addAttribute("blogPage", blogPage);
		return "index";
	}
	
	
	@GetMapping("/blog/{id}")
	public String showBlogDetail(@PathVariable Long id,Model model) {
		logger.info("Into showBlogDetail~~");
		return "blog";
	}
}



