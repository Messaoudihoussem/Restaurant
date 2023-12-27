package com.Menu.Menu.controller;

import com.Menu.Menu.model.Items;
import com.Menu.Menu.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ItemsController {

    @Autowired
    ItemsRepository itemsRepository;

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Items>> getAllItems(){
        try{
            List<Items> itemsList = new ArrayList<>();
            itemsRepository.findAll().forEach(itemsList::add);
        if (itemsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        return new ResponseEntity<>(itemsList,HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addItems")
    public ResponseEntity<Items> addItems(@RequestBody Items items) {
        try {
            Items itemsobjet = itemsRepository.save(items);
            return new ResponseEntity<>(itemsobjet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/updateItems/{id}")
    public ResponseEntity<Items> updateItems(@PathVariable Long id, @RequestBody Items items) {
        try {
            Optional<Items> itemsData = itemsRepository.findById(id);
            if (itemsData.isPresent()) {
                Items updateditemsData = itemsData.get();
                updateditemsData.setTitle(items.getTitle());
                updateditemsData.setImg(items.getImg());
                updateditemsData.setPrice(items.getPrice());
                Items itemsobjet = itemsRepository.save(updateditemsData);
                return new ResponseEntity<>(itemsobjet, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteItemsById/{id}")
    public ResponseEntity<HttpStatus> deleteItems(@PathVariable Long id) {
        try {
            itemsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
