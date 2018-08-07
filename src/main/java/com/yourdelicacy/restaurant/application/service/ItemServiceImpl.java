package com.yourdelicacy.restaurant.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yourdelicacy.restaurant.model.Item;
import com.yourdelicacy.restaurant.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemRepository itemRepository;

	@Override
	@Transactional
	public Item create(Item item) {
		Item createdItem = itemRepository.save(item);
		System.out.println(createdItem.getName() + " has been added");
		return createdItem;
	}

	@Override
	@Transactional
	public Item findById(long id) {
		Optional<Item> item = itemRepository.findById(id);
		return item.orElse(null);
	}

	@Override
	@Transactional
	public void delete(long id) {
		itemRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	@Transactional
	public Item update(Item item) {
		Item updatedItem = itemRepository.save(item);
		System.out.println(item.getName() + " has been updated");
		return updatedItem;
	}

	@Override
	@Transactional
	public List<Item> getSelectedItemAsList(String itemIds) {
		List<Item> itemList = new ArrayList<>();
		List<String> itemIdList = Arrays.asList(StringUtils.split(itemIds, ","));
		itemIdList.stream().forEach(itemId -> {
			Optional<Item> itemToBeAdded = itemRepository.findById(Long.valueOf(itemId));
			itemList.add(itemToBeAdded.orElse(null));
		});
		return itemList;
	}

}
