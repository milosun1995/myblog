package com.milosun.myblog.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * 扫描DAO、POJO包
 * @author MiloSun
 *
 */
@EnableJpaRepositories("com.milosun.myblog.dao")
@EntityScan(basePackages = "com.milosun.myblog.pojo")
@ComponentScan(basePackages = {"com.milosun.myblog"})
public class MyblogCommonConfig {

}
