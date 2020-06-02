package com.milosun.myblog.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milosun.myblog.pojo.Tag;


public interface BaseTagDao extends JpaRepository<Tag, Long>{
	
	public Tag findTagById(Long id);

}
