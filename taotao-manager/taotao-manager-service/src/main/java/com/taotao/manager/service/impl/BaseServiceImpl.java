package com.taotao.manager.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.taotao.manager.pojo.BasePojo;
import com.taotao.manager.service.BaseService;

public class BaseServiceImpl<T extends BasePojo> implements BaseService<T> {

	@Autowired
	Mapper<T> mapper;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		// 获取父类的type
		Type type = this.getClass().getGenericSuperclass();
		// 强转为ParmmeterizedType
		ParameterizedType pType = (ParameterizedType) type;

		// 获取泛型的class
		clazz = (Class<T>) pType.getActualTypeArguments()[0];
	}

	@Override
	public T queryById(Long id) {

		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> queryyAll() {

		return mapper.select(null);
	}

	@Override
	public Integer queryCountByWhere(T t) {

		return mapper.selectCount(t);
	}

	@Override
	public List<T> queryListByWhere(T t) {

		return mapper.select(t);
	}

	@Override
	public List<T> queryByPage(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		return mapper.select(null);
	}

	@Override
	public T queryOne(T t) {

		return mapper.selectOne(t);
	}

	@Override
	public void save(T t) {
		if (t.getCreated() == null) {
			t.setCreated(new Date());
			t.setUpdated(t.getCreated());
		} else if (t.getUpdated() == null) {
			t.setUpdated(t.getUpdated());
		}
		mapper.insert(t);
	}

	@Override
	public void saveSelective(T t) {
		if (t.getCreated() == null) {
			t.setCreated(new Date());
			t.setUpdated(t.getCreated());
		} else if (t.getUpdated() == null) {
			t.setUpdated(t.getUpdated());
		}
		mapper.insertSelective(t);

	}

	@Override
	public void updateById(T t) {
		t.setUpdated(new Date());
		mapper.updateByPrimaryKey(t);

	}

	@Override
	public void updateByIdSelective(T t) {
		t.setUpdated(new Date());
		mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteByID(Long id) {

		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(List<Object> ids) {
		Example example = new Example(clazz);

		Criteria criteria = example.createCriteria();

		criteria.andIn("id", ids);

		mapper.deleteByExample(example);
	}

}
