package com.milosun.myblog.pojo.validate.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.milosun.myblog.pojo.BaseBean;

/**
 * 自定义参数校验注解实现类
 * 校验 Entity 对象中ID是否null
 */
public class EntityIdNotNullValidatorImpl implements ConstraintValidator<EntityIdNotNull, BaseBean>{

	@Override
	public boolean isValid(BaseBean bean, ConstraintValidatorContext context) {
		if(!StringUtils.isEmpty(bean.getId()))
			return true;
		return false;
	}

}
