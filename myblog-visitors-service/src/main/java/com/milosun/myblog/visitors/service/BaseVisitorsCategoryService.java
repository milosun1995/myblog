package com.milosun.myblog.visitors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsCategoryDao;
import com.milosun.myblog.pojo.Category;
import com.milosun.myblog.visitors.interfaces.VisitorsCategoryService;

@Service
public class BaseVisitorsCategoryService implements VisitorsCategoryService {

	@Autowired
	private VisitorsCategoryDao categoryDao;


	@Override
	public Category findCategoryById(Long id) {
		return this.categoryDao.findCategoryById(id);
	}

	@Override
	public List<Category> findAll() {
		return this.categoryDao.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return this.categoryDao.findAll(pageable);
	}
}
