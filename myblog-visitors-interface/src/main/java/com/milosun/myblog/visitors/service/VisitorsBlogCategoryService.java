package com.milosun.myblog.visitors.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.BlogCategory;

public interface VisitorsBlogCategoryService {

	public BlogCategory findBlogCategoryById(Long id);
	
	public Page<BlogCategory> findAll(Pageable pageable);
	
	public List<BlogCategory> findAll();
}
