package com.taotao.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.ItemCatService;

@Controller
@RequestMapping("page")
public class PageController {

	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("{pageName}")
	public String toPage(@PathVariable("pageName") String pageName, Integer rows) {
		return pageName;
	}

	@RequestMapping("query/{page}")
	@ResponseBody
	public List<ItemCat> queryItemCatByPage(@PathVariable("page") Integer page, Integer rows) {

		List<ItemCat> list = this.itemCatService.queryByPage(page, rows);

		return list;
	}
}
