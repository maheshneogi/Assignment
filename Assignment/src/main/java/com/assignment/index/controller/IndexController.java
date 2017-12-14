package com.assignment.index.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.index.service.IndexService;

@Controller
@RequestMapping("/user")
public class IndexController {
	
	@Autowired
	IndexService indexService;
	
	
	@RequestMapping("/index")
	public String showIndexPage() {		
		return "app/index";
	}
	
	@RequestMapping("syncStats")
	@ResponseBody
	public String syncData(@RequestParam String link, @RequestParam String country, @RequestParam String dataFor)
	{
		
		return indexService.syncStats(link, country, dataFor).toString();
	}
	
	
	@RequestMapping("viewStats")
	@ResponseBody
	public String syncData(@RequestParam String country, @RequestParam String dataFor, @RequestParam JSONArray year)
	{
		
		return indexService.viewStats(country, dataFor, year).toString();
	}
	
	
	@RequestMapping("getFilterData")
	@ResponseBody
	public String getFilterData(@RequestParam String country, @RequestParam String dataFor)
	{
		
		return indexService.getFilterData(country, dataFor).toString();
	}
	

}
