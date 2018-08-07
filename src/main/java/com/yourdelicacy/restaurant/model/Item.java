package com.yourdelicacy.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String caption;
	private String description;
	@Column(name = "delivery_option_type")
	private String deliveryOptionType;
	@Column(name = "diet_type")
	private String dietType;
	@Column(name = "item_type")
	private String itemType;
	
	private String imageurls;
	@Column(name = "normal_price")
	private Integer normalPrice;
	@Column(name = "discounted_price")
	private Integer discountedPrice;
	@Column(name = "currency_code")
	private String currencyCode;
	@Column(name = "available_days")
	private String availableDays;
	@Column(name = "available_time")
	private String availableTime;
	private String ingredients;
	@Column(name = "category_type")
	private String categoryType;
	@Column(name = "quantity_value")
	private Integer quantityValue;
	@Column(name = "quantity_unit")
	private String quantityUnit;
	private Integer rating;
	@Column(name = "prepared_at")
	private String preparedAt;
	@Column(name = "coverage_distance")
	private String coverageDistance;
	@Column(name = "normal_price_for_customcombo")
	private Integer normalPriceForCustomcombo;
	@Column(name = "discounted_price_for_customcombo")
	private Integer discountedPriceForCustomcombo;
	@Column(name = "allowed_for_customcombo")
	private boolean allowedForCustomcombo;
	@Column(name = "allowed_for_individual_sale")
	private boolean allowedForIndividualSale;
	@Column(name = "sold_out")
	private boolean soldOut;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(Integer normalPrice) {
		this.normalPrice = normalPrice;
	}

	public Integer getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
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

	public Integer getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(Integer quantityValue) {
		this.quantityValue = quantityValue;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
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
		return "VEGETARIAN".equalsIgnoreCase(this.dietType);
	}

	public boolean isEuro() {
		return "EUR".equalsIgnoreCase(this.currencyCode);
	}

	public Integer getNormalPriceForCustomcombo() {
		return normalPriceForCustomcombo;
	}

	public void setNormalPriceForCustomcombo(Integer normalPriceForCustomcombo) {
		this.normalPriceForCustomcombo = normalPriceForCustomcombo;
	}

	public Integer getDiscountedPriceForCustomcombo() {
		return discountedPriceForCustomcombo;
	}

	public void setDiscountedPriceForCustomcombo(Integer discountedPriceForCustomcombo) {
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