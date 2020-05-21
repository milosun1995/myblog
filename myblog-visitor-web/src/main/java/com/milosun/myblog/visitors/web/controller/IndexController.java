package com.milosun.myblog.visitors.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页访问控制器
 * @author MiloSun
 *
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		System.out.println("Into index~~");
		return "index";
	}
}



