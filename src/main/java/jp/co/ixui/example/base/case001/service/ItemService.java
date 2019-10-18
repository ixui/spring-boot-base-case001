package jp.co.ixui.example.base.case001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ixui.example.base.case001.domain.Item;
import jp.co.ixui.example.base.case001.mapper.ItemMapper;

@Service
public class ItemService {

	@Autowired
	ItemMapper itemMapper;
	
	public List<Item> fetchAll() {
		return this.itemMapper.fetchAll();
	}

	public Item fetchById(Long id) {
		return this.itemMapper.fetchById(id);
	}

	public void create(Item item) {
		this.itemMapper.create(item);
	}

	public void update(Item item) {
		this.itemMapper.update(item);
	}

	public void destroy(Long id) {
		this.itemMapper.destroy(id);
	}

	
}
