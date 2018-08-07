package com.yourdelicacy.restaurant.utils;

import java.util.List;

import org.springframework.util.StringUtils;

import com.yourdelicacy.restaurant.form.ComboFormBean;
import com.yourdelicacy.restaurant.model.Item;


public final class ComboUtil {

	public static ComboFormBean prepareComboFormbeanBasedOnSelectedItems(List<Item> itemsToBeAddedToCombo) {
		ComboFormBean comboFormBean = new ComboFormBean();
		itemsToBeAddedToCombo.stream().forEach(item -> {
			comboFormBean.setDescription(
					comboFormBean.getDescription() + " " + item.getName() + ": " + item.getDescription());
			comboFormBean.setAvailableDays(addText(comboFormBean.getAvailableDays(), item.getAvailableDays()));
			comboFormBean.setAvailableTime(addText(comboFormBean.getAvailableTime(), item.getAvailableTime()));
			comboFormBean.setQuantityUnit(addText(comboFormBean.getQuantityUnit(), item.getQuantityUnit()));
			comboFormBean.setQuantityValue((short)(comboFormBean.getQuantityValue() + item.getQuantityValue()));
			comboFormBean.setDeliveryOptionType(comboFormBean.getDeliveryOptionType());
			comboFormBean.setDiscountedPrice(addNum(comboFormBean.getDiscountedPrice(), item.getDiscountedPrice()));
			comboFormBean.setNormalPrice(comboFormBean.getNormalPrice() + item.getNormalPrice());
		});
		return comboFormBean;
	}

	private static String addText(String text1, String text2) {
		return (StringUtils.isEmpty(text1) ? text2 : text1 + " | " + text2).replaceAll("\\|$", "");
	}

	private static double addNum(double num1, double num2) {
		if (num1 == 0.0) {
			return num2 == 0.0 ? 0 : num2;
		} else {
			return num1 + (num2 == 0.0 ? 0 : num2);
		}
	}
}
