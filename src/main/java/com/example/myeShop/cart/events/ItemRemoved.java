package com.example.myeShop.cart.events;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
public class ItemRemoved {

    private Long cartId;
    private Long itemId;

    public ItemRemoved() {
    }

    public ItemRemoved(Long cartId, Long itemId) {
        this.cartId = cartId;
        this.itemId = itemId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
