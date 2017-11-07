package com.example.myeShop.query.repository.cart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
@Repository
public interface CartEntryRepository extends MongoRepository<CartEntry, String> {

    CartEntry findOneByCartId(Long id);

}
