package com.milosun.myblog.dao.visitors;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.milosun.myblog.pojo.Blog;
@Repository
public interface VisitorsBlogDao extends PagingAndSortingRepository<Blog, Long>,QueryByExampleExecutor<Blog> {
	
	public Blog findBlogById(Long id);
}
