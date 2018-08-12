package com.yourdelicacy.restaurant.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
	
	@RequestMapping("/getAllCombos")
	public String getAllCombos(HttpServletRequest request, Model model) {
		model.addAttribute("combos", comboService.findAll());
		return "comboInventory";
	}

	@RequestMapping("/prepareCombo/selectStarters")
	public String getStarters(HttpServletRequest request, Model model) {
		List<Item> itemList = itemService.findAll();
		List<Item> items = itemList.stream().filter(item -> "STARTERS".equals(item.getItemType())).collect(Collectors.toList());
		model.addAttribute("items", items);
		model.addAttribute("nextAction", "/repository/combo/prepareCombo/selectMainCourse?itemIds=");
		model.addAttribute("stepSelectStarters",true);
		return "prepareCombo";
	}

	@RequestMapping(value = "/prepareCombo/selectMainCourse")
	public String getMainCourse(HttpServletRequest request, Model model,
			@RequestParam(value = "itemIds", required=false) String itemIds) {
		System.out.printf("Starters itemIds to prepareCombo {}", itemIds);
		List<Item> itemList = itemService.findAll();
		List<Item> items = itemList.stream().filter(item -> "MAIN_COURSE".equals(item.getItemType())).collect(Collectors.toList());
		model.addAttribute("items", items);
		model.addAttribute("stepSelectMainCourse",true);
		model.addAttribute("nextAction", "/repository/combo/prepareCombo/selectDesserts?itemIds="+itemIds+",");
		return "prepareCombo";
	}
	
	@RequestMapping(value = "/prepareCombo/selectDesserts")
	public String getDesserts(HttpServletRequest request, Model model,
			@RequestParam(value = "itemIds", required=false) String itemIds) {
		System.out.printf("Selected starter and mainCourse itemIds to prepareCombo {}", itemIds);
		List<Item> itemList = itemService.findAll();
		List<Item> items = itemList.stream().filter(item -> "DESSERTS".equals(item.getItemType())).collect(Collectors.toList());
		model.addAttribute("items", items);
		model.addAttribute("nextAction", "/repository/combo/prepareCombo/showComboForm?itemIds="+itemIds+",");
		model.addAttribute("stepSelectDesserts",true);
		return "prepareCombo";
	}
	
	@RequestMapping(value = "/prepareCombo/showComboForm")
	public String getComboFormBean(HttpServletRequest request, Model model,
			@RequestParam(value = "itemIds", required=false) String itemIds) {
		System.out.printf("Selected itemIds to prepareCombo {}", itemIds);
		List<String> itemIdList = new ArrayList<String>(Arrays.asList(itemIds.split(",")));
		List<Item> itemsSelectedForCombo = new ArrayList<>();
		itemIdList.stream().forEach(id ->{
			if(StringUtils.hasText(id)){
			Item item = itemService.findById(Long.parseLong(id));	
			itemsSelectedForCombo.add(item);
			}
		});
		if(itemsSelectedForCombo.isEmpty() || itemsSelectedForCombo.size()<2){
			return null;
		}
		ComboFormBean comboFormBean = prepareComboFormBean(itemsSelectedForCombo);
		
		comboFormBean.setItemIds(itemIds);
		model.addAttribute("combo", comboFormBean);
		model.addAttribute("nextAction", "/repository/combo/createCombo");
		return "createCombo";
	}
	
	@RequestMapping(value = "/prepareCombo/editCombo")
	public String getComboFormBeanToEdit(HttpServletRequest request, Model model,
			@RequestParam(value = "comboId") String comboId) {
		System.out.println("Combo to be edited " + comboId);
		Combo combo = comboService.findById(Long.parseLong(comboId));
		
		ComboFormBean comboFormBean = prepareComboFormBeanToEdit(combo);
		model.addAttribute("combo", comboFormBean);
		model.addAttribute("isItemToBeEdited", true);
		model.addAttribute("nextAction", "/repository/combo/updateCombo");
		return "createCombo";
	}


	@RequestMapping(value = "/createCombo")
	public String createCombo(HttpServletRequest request, Model model, @ModelAttribute ComboFormBean comboFormBean) {
		comboService.create(prepareComboFromInput(comboFormBean));
		System.out.println(comboFormBean.getName() + "- combo created");
		return getAllCombos(request, model);
	}
	
	@RequestMapping(value = "/updateCombo")
	public String updateCombo(HttpServletRequest request, Model model, @ModelAttribute ComboFormBean comboFormBean) {
		Combo comboToUpdate = prepareComboFromInput(comboFormBean);
		comboToUpdate.setId(comboFormBean.getId());
		comboService.update(comboToUpdate);
		System.out.println(comboFormBean.getName() + "- combo updated");
		return getAllCombos(request, model);
	}

	@RequestMapping(value = "/deleteCombo")
	public String deleteCombo(HttpServletRequest request, Model model,
			@RequestParam(value = "comboId") String comboId) {
			comboService.delete(Long.parseLong(comboId));
			System.out.println("combo" + comboId + "deleted");
		return getAllCombos(request, model);
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
		combo.setItemIds(comboFormBean.getItemIds().replaceAll(", $", ""));
		return combo;
	}
	
	private ComboFormBean prepareComboFormBeanToEdit(Combo combo) {
		ComboFormBean comboFormBean = new ComboFormBean();
		comboFormBean.setAvailableDays(combo.getAvailableDays());
		comboFormBean.setAvailableTime(combo.getAvailableTime());
		comboFormBean.setCategoryType(combo.getCategoryType());
		comboFormBean.setCurrencyCode(combo.getCurrencyCode());
		comboFormBean.setDeliveryOptionType(combo.getDeliveryOptionType());
		comboFormBean.setDescription(combo.getDescription());
		comboFormBean.setDiscountedPrice(combo.getDiscountedPrice());
		comboFormBean.setId(combo.getId());
		comboFormBean.setImageurls(combo.getImageurls());
		comboFormBean.setItemIds(combo.getItemIds());
		comboFormBean.setName(combo.getName());
		comboFormBean.setNormalPrice(combo.getNormalPrice());
		comboFormBean.setQuantityUnit(combo.getQuantityUnit());
		comboFormBean.setQuantityValue(combo.getQuantityValue());
		comboFormBean.setRating(combo.getRating());
		return comboFormBean;
	}

	private ComboFormBean prepareComboFormBean(List<Item> itemsSelectedForCombo) {
		ComboFormBean comboFormBean = new ComboFormBean();
		itemsSelectedForCombo.forEach(item->{
			comboFormBean.setCurrencyCode(comboFormBean.getCurrencyCode());
			comboFormBean.setDiscountedPrice(Double.sum(comboFormBean.getDiscountedPrice(),item.getDiscountedPrice()));
			comboFormBean.setName(comboFormBean.getName() + " " + item.getName());
			comboFormBean.setNormalPrice(Double.sum(comboFormBean.getNormalPrice(), item.getNormalPrice()));
		});
		return comboFormBean;
	}
}
