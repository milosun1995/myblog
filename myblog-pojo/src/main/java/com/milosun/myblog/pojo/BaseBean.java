package com.milosun.myblog.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@MappedSuperclass
public class BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	protected Long id;
	
	@Column(name = "CREATE_TIME")
	protected Date createTime;

	@Column(name = "UPDATE_TIME")
	protected Date updateTime;

	
	public BaseBean() {
		super();
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
