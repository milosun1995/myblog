package com.milosun.myblog.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "TB_CATEGORY")
public class Category extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String categoryName;
	
	private String categoryRank;
	private Byte isDeleted;
	
	@OneToMany
	@JoinColumn(name = "CATEGORY_ID")
	@OrderBy("updateTime desc")
    private Set<Blog> blogs;

	public Category() {
		super();
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Category [categoryName=");
		builder.append(categoryName);
		builder.append(", categoryRank=");
		builder.append(categoryRank);
		builder.append(", isDeleted=");
		builder.append(isDeleted);
		builder.append(", blogs=");
		builder.append(blogs);
		builder.append("]");
		return builder.toString();
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
