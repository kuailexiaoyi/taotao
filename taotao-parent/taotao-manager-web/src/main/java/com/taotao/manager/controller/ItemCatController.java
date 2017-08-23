package com.taotao.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.ItemCatService;

@RequestMapping("item")
@ResponseBody
@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping(value = "cat", method = RequestMethod.GET)
	@ResponseBody
	public List<ItemCat> queryItemCatByParentId(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

		return itemCatService.queryItemCatByParentId(parentId);
	}
}
