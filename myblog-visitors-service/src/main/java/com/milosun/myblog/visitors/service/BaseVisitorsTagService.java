package com.milosun.myblog.visitors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsTagDao;
import com.milosun.myblog.pojo.Tag;
import com.milosun.myblog.visitors.interfaces.VisitorsTagService;

@Service
public class BaseVisitorsTagService implements VisitorsTagService {

	@Autowired
	private VisitorsTagDao tagDao;


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
}
