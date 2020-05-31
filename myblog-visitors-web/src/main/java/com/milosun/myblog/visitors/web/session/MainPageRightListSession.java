package com.milosun.myblog.visitors.web.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.milosun.myblog.pojo.BlogCategory;
import com.milosun.myblog.pojo.BlogTag;
import com.milosun.myblog.pojo.BlogUser;

/**
 * Session 作用域
 * 
 * TODO 预留
 * @author sunjiliang
 *
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = WebApplicationContext.SCOPE_SESSION)
public class MainPageRightListSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 博客分类
	 */
	private BlogCategory category;
	
	/**
	 * 标签信息
	 */
	private BlogTag tag;
	
	/**
	 * 博主信息
	 */
	private BlogUser user;

	public MainPageRightListSession() {
		super();
	}

	public MainPageRightListSession(BlogCategory category, BlogTag tag, BlogUser user) {
		super();
		this.category = category;
		this.tag = tag;
		this.user = user;
	}

	public BlogCategory getCategory() {
		return category;
	}

	public void setCategory(BlogCategory category) {
		this.category = category;
	}

	public BlogTag getTag() {
		return tag;
	}

	public void setTag(BlogTag tag) {
		this.tag = tag;
	}

	public BlogUser getUser() {
		return user;
	}

	public void setUser(BlogUser user) {
		this.user = user;
	}
	
}
