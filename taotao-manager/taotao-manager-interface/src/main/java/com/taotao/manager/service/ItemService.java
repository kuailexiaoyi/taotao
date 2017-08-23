package com.taotao.manager.service;

import com.taotao.manager.pojo.Item;

public interface ItemService extends BaseService<Item> {

	public void saveItem(Item item, String desc);
}