package com.milosun.myblog.dao.admin;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.milosun.myblog.dao.base.BaseBlogDao;

@Repository
public interface AdminBlogDao extends BaseBlogDao{

	@Modifying
    @Query("delete from Blog b where b.id in (?1)")
    void deleteBatch(List<Long> ids);
}
