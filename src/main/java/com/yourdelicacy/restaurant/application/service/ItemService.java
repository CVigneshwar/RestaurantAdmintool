package com.yourdelicacy.restaurant.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourdelicacy.restaurant.model.Item;


@Service
public interface ItemService {

	public Item create(Item Item);

	public void delete(int id);

	public List<Item> findAll();

	public Item update(Item Item);

	public Item findById(int id);

	public List<Item> getSelectedItemAsList(String itemIds);

}
