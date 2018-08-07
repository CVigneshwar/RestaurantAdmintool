package com.yourdelicacy.restaurant.application.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.yourdelicacy.restaurant.model.Combo;
import com.yourdelicacy.restaurant.repository.ComboRepository;


@Service
public class ComboServiceImpl implements ComboService {

	@Resource
	private ComboRepository comboRepository;

	@Override
	@Transactional
	public Combo create(Combo Combo) {
		Combo createdCombo = Combo;
		return comboRepository.save(createdCombo);
	}

	@Override
	@Transactional
	public Combo findById(int id) {
		Optional<Combo> combo = comboRepository.findById(id);
		return combo.orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		comboRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Combo> findAll() {
		return comboRepository.findAll();
	}

	@Override
	@Transactional
	public Combo update(Combo combo) {
		Combo updatedCombo = comboRepository.save(combo);
		return updatedCombo;
	}

}
