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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name = "";

	private String description = "";

	@Column(name = "delivery_option_type")
	private String deliveryOptionType;

	private String imageurls;

	@Column(name = "normal_price")
	private double normalPrice = 0;

	@Column(name = "discounted_price")
	private double discountedPrice = 0;

	@Column(name = "currency_code")
	private String currencyCode = "EUR";

	@Column(name = "available_days")
	private String availableDays;

	@Column(name = "available_time")
	private String availableTime;

	@Column(name = "quantity_value")
	private short quantityValue = 0;

	@Column(name = "quantity_unit")
	private String quantityUnit = "";

	private float rating;

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
		this.availableDays = availableDays.trim();
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime.trim();
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
		this.quantityUnit = quantityUnit.trim();
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
}
