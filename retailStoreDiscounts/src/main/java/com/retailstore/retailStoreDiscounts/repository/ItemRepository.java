package com.retailstore.retailStoreDiscounts.repository;

import com.retailstore.retailStoreDiscounts.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
