package com.yourdelicacy.restaurant.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourdelicacy.restaurant.application.service.ComboServiceImpl;
import com.yourdelicacy.restaurant.application.service.ItemServiceImpl;
import com.yourdelicacy.restaurant.form.ComboFormBean;
import com.yourdelicacy.restaurant.model.Combo;
import com.yourdelicacy.restaurant.model.Item;
import com.yourdelicacy.restaurant.utils.ComboUtil;


@Controller
@RequestMapping("/combo")
public class ComboController {

	@Autowired
	ComboServiceImpl comboService;

	@Autowired
	ItemServiceImpl itemService;

	@RequestMapping("/showAllItems")
	public String getAvailableItems(HttpServletRequest request, Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("items", itemList);
		model.addAttribute("combos", comboService.findAll());
		return "prepareCombo";
	}

	@RequestMapping(value = "/prepareCombo")
	public String prepareComboItems(HttpServletRequest request, Model model,
			@RequestParam(value = "itemIds") String itemIds) {
		System.out.printf("Selected itemIds to prepareCombo {}", itemIds);
		List<Item> itemsToBeAddedToCombo = itemService.getSelectedItemAsList(itemIds);
		model.addAttribute("combo", ComboUtil.prepareComboFormbeanBasedOnSelectedItems(itemsToBeAddedToCombo));
		return "createCombo";
	}

	@RequestMapping(value = "/createCombo")
	public String createCombo(HttpServletRequest request, Model model, @ModelAttribute ComboFormBean comboFormBean) {
		comboService.create(prepareComboFromInput(comboFormBean));
		System.out.println(comboFormBean.getName() + "- combo created");
		return getAvailableItems(request, model);
	}

	@RequestMapping(value = "/deleteCombo")
	public String deleteCombo(HttpServletRequest request, Model model,
			@RequestParam(value = "itemIds") String itemIds) {
		List<String> itemIdList = Arrays.asList(StringUtils.split(itemIds, ","));
		itemIdList.stream().forEach(id -> {
			comboService.delete(Integer.parseInt(id));
			System.out.println("combo" + id + "deleted");
		});
		return getAvailableItems(request, model);
	}

	private com.yourdelicacy.restaurant.model.Combo prepareComboFromInput(ComboFormBean comboFormBean) {
		Combo combo = new Combo();
		combo.setAvailableDays(comboFormBean.getAvailableDays());
		combo.setAvailableTime(comboFormBean.getAvailableTime());
		combo.setCurrencyCode(comboFormBean.getCurrencyCode());
		combo.setDeliveryOptionType(comboFormBean.getDeliveryOptionType());
		combo.setDescription(comboFormBean.getDescription());
		combo.setDiscountedPrice(comboFormBean.getDiscountedPrice());
		combo.setImageurls(comboFormBean.getImageurls());
		combo.setName(comboFormBean.getName());
		combo.setNormalPrice(comboFormBean.getNormalPrice());
		combo.setQuantityUnit(comboFormBean.getQuantityUnit());
		combo.setQuantityValue(comboFormBean.getQuantityValue());
		combo.setRating(comboFormBean.getRating());
		return combo;
	}
}
