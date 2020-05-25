package com.milosun.myblog.visitors.service;

import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorsBlogServiceTest {
	
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
		System.out.println(this.visitorsBlogService.findBlogById(1L).toString());
		assertNull(this.visitorsBlogService.findBlogById(1L));
	}
}
