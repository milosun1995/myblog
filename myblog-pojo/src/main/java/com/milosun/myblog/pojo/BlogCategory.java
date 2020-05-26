package com.milosun.myblog.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BLOG_CATEGORY")
public class BlogCategory extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String categoryName;
	private String categoryRank;
	private Byte isDeleted;

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
}
