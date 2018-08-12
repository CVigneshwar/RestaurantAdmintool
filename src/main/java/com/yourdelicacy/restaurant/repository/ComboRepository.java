package com.yourdelicacy.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yourdelicacy.restaurant.model.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {

}
