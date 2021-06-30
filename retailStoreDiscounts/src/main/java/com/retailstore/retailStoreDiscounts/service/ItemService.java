package com.retailstore.retailStoreDiscounts.service;

import com.retailstore.retailStoreDiscounts.exception.RecordNotFoundException;
import com.retailstore.retailStoreDiscounts.model.Item;
import com.retailstore.retailStoreDiscounts.model.User;
import com.retailstore.retailStoreDiscounts.repository.ItemRepository;
import com.retailstore.retailStoreDiscounts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    //create record
    public Item createUpdateItem(Item item) throws RecordNotFoundException
    {
        Optional<Item> isitem = itemRepository.findById(item.getItemId());
        if(isitem.isPresent())
        {
            Item newitem = isitem.get();
            newitem.setItemType(item.getItemType());
            newitem.setPrice(item.getPrice());



            newitem = itemRepository.save(newitem);
            return newitem;
        } else {
           item = itemRepository.save(item);
            return item;
        }
    }//end create record
    //list all records
    public List<Item> getAllItems()
    {
        List<Item> itemList = itemRepository.findAll();

        if(itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Item>();
        }
    }//end list all records
}
