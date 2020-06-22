package com.milosun.myblog.admin.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public List<Tag> findAll() {
		return this.tagDao.findAll();
	}

	@Override
	public Page<Tag> findAll(Pageable pageable) {
		return this.tagDao.findAll(pageable);
	}

	@Override
	public Set<Tag> save(Set<Tag> tags) {
		return new HashSet<Tag>(tagDao.saveAll(tags));
	}
}
