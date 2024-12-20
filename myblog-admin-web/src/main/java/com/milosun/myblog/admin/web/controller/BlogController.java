package com.milosun.myblog.admin.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.milosun.myblog.admin.interfaces.AdminBlogService;
import com.milosun.myblog.admin.interfaces.AdminCategoryService;
import com.milosun.myblog.admin.interfaces.AdminTagService;
import com.milosun.myblog.common.constant.WebConstant;
import com.milosun.myblog.common.wrapper.PageWrapper;
import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.pojo.BlogUser;
import com.milosun.myblog.pojo.Category;
import com.milosun.myblog.pojo.Tag;

@SessionAttributes("blog")
@Controller
@RequestMapping(value = "/blog")
public class BlogController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AdminBlogService blogService;
	
	@Autowired
	private AdminTagService tagService;
	
	@Autowired
	private AdminCategoryService categoryService;

	
	private void base(Model model) {
		List<Tag> tags =this.tagService.findAll();
		List<Category> categories = this.categoryService.findAll();
		
		model.addAttribute("tags", tags);
		model.addAttribute("categories", categories);
	}
	
	
	@GetMapping("/query")
	public String query(Model model,@PageableDefault(value = 5, sort = { "updateTime" }, direction = Sort.Direction.DESC) Pageable pageable) {
		
		logger.info("Into BlogController query method ..");
		
		Page<Blog> blogPage = this.blogService.findAll(pageable);
		PageWrapper<Blog> page = new PageWrapper<>(blogPage, "./query");
		
		this.base(model);
		this.prepareConfigModel(model);
		
		model.addAttribute(WebConstant.BLOGS_KEY, blogPage);
		model.addAttribute(WebConstant.PAGE_KEY, page);
		model.addAttribute("blog", new Blog());  //返回一个blog对象给前端th:object
		
		return "blog/"+WebConstant.BLOG_HTML;
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		
		logger.info("Into BlogController edit method ..");
		
		Blog blog = this.blogService.findBlogById(id);

		if(-1==id || null==blog) {
			blog = new Blog();
			BlogUser user = new BlogUser();
			user.setId(1L);
			blog.setUser(user);
		}
		
		this.base(model);
		
		model.addAttribute("blog", blog);  //返回一个blog对象给前端th:object	
		
		return "blog/edit";
	}
	
	
	@PostMapping("/save")
	public String save(@Validated @ModelAttribute Blog blog , BindingResult result ,Model model) {
		logger.info("Into BlogController save method ..");
		logger.info("tag - {}",blog.getTagNames());
		logger.info("blog.id - {}",blog.getId());
		logger.info("blog.getCategory() - {}",blog.getCategory().toString());
		if(result.hasErrors()) {
			this.base(model);
			result.getFieldErrors().forEach(e->{
				logger.info("getField - {} /",e.getField());
			});
			return "blog/edit";
		}
		
		Set<Tag> tags = this.tagService.save(blog.buildTagNames());
		blog.setTags(tags);
		
		this.blogService.save(blog);
		
		return recallQuery(model);
	}
	
	
	@GetMapping("/batchDelete")
	public String batchDelete(@RequestParam("ids") String ids, Model model) {
		logger.info("Into BlogController batchDelete method ..");
		
		String[] idArr = ids.split(",");
		List<Long> idList = new ArrayList<>();
		Arrays.asList(idArr).forEach(a-> idList.add(new Long(a)));
		
		this.blogService.deleteBatch(idList);
		
		return  recallQuery(model);
	}
}
