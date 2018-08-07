package com.yourdelicacy.restaurant.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourdelicacy.restaurant.model.Combo;

@Service
public interface ComboService {

	public Combo create(Combo combo);

	public void delete(int id);

	public List<Combo> findAll();

	public Combo update(Combo combo);

	public Combo findById(int id);

}
