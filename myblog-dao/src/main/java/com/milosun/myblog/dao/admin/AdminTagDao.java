package com.milosun.myblog.dao.admin;

import org.springframework.stereotype.Repository;

import com.milosun.myblog.dao.base.BaseTagDao;
import com.milosun.myblog.pojo.Tag;

@Repository
public interface AdminTagDao extends BaseTagDao{

	public Tag findTagByTagName(String tagName);
}
