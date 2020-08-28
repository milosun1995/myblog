package com.milosun.myblog.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.milosun.myblog.common.constant.WebConstant;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return  WebConstant.INDEX_HTML;
	}
}
