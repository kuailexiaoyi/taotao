package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.manager.pojo.Item;
import com.taotao.manager.service.ItemService;

@RequestMapping("item")
@ResponseBody
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String saveItem(Item item, String desc) {
		String msg = "0";
		try {
			itemService.saveItem(item, desc);
		} catch (Exception e) {
			msg = "1";
			e.printStackTrace();
		}

		return msg;

	}
}
