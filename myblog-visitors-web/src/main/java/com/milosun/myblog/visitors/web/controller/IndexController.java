package com.milosun.myblog.visitors.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * 首页 - 访问控制器
 * @author MiloSun
 *
 */
@Controller
public class IndexController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	
	@GetMapping("/")
	public String index(Model model,@PageableDefault(value = 5, sort = { "updateTime" }, direction = Sort.Direction.DESC) Pageable pageable,HttpSession session) {
		logger.info("Into index~~");
		
		Page<Blog> blogPage = this.blogService.findAll(pageable);
		PageWrapper<Blog> page = new PageWrapper<>(blogPage, "/");
		
		//页面侧边显示列表
		this.pageSideLayoutModel(model);
		
		model.addAttribute("blogs", blogPage);
		model.addAttribute("page", page);
		return "index";
	}
	
	
	@GetMapping("/blog/{id}")
	public String showBlogDetail(@PathVariable Long id,Model model) {
		logger.info("Into showBlogDetail~~");
		Blog blog = this.blogService.findBlogById(id);
		
		//页面侧边显示列表
		this.pageSideLayoutModel(model);
		
		model.addAttribute("blog",blog);
		return "blog";
	}
}



