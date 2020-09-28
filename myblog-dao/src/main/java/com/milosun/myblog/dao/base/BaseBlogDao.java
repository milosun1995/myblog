package com.milosun.myblog.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milosun.myblog.pojo.Blog;


public interface BaseBlogDao extends JpaRepository<Blog, Long>{
	
	Blog findBlogById(Long id);

}
