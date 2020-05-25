package com.milosun.myblog.dao.visitors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.milosun.myblog.pojo.Blog;

@Repository
public interface VisitorsBlogDao extends CrudRepository<Blog, Long> {
	
	public Blog findBlogById(Long id);
	
}
