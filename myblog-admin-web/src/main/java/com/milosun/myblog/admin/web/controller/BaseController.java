package com.milosun.myblog.admin.web.controller;

import org.springframework.ui.Model;

import com.milosun.myblog.common.constant.WebConstant;

public class BaseController {

	
	/**
	 * 定义通用 model
	 * @param model
	 */
	 protected void prepareConfigModel(Model model) {
		model.addAttribute(WebConstant.ADD_REQUEST, "./edit/-1");
		model.addAttribute(WebConstant.BATCH_DELETE_REQUEST, "./batchDelete?ids=");
		model.addAttribute(WebConstant.EDIT_REQUEST, "./edit/");
	}
	 
	 
	 protected  String recallQuery(Model model) {
		 return WebConstant.QUERY_REDIRECT;
	 }
	 
	 protected  String recallEdit(Model model) {
		 return WebConstant.QUERY_EDIT;
	 }
}
