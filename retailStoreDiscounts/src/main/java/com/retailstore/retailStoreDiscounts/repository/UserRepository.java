package com.retailstore.retailStoreDiscounts.repository;

import com.retailstore.retailStoreDiscounts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
