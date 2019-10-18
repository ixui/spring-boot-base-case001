package jp.co.ixui.example.base.case001.controller.dto;

import org.springframework.beans.BeanUtils;

import jp.co.ixui.example.base.case001.domain.Item;

public class ItemDto {

	private Long id;
	private String name;

	public ItemDto() {
		
	}

	public ItemDto(Item item) {
		if (item == null) item = new Item(); 
		BeanUtils.copyProperties(item, this);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
