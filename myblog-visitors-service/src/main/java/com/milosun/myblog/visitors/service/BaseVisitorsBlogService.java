package com.milosun.myblog.visitors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsBlogDao;
import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.visitors.interfaces.VisitorsBlogService;

@Service
public class BaseVisitorsBlogService implements VisitorsBlogService {

	@Autowired
	private VisitorsBlogDao blogDao;
	
	/**
	 * 博客内容查看
	 */
	@Override
	public Blog findBlogById(Long id) {
		return this.blogDao.findBlogById(id);
	}

	/**
	 * 博客列表显示
	 * @param pageable
	 * @return
	 */
	public Page<Blog> findAll(Pageable pageable) {
		return this.blogDao.findAll(pageable);
	}

	@Override
	public List<Blog> findAll() {
		return this.blogDao.findAll();
	}
}
