package com.taotao.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.manager.service.ItemDescService;
import com.taotao.manager.service.ItemService;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

	@Autowired
	private ItemDescService itemDescService;

	public void saveItem(Item item, String desc) {
		// 保存商品
		item.setStatus(1);
		super.save(item);

		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);

		itemDescService.save(itemDesc);
	}
}