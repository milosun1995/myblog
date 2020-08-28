package com.milosun.myblog.common.constant;

public class WebConstant {

	private WebConstant() {
		throw new IllegalStateException("WebConstantEnum class");
	}
	
	//Request
	public static final String ADD_REQUEST 						= "addUrl"; 
	public static final String EDIT_REQUEST 					= "editUrl"; 
	public static final String QUERY_REQUEST 					= "queryUrl"; 
	public static final String BATCH_DELETE_REQUEST				= "batchDeleteUrl";
	
	//Redirect
	public static final String QUERY_REDIRECT					= "redirect:query";
	
	
	//HTML
	public static final String INDEX_HTML 						= "index"; 
	public static final String BLOG_HTML 						= "blog"; 
	public static final String CATEGORY_HTML 					= "category"; 
	
	
	//Category
	public static final String CATEGORY_KEY 					= "category"; 
	public static final String CATEGORIES_KEY 					= "categories"; 
	public static final String ACTIVE_CATEGORYID_KEY 			= "activeCategoryId"; 

	//Blog
	public static final String BLOG_KEY 						= "blog"; 
	public static final String BLOGS_KEY 						= "blogs"; 

	//Page
	public static final String PAGE_KEY 						= "page"; 
	
	//Errors
	public static final String ERRORS_KEY 						= "errors"; 
	public static final String ERRORS_NOT_FOUND_DATA_VALUE 		= "404 - 查无数据！"; 
	
	
}