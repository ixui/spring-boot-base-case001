package jp.co.ixui.example.base.case001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.ixui.example.base.case001.domain.Item;


@Mapper
public interface ItemMapper {

	public List<Item> fetchAll();
	public Item fetchById(Long id);
	public void create(Item item);
	public void update(Item item);
	public void destroy(Long id);
}
