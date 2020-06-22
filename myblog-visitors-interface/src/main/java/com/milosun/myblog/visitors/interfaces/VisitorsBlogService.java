package com.milosun.myblog.visitors.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Blog;

public interface VisitorsBlogService {

	public Blog findBlogById(Long id);
	
	public Page<Blog> findAll(Pageable pageable);
	
	public List<Blog> findAll();
}
