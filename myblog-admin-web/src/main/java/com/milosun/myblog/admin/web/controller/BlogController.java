package com.milosun.myblog.admin.web.controller;

import java.util.HashSet;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.milosun.myblog.admin.interfaces.AdminBlogService;
import com.milosun.myblog.admin.interfaces.AdminCategoryService;
import com.milosun.myblog.admin.interfaces.AdminTagService;
import com.milosun.myblog.admin.web.dto.BlogDTO;
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
		
		List<Tag> tags =this.tagService.findAll();
		List<Category> categories = this.categoryService.findAll();
		
		Blog blog = new Blog();
		BlogUser user = new BlogUser();
		user.setId(1L);
		blog.setUser(user);
		
		model.addAttribute("tags", tags);
		model.addAttribute("categories", categories);

		BlogDTO blogDTO =new BlogDTO(blog,null);
		model.addAttribute("blogDTO", blogDTO);  //返回一个blog对象给前端th:object	
		return "blog/edit";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute BlogDTO blogDTO,Model model) {
		logger.info("Into BlogController save method ..");
		
		logger.info("tag : {}",blogDTO.getJsonTags());
		
		List<Tag> tags = JSON.parseArray(blogDTO.getJsonTags(),  Tag.class);
		tags.forEach(t -> {
			logger.info("tag - id :{}",t.getId());
		});
		
		blogDTO.getBlog().setTags(this.tagService.save(tags));
		
		this.blogService.save(blogDTO.getBlog());
		
		return "blog/edit";
	}
	
	public static void main(String[] args) {
		String json="[{\"id\":2,\"tagName\":\"Springboot\"},{\"id\":2,\"tagName\":\"Springboot\"}]";
		List<Tag> tags = JSON.parseArray(json,  Tag.class);
		System.out.println(tags.toString());
	}
}
