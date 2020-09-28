package com.milosun.myblog.pojo.validate.annotation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

/**
 * 自定义参数校验注解 校验 Entity 对象中ID是否null
 */
@NotNull
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EntityIdNotNullValidatorImpl.class)
public @interface EntityIdNotNull {

	String message() default "ID Not Null!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
