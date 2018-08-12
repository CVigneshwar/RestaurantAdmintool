package com.yourdelicacy.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "combo")
public class Combo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	@Column(name = "delivery_option_type")
	private String deliveryOptionType;

	private String imageurls;

	@Column(name = "normal_price")
	private Double normalPrice;

	@Column(name = "discounted_price")
	private Double discountedPrice;

	@Column(name = "currency_code")
	private String currencyCode = "EUR";

	@Column(name = "available_days")
	private String availableDays;

	@Column(name = "available_time")
	private String availableTime;

	@Column(name = "quantity_value")
	private Short quantityValue;

	@Column(name = "quantity_unit")
	private String quantityUnit;

	private Float rating;
	
	@Column(name = "category_type")
	private String categoryType;
	
	@Column(name = "item_ids")
	private String itemIds;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.trim();
	}

	public String getDeliveryOptionType() {
		return deliveryOptionType;
	}

	public void setDeliveryOptionType(String deliveryOptionType) {
		this.deliveryOptionType = deliveryOptionType.trim();
	}

	public String getImageurls() {
		return imageurls;
	}

	public void setImageurls(String imageurls) {
		this.imageurls = imageurls;
	}

	public Double getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(Double normalPrice) {
		this.normalPrice = normalPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
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
		this.availableDays = availableDays.trim();
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime.trim();
	}

	public Short getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(Short quantityValue) {
		this.quantityValue = quantityValue;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit.trim();
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getItemIds() {
		return itemIds;
	}

	public void setItemIds(String itemIds) {
		this.itemIds = itemIds;
	}
}
