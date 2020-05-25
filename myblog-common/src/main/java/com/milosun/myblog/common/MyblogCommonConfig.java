package com.milosun.myblog.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.milosun.myblog.dao")
@EntityScan(basePackages = "com.milosun.myblog.pojo")
public class MyblogCommonConfig {

}
