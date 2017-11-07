package com.example.myeShop.query.repository.cart;

import com.example.myeShop.query.repository.item.ItemEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
@Document(collection = "carts")
public class CartEntry {

    @Id
    private String id;

    private Long cartId;
    private List<ItemEntry> items;

    public CartEntry() {
    }

    public CartEntry(Long cartId) {
        this.cartId = cartId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<ItemEntry> getItems() {
        return items;
    }

    public void setItems(List<ItemEntry> items) {
        this.items = items;
    }

    public void addItem(ItemEntry item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    public void removeItem(ItemEntry item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.remove(item);
    }
}
