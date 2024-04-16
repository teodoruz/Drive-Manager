package com.example.ServiceManager.Services;

import com.example.ServiceManager.Models.DTOs.ItemDTO;
import com.example.ServiceManager.Models.Item;
import com.example.ServiceManager.Repository.ItemRepository;
import com.example.ServiceManager.Services.Exceptions.EmptyEntityError;
import com.example.ServiceManager.Services.Exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item insertItem(@RequestBody ItemDTO itemDTO){
        if(itemDTO.getTitle().isEmpty()){
            throw new EmptyEntityError("the name field cannot be empty");
        }
        Item item = new Item();
        item.setTitle(itemDTO.getTitle());
        return itemRepository.save(item);
    }

    public ResponseEntity<Item> getItemById(Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("the Id" + id + "not found"));
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    public ResponseEntity<List<Item>> findAll(){
        List<Item> itemsInList = itemRepository.findAll();
        return new ResponseEntity<>(itemsInList, HttpStatus.OK);
    }

    public void deleteItemById(Long id){
        ResponseEntity<Item> excludeItem = this.getItemById(id);
        if(excludeItem == null){
            throw new EntityNotFoundException("the Id" + id + "not found");
        }else {
            itemRepository.deleteById(id);
        }
    }
    public ResponseEntity<List<Item>> findItemByName(String keyword){
        List<Item> itemList = itemRepository.findByTitle(keyword);
        if(itemList.isEmpty()){
            throw new EntityNotFoundException("the keyword" + keyword + "not found");
        }else {
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        }

    }
}
