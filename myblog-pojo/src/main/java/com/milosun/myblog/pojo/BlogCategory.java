package com.milosun.myblog.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BLOG_CATEGORY")
public class BlogCategory extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String categoryName;
	private String categoryRank;
	private Byte isDeleted;
	
	@OneToMany
	@JoinColumn(name = "CATEGORY_ID")
    private Set<Blog> blogs;

	public BlogCategory() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryRank() {
		return categoryRank;
	}

	public void setCategoryRank(String categoryRank) {
		this.categoryRank = categoryRank;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

}
