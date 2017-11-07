package com.example.myeShop.query.repository.item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bogdan.Gherca on 11/6/2017.
 */
@Repository
public interface ItemEntryRepository extends MongoRepository<ItemEntry, String> {

    ItemEntry findOneByItemId(Long id);

}
