package com.milosun.myblog.visitors.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Category;

public interface VisitorsCategoryService {

	public Category findCategoryById(Long id);
	
	public Page<Category> findAll(Pageable pageable);
	
	public List<Category> findAll();
}
