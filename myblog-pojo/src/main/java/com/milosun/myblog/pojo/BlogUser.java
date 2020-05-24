package com.milosun.myblog.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="TB_USER")
public class BlogUser extends BaseBean{
	
	private static final long serialVersionUID = 1L;
	
    private String nickame;
    private String username;
    private String password;
    private Byte locked;
	
	public BlogUser() {
		super();
	}

	public String getNickame() {
		return nickame;
	}

	public void setNickame(String nickame) {
		this.nickame = nickame;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getLocked() {
		return locked;
	}

	public void setLocked(Byte locked) {
		this.locked = locked;
	}

}
