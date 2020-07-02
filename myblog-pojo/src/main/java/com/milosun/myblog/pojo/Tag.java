package com.milosun.myblog.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAG")
public class Tag extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String tagName;
	private Byte isDeleted;

	public Tag() {
		super();
	}

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [tagName=").append(tagName).append(", isDeleted=").append(isDeleted).append("]");
		return builder.toString();
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

}
