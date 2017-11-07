package com.example.myeShop.cart.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
public class RemoveItemCommand {

    @TargetAggregateIdentifier
    private Long cartId;
    private Long itemId;

    public RemoveItemCommand(Long cartId, Long itemId) {
        this.cartId = cartId;
        this.itemId = itemId;
    }

    public static final RemoveItemCommand aRemoveItemCommand(Long cartId, Long itemId) {
        return new RemoveItemCommand(cartId, itemId);
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getItemId() {
        return itemId;
    }

}
