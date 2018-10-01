package com.frontline.dao;

import java.util.List;
import com.frontline.model.Item;

public interface ItemDAO {

	public boolean addItem(Item item);
	public boolean deleteItem(Item item);
	public boolean updateItem(Item item);
	public List<Item> listItems();
	public Item getItem(int itemid);
}
