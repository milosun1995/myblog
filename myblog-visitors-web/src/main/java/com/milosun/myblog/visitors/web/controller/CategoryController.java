package com.milosun.myblog.visitors.web.controller;

import java.util.List;

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

import com.milosun.myblog.common.constant.WebConstant;
import com.milosun.myblog.common.wrapper.PageWrapper;
import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.pojo.Category;

/**
 * 分类 - 控制器
 * 
 * @author MiloSun
 *
 */
@Controller
public class CategoryController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@GetMapping("/categories/{id}")
	public String showBlogsByCategoryId(@PathVariable Long id,Model model,@PageableDefault(value = 5, sort = { "updateTime" }, direction = Sort.Direction.DESC) Pageable pageable) {
		logger.info("Into categories~~ id : {}",id);

		logger.info("pageable.getPageNumber(): {}",pageable.getPageNumber());
		Category category = this.categoryService.findCategoryById(id);
		List<Category> categories = this.categoryService.findAll();
		
		Page<Blog> blogPage = null;
		//-1从导航点过来的
        if (id == -1){
        	id=categories.get(0).getId();
        	blogPage = PageWrapper.setToPage(categories.get(0).getBlogs(), pageable);
        }else {
        	blogPage = PageWrapper.setToPage(category.getBlogs(), pageable);
        }
        
        PageWrapper<Blog> page = new PageWrapper<>(blogPage, "/categories/"+id);
        
        if(page.getContent().isEmpty()) {
        	 model.addAttribute(WebConstant.ACTIVE_CATEGORYID_KEY, id);
    		 model.addAttribute(WebConstant.CATEGORIES_KEY, categories);
			 model.addAttribute(WebConstant.ERRORS_KEY, WebConstant.ERRORS_NOT_FOUND_DATA_VALUE);
			 return WebConstant.CATEGORY_HTML;
		}
        
        model.addAttribute(WebConstant.ACTIVE_CATEGORYID_KEY, id);
		model.addAttribute(WebConstant.CATEGORIES_KEY, categories);
		model.addAttribute(WebConstant.CATEGORY_KEY, category);
		model.addAttribute(WebConstant.BLOGS_KEY, blogPage);
		model.addAttribute(WebConstant.PAGE_KEY, page);
		
		return WebConstant.CATEGORY_HTML;
	}
	
}
