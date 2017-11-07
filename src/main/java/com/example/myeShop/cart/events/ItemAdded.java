package com.example.myeShop.cart.events;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
public class ItemAdded {

    private Long cartId;
    private Long itemId;

    public ItemAdded() {
    }

    public ItemAdded(Long cartId, Long itemId) {
        this.cartId = cartId;
        this.itemId = itemId;
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getItemId() {
        return itemId;
    }
}
