package com.milosun.myblog.admin.interfaces;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.milosun.myblog.pojo.Tag;

public interface AdminTagService {

	public Tag findTagById(Long id);
	
	public Tag findTagByTagName(String tagName);
	
	public Page<Tag> findAll(Pageable pageable);
	
	public List<Tag> findAll();
	
	public Set<Tag> save(List<String> tagNames);
}
