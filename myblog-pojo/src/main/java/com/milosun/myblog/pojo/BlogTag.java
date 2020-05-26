package com.milosun.myblog.pojo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BLOG_TAG")
public class BlogTag extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String tagName;
	private Byte isDeleted;

	@OneToOne(mappedBy = "blogCategory")
	private Blog blog;

	public BlogTag() {
		super();
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

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
