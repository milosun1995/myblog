package com.milosun.myblog.visitors.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Blog;

public interface VisitorsBlogService {

	public Blog findBlogById(Long id);
	
	public Page<Blog> findAll(Pageable pageable);
}
