package com.milosun.myblog.admin.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Blog;

public interface AdminBlogService {

	public Blog findBlogById(Long id);
	
	public Page<Blog> findAll(Pageable pageable);
	
	public List<Blog> findAll();
	
	public Blog save(Blog blog);
}
