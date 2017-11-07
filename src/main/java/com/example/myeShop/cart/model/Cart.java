package com.example.myeShop.cart.model;

import com.example.myeShop.cart.command.*;
import com.example.myeShop.cart.events.CartCreated;
import com.example.myeShop.cart.events.ItemAdded;
import com.example.myeShop.cart.events.ItemRemoved;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by Bogdan.Gherca on 10/24/2017.
 */
@Aggregate
public class Cart {

    @AggregateIdentifier
    private Long id;
    private List<Item> items;

    public Cart() {
    }

    @CommandHandler
    public Cart(CreateCartCommand command) {
        apply(new CartCreated(command.getCartId()));
    }

    @CommandHandler
    public void addItem(AddItemCommand command) {
        apply(new ItemAdded(command.getCartId(), command.getItemId()));
    }

    @CommandHandler
    public void removeItem(RemoveItemCommand command) {
        apply(new ItemRemoved(command.getCartId(), command.getItemId()));
    }

    @EventSourcingHandler
    public void on(CartCreated event) {
        this.id = event.getId();
        this.items = new ArrayList<>();
    }

    @EventSourcingHandler
    public void on(ItemAdded event) {
        // TODO: fetch item by id, then add it, is this neccesary?
        this.items.add(new Item(event.getItemId()));
    }

    @EventSourcingHandler
    public void on(ItemRemoved event) {
        this.items.remove(new Item(event.getItemId()));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
