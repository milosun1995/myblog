package com.milosun.myblog.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milosun.myblog.pojo.Category;

public interface BaseCategoryDao extends JpaRepository<Category, Long>{
	
	public Category findCategoryById(Long id);
	
}
