package com.milosun.myblog.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milosun.myblog.pojo.BlogCategory;

public interface BaseBlogCategoryDao extends JpaRepository<BlogCategory, Long>{
	
	public BlogCategory findBlogCategoryById(Long id);
	
}
