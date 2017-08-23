package com.taotao.manager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taotao.manager.pojo.ItemCat;
import com.taotao.manager.service.ItemCatService;

@Service
public class ItemCatServiceImpl extends BaseServiceImpl<ItemCat> implements ItemCatService {

	/*
	 * (non-Javadoc) 查询多级列表数据。
	 */
	@Override
	public List<ItemCat> queryItemCatByParentId(Long parentId) {
		// 设置查询条件。
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);

		List<ItemCat> list = super.queryListByWhere(itemCat);

		return list;
	}

}