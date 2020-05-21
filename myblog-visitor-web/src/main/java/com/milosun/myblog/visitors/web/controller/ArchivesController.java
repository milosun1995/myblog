package com.milosun.myblog.visitors.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 归档控制器
 * @author MiloSun
 *
 */
@Controller
public class ArchivesController {

	@GetMapping("/archives/{id}")
	public String index(@PathVariable Long id,Model model) {
		System.out.println("Into archives~~ "+id);
		return "archives";
	}
}
