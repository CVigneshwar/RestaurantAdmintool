package com.yourdelicacy.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<com.yourdelicacy.restaurant.model.Item, Long> {

}
