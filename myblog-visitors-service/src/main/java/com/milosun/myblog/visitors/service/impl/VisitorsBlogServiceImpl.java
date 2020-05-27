package com.milosun.myblog.visitors.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsBlogDao;
import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.visitors.service.VisitorsBlogService;

@Service
public class VisitorsBlogServiceImpl implements VisitorsBlogService {

	@Autowired
	private VisitorsBlogDao visitorsBlogDao;
	
	@Override
	public Blog findBlogById(Long id) {
		return visitorsBlogDao.findBlogById(id);
	}

	/**
	 * 博客列表显示
	 * @param pageable
	 * @return
	 */
	public Page<Blog> findAll(Pageable pageable) {
		return this.visitorsBlogDao.findAll(pageable);
	}
}
