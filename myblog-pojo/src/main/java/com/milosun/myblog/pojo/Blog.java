package com.milosun.myblog.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_BLOG")
public class Blog extends BaseBean{

	private static final long serialVersionUID = 1L;
	
	private String title;
    private String description;
    private String articleType;
    private String coverImage;
    private Long countViews;

    private String content;
    private Long categoryId;
    private String tagIds;

    private int userId;
    private Byte status;

    private Byte enableComment;

	public Blog() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Blog [title=").append(title).append(", description=").append(description)
				.append(", articleType=").append(articleType).append(", coverImage=").append(coverImage)
				.append(", countViews=").append(countViews).append(", content=").append(content).append(", categoryId=")
				.append(categoryId).append(", tagIds=").append(tagIds).append(", userId=").append(userId)
				.append(", status=").append(status).append(", enableComment=").append(enableComment).append("]");
		return builder.toString();
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

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
