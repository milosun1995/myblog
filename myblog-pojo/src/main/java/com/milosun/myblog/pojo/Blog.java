package com.milosun.myblog.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BLOG")
public class Blog extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String title;

	private String description;

	private Byte articleType;

	private Byte coverImage;

	private Long countViews;

	private String content;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private BlogCategory category;

	private String tagIds;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private BlogUser user;

	private Byte status;

	private Byte enableComment;

	public Blog() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getArticleType() {
		return articleType;
	}

	public void setArticleType(Byte articleType) {
		this.articleType = articleType;
	}

	public Byte getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Byte coverImage) {
		this.coverImage = coverImage;
	}

	public Long getCountViews() {
		return countViews;
	}

	public void setCountViews(Long countViews) {
		this.countViews = countViews;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public BlogCategory getCategory() {
		return category;
	}

	public void setCategory(BlogCategory category) {
		this.category = category;
	}

	public BlogUser getUser() {
		return user;
	}

	public void setUser(BlogUser user) {
		this.user = user;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getEnableComment() {
		return enableComment;
	}

	public void setEnableComment(Byte enableComment) {
		this.enableComment = enableComment;
	}

}
