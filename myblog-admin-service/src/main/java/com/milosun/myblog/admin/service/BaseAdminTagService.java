package com.milosun.myblog.admin.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.milosun.myblog.admin.interfaces.AdminTagService;
import com.milosun.myblog.dao.admin.AdminTagDao;
import com.milosun.myblog.pojo.Tag;

@Service
public class BaseAdminTagService implements AdminTagService {

	@Autowired
	private AdminTagDao tagDao;


	@Override
	public Tag findTagById(Long id) {
		return this.tagDao.findTagById(id);
	}

	@Override
	public Tag findTagByTagName(String tagName) {
		return this.tagDao.findTagByTagName(tagName);
	}
	
	@Override
	public List<Tag> findAll() {
		return this.tagDao.findAll();
	}

	@Override
	public Page<Tag> findAll(Pageable pageable) {
		return this.tagDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Set<Tag> save(List<String> tagNames) {
		//定义新增Tag集合
		List<Tag> insertTags = new ArrayList<>();
		//定义修改Tag集合
		List<Tag> updateTags = new ArrayList<>();
		
		//分类新增/修改逻辑处理
		tagNames.forEach(t -> {
			Tag tag = this.findTagByTagName(t);
			if(StringUtils.isEmpty(tag)) {
				insertTags.add(new Tag(t));
			}else {
				updateTags.add(tag);
			}
		});
		
		//合并Tag集合,保存数据库
		insertTags.addAll(updateTags);
		return new HashSet<>(this.tagDao.saveAll(insertTags));
		//返回空集合
//		return Collections.emptySet();
	}
}
