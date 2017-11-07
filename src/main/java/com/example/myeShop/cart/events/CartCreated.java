package com.example.myeShop.cart.events;

/**
 * Created by Bogdan.Gherca on 10/24/2017.
 */
public class CartCreated {

    private Long id;

    public CartCreated() {
    }

    public CartCreated(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
