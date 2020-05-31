package com.milosun.myblog.visitors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsBlogCategoryDao;
import com.milosun.myblog.pojo.BlogCategory;
import com.milosun.myblog.visitors.service.VisitorsBlogCategoryService;

@Service
public class VisitorsBlogCategoryServiceImpl implements VisitorsBlogCategoryService {

	@Autowired
	private VisitorsBlogCategoryDao visitorsBlogCategoryDao;


	@Override
	public BlogCategory findBlogCategoryById(Long id) {
		return this.visitorsBlogCategoryDao.findBlogCategoryById(id);
	}

	@Override
	public List<BlogCategory> findAll() {
		return this.visitorsBlogCategoryDao.findAll();
	}

	@Override
	public Page<BlogCategory> findAll(Pageable pageable) {
		return this.visitorsBlogCategoryDao.findAll(pageable);
	}
}
