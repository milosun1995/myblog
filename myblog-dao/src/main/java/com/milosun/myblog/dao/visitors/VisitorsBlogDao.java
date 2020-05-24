package com.milosun.myblog.dao.visitors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milosun.myblog.pojo.Blog;

public interface VisitorsBlogDao extends JpaRepository<Blog, Long> {
	
	public Blog findBlogById(Long id);
	
}
