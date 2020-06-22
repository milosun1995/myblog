package com.milosun.myblog.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAG")
public class Tag extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String tagName;
	private Byte isDeleted;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "TB_BLOG_TAG", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"))
//	private Set<Blog> blogs;
	
	public Tag() {
		super();
	}

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public Set<Blog> getBlogs() {
//		return blogs;
//	}
//
//	public void setBlogs(Set<Blog> blogs) {
//		this.blogs = blogs;
//	}

}
