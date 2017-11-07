package com.example.myeShop.query;

import com.example.myeShop.cart.events.CartCreated;
import com.example.myeShop.cart.events.ItemAdded;
import com.example.myeShop.cart.events.ItemRemoved;
import com.example.myeShop.query.repository.cart.CartEntry;
import com.example.myeShop.query.repository.cart.CartEntryRepository;
import com.example.myeShop.query.repository.item.ItemEntry;
import com.example.myeShop.query.repository.item.ItemEntryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Bogdan.Gherca on 10/24/2017.
 */
@Component
public class CartEventListener {

    private static final Logger logger = LoggerFactory.getLogger(CartEventListener.class);

    @Autowired
    private CartEntryRepository cartEntryRepository;

    @Autowired
    private ItemEntryRepository itemEntryRepository;

    @EventHandler
    public void on(CartCreated event) {
        CartEntry cartEntry = new CartEntry(event.getId());

        cartEntryRepository.save(cartEntry);
        logger.info("Cart with id {} was created successfully", event.getId());
    }

    @EventHandler
    public void on(ItemAdded event) {
        CartEntry cartEntry = cartEntryRepository.findOneByCartId(event.getCartId());
        ItemEntry itemEntry = itemEntryRepository.findOneByItemId(event.getItemId());

        // add item to cart
        cartEntry.addItem(itemEntry);
        cartEntryRepository.save(cartEntry);
        logger.info("Item {} was added to cart {}", itemEntry, cartEntry.getId());
    }

    @EventHandler
    public void on(ItemRemoved event) {
        CartEntry cartEntry = cartEntryRepository.findOneByCartId(event.getCartId());

        // remove item from cart
        ItemEntry existingItemEntry = new ItemEntry();
        existingItemEntry.setItemId(event.getItemId());
        cartEntry.removeItem(existingItemEntry);
        cartEntryRepository.save(cartEntry);
        logger.info("Item {} was removed from cart {}", existingItemEntry, cartEntry.getId());
    }

}
