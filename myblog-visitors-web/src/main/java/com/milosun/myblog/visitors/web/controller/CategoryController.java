package com.milosun.myblog.visitors.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 分类 - 控制器
 * 
 * @author MiloSun
 *
 */
@Controller
public class CategoryController extends BaseController {

	@GetMapping("/categories/{id}")
	public String showCategories(@PathVariable Long id, Model model) {
		System.out.println("Into categories~~ " + id);
		return "category";
	}
}
