package com.example.myeShop.cart.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by Bogdan.Gherca on 10/24/2017.
 */

public class CreateCartCommand {

    @TargetAggregateIdentifier
    private Long cartId;

    public CreateCartCommand(Long cartId) {
        this.cartId = cartId;
    }

    public static final CreateCartCommand aCreateCartCommand(Long cartId) {
        return new CreateCartCommand(cartId);
    }

    public Long getCartId() {
        return cartId;
    }
}
