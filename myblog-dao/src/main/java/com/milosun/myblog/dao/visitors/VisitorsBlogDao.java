package com.milosun.myblog.dao.visitors;

import org.springframework.stereotype.Repository;

import com.milosun.myblog.dao.base.BaseBlogDao;
import com.milosun.myblog.pojo.Blog;

@Repository
public interface VisitorsBlogDao extends BaseBlogDao{

	Blog findBlogById(Long id);
}
