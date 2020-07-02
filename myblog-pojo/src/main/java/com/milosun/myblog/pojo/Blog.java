package com.milosun.myblog.pojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BLOG_CATEGORY_ID"))
	private Category category;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TB_BLOG_TAG", joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<Tag> tags;

	private String tagIds;
	
	private String tagNames;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BLOG_USER_ID"))
	private BlogUser user;

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
				.append(", countViews=").append(countViews).append(", content=").append(content).append(", category=")
				.append(category).append(", tags=").append(tags).append(", tagIds=").append(tagIds).append(", user=")
				.append(user).append(", status=").append(status).append(", enableComment=").append(enableComment)
				.append("]");
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
	
	public String getTagNames() {
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	public List<String> buildTagNames(){
		if(StringUtils.isEmpty(this.tagNames)) {
			return Collections.emptyList();
		}
		return Arrays.asList(this.tagNames.split(","));
	}

}
