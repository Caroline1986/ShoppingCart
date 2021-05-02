package com.shoppingcart.shoppingcart.repositories;

import com.shoppingcart.shoppingcart.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
