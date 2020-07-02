package com.milosun.myblog.admin.web.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milosun.myblog.admin.interfaces.AdminBlogService;
import com.milosun.myblog.admin.interfaces.AdminCategoryService;
import com.milosun.myblog.admin.interfaces.AdminTagService;
import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.pojo.BlogUser;
import com.milosun.myblog.pojo.Category;
import com.milosun.myblog.pojo.Tag;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	private static Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private AdminBlogService blogService;
	
	@Autowired
	private AdminTagService tagService;
	
	@Autowired
	private AdminCategoryService categoryService;
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		
		logger.info("Into BlogController edit method ..");
		
		Blog blog = this.blogService.findBlogById(id);
		List<Tag> tags =this.tagService.findAll();
		List<Category> categories = this.categoryService.findAll();
		
		if(-1==id || null==blog) {
			blog = new Blog();
			BlogUser user = new BlogUser();
			user.setId(1L);
			blog.setUser(user);
		}
		
		model.addAttribute("tags", tags);
		model.addAttribute("categories", categories);
		model.addAttribute("blog", blog);  //返回一个blog对象给前端th:object	
		
		return "blog/edit";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute Blog blog,Model model) {
		logger.info("Into BlogController save method ..");
		logger.info("tag : {}",blog.getTagNames());
		
		Set<Tag> tags = this.tagService.save(blog.buildTagNames());
		
		blog.setTags(tags);
		
		this.blogService.save(blog);
		
		return "blog/edit";
	}
	
}
