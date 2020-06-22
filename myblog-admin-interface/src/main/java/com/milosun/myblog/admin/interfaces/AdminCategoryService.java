package com.milosun.myblog.admin.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Category;

public interface AdminCategoryService {

	public Category findCategoryById(Long id);
	
	public Page<Category> findAll(Pageable pageable);
	
	public List<Category> findAll();
}
