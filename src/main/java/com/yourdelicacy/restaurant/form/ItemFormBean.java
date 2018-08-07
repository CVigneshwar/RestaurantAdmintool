package com.yourdelicacy.restaurant.form;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

public class ItemFormBean {
	private long id;
	private String name;
	private String caption;
	private String description;
	private String deliveryOptionType;
	private String dietType;
	private String itemType;
	private String imageurls;
	private double normalPrice;
	private double discountedPrice;
	private String currencyCode;
	private String availableDays;
	private String availableTime;
	private String ingredients;
	private String categoryType;
	private short quantityValue;
	private String quantityUnit;
	private float rating;
	private String preparedAt;
	private String coverageDistance;
	private double normalPriceForCustomcombo;
	private double discountedPriceForCustomcombo;
	private boolean allowedForCustomcombo;
	private boolean allowedForIndividualSale;
	private boolean soldOut;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeliveryOptionType() {
		return deliveryOptionType;
	}

	public void setDeliveryOptionType(String deliveryOptionType) {
		this.deliveryOptionType = deliveryOptionType;
	}

	public String getDietType() {
		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getImageurls() {
		return imageurls;
	}

	public void setImageurls(String imageurls) {
		this.imageurls = imageurls;
	}

	public double getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}


	public short getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(short quantityValue) {
		this.quantityValue = quantityValue;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getPreparedAt() {
		return preparedAt;
	}

	public void setPreparedAt(String preparedAt) {
		this.preparedAt = preparedAt;
	}

	public String getCoverageDistance() {
		return coverageDistance;
	}

	public void setCoverageDistance(String coverageDistance) {
		this.coverageDistance = coverageDistance;
	}

	public boolean isVegetarian() {
		return "VEGETARIAN".equalsIgnoreCase(this.dietType) || "VEG".equalsIgnoreCase(this.dietType);
	}

	public double getNormalPriceForCustomcombo() {
		return normalPriceForCustomcombo;
	}

	public void setNormalPriceForCustomcombo(double normalPriceForCustomcombo) {
		this.normalPriceForCustomcombo = normalPriceForCustomcombo;
	}

	public double getDiscountedPriceForCustomcombo() {
		return discountedPriceForCustomcombo;
	}

	public void setDiscountedPriceForCustomcombo(double discountedPriceForCustomcombo) {
		this.discountedPriceForCustomcombo = discountedPriceForCustomcombo;
	}

	public boolean isAllowedForCustomcombo() {
		return allowedForCustomcombo;
	}

	public void setAllowedForCustomcombo(boolean allowedForCustomcombo) {
		this.allowedForCustomcombo = allowedForCustomcombo;
	}

	public boolean isAllowedForIndividualSale() {
		return allowedForIndividualSale;
	}

	public void setAllowedForIndividualSale(boolean allowedForIndividualSale) {
		this.allowedForIndividualSale = allowedForIndividualSale;
	}

	public boolean isSoldOut() {
		return soldOut;
	}

	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}

}