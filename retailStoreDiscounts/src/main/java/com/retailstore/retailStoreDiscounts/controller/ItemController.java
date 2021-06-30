package com.retailstore.retailStoreDiscounts.controller;

import com.retailstore.retailStoreDiscounts.model.Item;
import com.retailstore.retailStoreDiscounts.model.User;
import com.retailstore.retailStoreDiscounts.repository.ItemRepository;
import com.retailstore.retailStoreDiscounts.repository.UserRepository;
import com.retailstore.retailStoreDiscounts.service.ItemService;
import com.retailstore.retailStoreDiscounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/item/")
@CrossOrigin("http://localhost:4200")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("item/save")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        try {
            Item _item= itemRepository.save(new Item(item.getItemId(),item.getItemType(),item.getPrice()));

            return  new ResponseEntity<>(_item, HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping("/item/list")
    public List<Item> getAllItem(){
        return itemService.getAllItems();
    }

}
