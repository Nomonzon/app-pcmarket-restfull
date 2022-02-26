package uz.pcmarket.apppcmarketrestfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pcmarket.apppcmarketrestfull.entity.Computer;
import uz.pcmarket.apppcmarketrestfull.payload.ComputerDto;
import uz.pcmarket.apppcmarketrestfull.payload.Message;
import uz.pcmarket.apppcmarketrestfull.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<Computer> computerList = computerService.getAll();

        return computerList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdProduct(@PathVariable Long id){
        Computer serviceById = computerService.getById(id);
        return serviceById != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ComputerDto computerDto){
        Message message = computerService.add(computerDto);
        return message.isSuccess()
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        Message message = computerService.deleteById(id);
        return message.isSuccess()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
