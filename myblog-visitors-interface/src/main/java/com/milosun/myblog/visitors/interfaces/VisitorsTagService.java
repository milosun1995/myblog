package com.milosun.myblog.visitors.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Tag;

public interface VisitorsTagService {

	public Tag findTagById(Long id);
	
	public Page<Tag> findAll(Pageable pageable);
	
	public List<Tag> findAll();
}
