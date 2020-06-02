package com.milosun.myblog.visitors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milosun.myblog.dao.visitors.VisitorsTagDao;
import com.milosun.myblog.pojo.Tag;
import com.milosun.myblog.visitors.service.VisitorsTagService;

@Service
public class VisitorsTagServiceImpl implements VisitorsTagService {

	@Autowired
	private VisitorsTagDao visitorsTagDao;


	@Override
	public Tag findTagById(Long id) {
		return this.visitorsTagDao.findTagById(id);
	}

	@Override
	public List<Tag> findAll() {
		return this.visitorsTagDao.findAll();
	}

	@Override
	public Page<Tag> findAll(Pageable pageable) {
		return this.visitorsTagDao.findAll(pageable);
	}
}
