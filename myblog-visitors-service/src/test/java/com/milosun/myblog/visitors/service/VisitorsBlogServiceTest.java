package com.milosun.myblog.visitors.service;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.milosun.myblog.pojo.Blog;
import com.milosun.myblog.visitors.interfaces.VisitorsBlogService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorsBlogServiceTest {
	
	private static Logger logger = LoggerFactory.getLogger(VisitorsBlogServiceTest.class);
	
	@Autowired
	private VisitorsBlogService visitorsBlogService;
	
	@Before
	public void setUp(){
	}
	
	@After
	public void tearDown(){
	}
	
	@Test
	public void findBlogByIdTest() {
		Blog blog = this.visitorsBlogService.findBlogById(1L);
		assertNotNull(blog);
		logger.info("BlogId:{}",blog.getId());
		logger.info("CategoryName:{}",blog.getCategory().getCategoryName());
		logger.info("Nickame:{}",blog.getUser().getNickname());
	}
	
	@Test
	public void findAllTest() {
		Pageable pageable =PageRequest.of(0, 4,Sort.by(Order.desc("updateTime")));
		Page<Blog> blogs = this.visitorsBlogService.findAll(pageable);
		assertNotNull(blogs);
		blogs.forEach(b -> {
			logger.info("b.getTitle():{}",b.getTitle());
			logger.info("b.getBlogCategory().getCategoryName():{}",b.getCategory().getCategoryName());
			logger.info("b.getBlogUser().getNickname():{}",b.getUser().getNickname());
		});
	}
}
