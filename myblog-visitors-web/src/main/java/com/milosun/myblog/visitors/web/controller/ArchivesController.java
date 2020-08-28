package com.milosun.myblog.visitors.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 归档 - 控制器
 * @author MiloSun
 *
 */
@Controller
public class ArchivesController {
	private static Logger logger = LoggerFactory.getLogger(ArchivesController.class);
	
	@GetMapping("/archives/{id}")
	public String showArchives(@PathVariable Long id,Model model) {
		logger.info("Into archives~~ {}",id);
		return "archives";
	}
}
