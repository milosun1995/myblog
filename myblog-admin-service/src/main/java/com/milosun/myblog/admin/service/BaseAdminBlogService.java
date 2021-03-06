package com.milosun.myblog.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milosun.myblog.admin.interfaces.AdminBlogService;
import com.milosun.myblog.dao.admin.AdminBlogDao;
import com.milosun.myblog.pojo.Blog;

@Service
public class BaseAdminBlogService implements AdminBlogService {

	@Autowired
	private AdminBlogDao blogDao;
	
	
	/**
	 * 博客内容查看
	 */
	@Override
	public Blog findBlogById(Long id) {
		return this.blogDao.findBlogById(id);
	}

	/**
	 * 博客列表分页显示
	 * @param pageable
	 * @return
	 */
	public Page<Blog> findAll(Pageable pageable) {
		return this.blogDao.findAll(pageable);
	}
	
	/**
	 * 查询列表
	 */
	@Override
	public List<Blog> findAll() {
		return this.blogDao.findAll();
	}

	/**
	 * 保存文章
	 */
	@Override
	@Transactional
	public Blog save(Blog blog){
		return this.blogDao.save(blog);
	}

	/**
	 * 批量删除
	 */
	@Override
	@Transactional
	public void deleteBatch(List<Long> ids) {
		this.blogDao.deleteBatch(ids);
	}
	
}
