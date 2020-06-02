package com.milosun.myblog.visitors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsCategoryDao;
import com.milosun.myblog.pojo.Category;
import com.milosun.myblog.visitors.service.VisitorsCategoryService;

@Service
public class VisitorsCategoryServiceImpl implements VisitorsCategoryService {

	@Autowired
	private VisitorsCategoryDao visitorsCategoryDao;


	@Override
	public Category findCategoryById(Long id) {
		return this.visitorsCategoryDao.findCategoryById(id);
	}

	@Override
	public List<Category> findAll() {
		return this.visitorsCategoryDao.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return this.visitorsCategoryDao.findAll(pageable);
	}
}
