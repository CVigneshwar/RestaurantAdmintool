package com.yourdelicacy.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yourdelicacy.restaurant.application.service.ItemServiceImpl;
import com.yourdelicacy.restaurant.form.ItemFormBean;
import com.yourdelicacy.restaurant.model.Item;


@Controller
@RequestMapping("/selectItem")
public class ItemController {

	private static final String[] ALLOWED_FIELDS = new String[] { "item*" };

	@InitBinder("item")
	protected void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(ALLOWED_FIELDS);
	}

	@Autowired
	ItemServiceImpl itemService;

	@RequestMapping("/showAllItems")
	public String getAvailableItems(HttpServletRequest request, Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("items", itemList);
		return "itemInventory";
	}

	@RequestMapping("/editItem")
	public ModelAndView editSelectedItem(HttpServletRequest request, @RequestParam(value = "itemId") int itemId,
			Model model) {
		Item item = itemService.findById(itemId);
		ItemFormBean itemFormBean = new ItemFormBean();
		prepareItemFormBean(itemFormBean, item);
		ModelAndView modelAndView = new ModelAndView("addOrEditItem");
		model.addAttribute("item", itemFormBean);
		model.addAttribute("isItemToBeEdited", true);
		return modelAndView;
	}

	@RequestMapping("/addItem")
	public ModelAndView addNewItem(HttpServletRequest request, Model model) {
		Item itemToBeAdded = new Item();
		ModelAndView modelAndView = new ModelAndView("addOrEditItem");
		model.addAttribute("item", itemToBeAdded);
		model.addAttribute("isItemToBeEdited", false);
		return modelAndView;
	}

	@RequestMapping("/deleteItem")
	public String deleteItem(HttpServletRequest request, Model model, @RequestParam(value = "itemId") int itemId) {
		itemService.delete(itemId);
		return getAvailableItems(request, model);
	}
	
	@RequestMapping("/setAvailablity")
	public String deleteItem(HttpServletRequest request, Model model,@RequestParam(value = "soldOut") boolean soldOut ,@RequestParam(value = "itemId") int itemId) {
		Item item = itemService.findById(itemId);
		item.setSoldOut(soldOut);
		itemService.update(item);
		return getAvailableItems(request, model);
	}

	@RequestMapping(value = "/addOrUpdateItem", method = RequestMethod.POST)
	public String addOrUpdateItems(HttpServletRequest request, Model model,
			@RequestParam(value = "isItemToBeEdited") boolean isItemToBeEdited,
			@ModelAttribute ItemFormBean itemFormBean) {
		Item item = new Item();
		if (isItemToBeEdited) {
			item = itemService.findById(itemFormBean.getId());
		}
		prepareItemEntity(item, itemFormBean);
		if (isItemToBeEdited) {
			itemService.update(item);
			model.addAttribute("itemUpdated", item.getName());
		} else {
			//setNextId(item, itemService.findAll());
			itemService.create(item);
			model.addAttribute("itemAdded", item.getName());
		}
		List<Item> itemList = itemService.findAll();
		model.addAttribute("items", itemList);
		return "itemInventory";
	}

	private void setNextId(Item itemToBeUpdated, List<Item> itemList) {

		int maxId = 0;
		for(Item item:itemList) {
			maxId = Math.max(maxId, item.getId());
		}
		itemToBeUpdated.setId(maxId+1);
	}

	private void prepareItemEntity(Item item, ItemFormBean itemFormBean) {
		item.setAvailableDays(itemFormBean.getAvailableDays());
		item.setAvailableTime(itemFormBean.getAvailableTime());
		item.setCaption(itemFormBean.getCaption());
		item.setCategoryType(itemFormBean.getCategoryType());
		item.setCoverageDistance(itemFormBean.getCoverageDistance());
		item.setCurrencyCode(itemFormBean.getCurrencyCode());
		item.setDeliveryOptionType(itemFormBean.getDeliveryOptionType());
		item.setDescription(itemFormBean.getDescription());
		item.setDietType(itemFormBean.getDietType());
		item.setDiscountedPrice(itemFormBean.getDiscountedPrice());
		item.setId(itemFormBean.getId());
		item.setImageurls(itemFormBean.getImageurls());
		item.setIngredients(itemFormBean.getIngredients());
		item.setItemType(itemFormBean.getItemType());
		item.setName(itemFormBean.getName());
		item.setNormalPrice(itemFormBean.getNormalPrice());
		item.setPreparedAt(itemFormBean.getPreparedAt());
		item.setQuantityUnit(itemFormBean.getQuantityUnit());
		item.setQuantityValue(itemFormBean.getQuantityValue());
		item.setRating(itemFormBean.getRating());
		item.setAllowedForCustomcombo(itemFormBean.isAllowedForCustomcombo());
		item.setAllowedForIndividualSale(itemFormBean.isAllowedForIndividualSale());
		item.setDiscountedPriceForCustomcombo(itemFormBean.getDiscountedPriceForCustomcombo());
		item.setNormalPriceForCustomcombo(itemFormBean.getNormalPriceForCustomcombo());
		item.setSoldOut(itemFormBean.isSoldOut());
	}

	private void prepareItemFormBean(ItemFormBean itemFormBean, Item item) {
		itemFormBean.setAvailableDays(item.getAvailableDays());
		itemFormBean.setAvailableTime(item.getAvailableTime());
		itemFormBean.setCaption(item.getCaption());
		itemFormBean.setCategoryType(item.getCategoryType());
		itemFormBean.setCoverageDistance(item.getCoverageDistance());
		itemFormBean.setCurrencyCode(item.getCurrencyCode());
		itemFormBean.setDeliveryOptionType(item.getDeliveryOptionType());
		itemFormBean.setDescription(item.getDescription());
		itemFormBean.setDietType(item.getDietType());
		itemFormBean.setDiscountedPrice(item.getDiscountedPrice());
		itemFormBean.setId(item.getId());
		itemFormBean.setImageurls(item.getImageurls());
		itemFormBean.setIngredients(item.getIngredients());
		itemFormBean.setItemType(item.getItemType());
		itemFormBean.setName(item.getName());
		itemFormBean.setNormalPrice(item.getNormalPrice());
		itemFormBean.setPreparedAt(item.getPreparedAt());
		itemFormBean.setQuantityUnit(item.getQuantityUnit());
		itemFormBean.setQuantityValue(item.getQuantityValue());
		itemFormBean.setRating(item.getRating());
		itemFormBean.setAllowedForCustomcombo(item.isAllowedForCustomcombo());
		itemFormBean.setAllowedForIndividualSale(item.isAllowedForIndividualSale());
		itemFormBean.setSoldOut(item.isSoldOut());
		itemFormBean.setNormalPriceForCustomcombo(item.getNormalPriceForCustomcombo());
		itemFormBean.setDiscountedPriceForCustomcombo(item.getDiscountedPriceForCustomcombo());
		
	}
}
