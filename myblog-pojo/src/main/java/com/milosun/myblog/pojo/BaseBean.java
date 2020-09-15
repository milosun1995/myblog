package com.milosun.myblog.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected Long id;
	
	@Column(name = "CREATE_TIME")
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createTime;

	@Column(name = "UPDATE_TIME")
	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateTime;

	public BaseBean() {
	}
	
	public BaseBean(@NotNull Long id, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseBean [id=").append(id).append(", createTime=").append(createTime).append(", updateTime=")
				.append(updateTime).append("]");
		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
