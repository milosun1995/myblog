package com.milosun.myblog.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.admin.interfaces.AdminCategoryService;
import com.milosun.myblog.dao.admin.AdminCategoryDao;
import com.milosun.myblog.pojo.Category;

@Service
public class BaseAdminCategoryService implements AdminCategoryService {

	@Autowired
	private AdminCategoryDao categoryDao;


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
