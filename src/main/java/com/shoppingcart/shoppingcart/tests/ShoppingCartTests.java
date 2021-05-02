package com.shoppingcart.shoppingcart.tests;

import com.shoppingcart.shoppingcart.models.CartItem;
import com.shoppingcart.shoppingcart.models.Customer;
import com.shoppingcart.shoppingcart.models.Product;
import com.shoppingcart.shoppingcart.repositories.CartItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

    @Autowired
    private CartItemRepository cartRep;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    private void testAddOneCartItem() {
        Product product = entityManager.find(Product.class, 20);
        Customer customer = entityManager.find(Customer.class, 5);

        CartItem newItem = new CartItem();
        newItem.setCustomer(customer);
        newItem.setProduct(product);
        newItem.setQuantity(1);

      CartItem savedCartItem =  cartRep.save(newItem);

      assertTrue(savedCartItem.getId() > 0);
    }
}
