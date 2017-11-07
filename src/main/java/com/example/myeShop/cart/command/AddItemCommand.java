package com.example.myeShop.cart.command;


import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
public class AddItemCommand {

    @TargetAggregateIdentifier
    private Long cartId;
    private Long itemId;

    public AddItemCommand(Long cartId, Long itemId) {
        this.cartId = cartId;
        this.itemId = itemId;
    }

    public static final AddItemCommand anAddItemCommand(Long cartId, Long itemId) {
        return new AddItemCommand(cartId, itemId);
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getItemId() {
        return itemId;
    }

}
