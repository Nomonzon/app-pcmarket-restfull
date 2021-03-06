package uz.pcmarket.apppcmarketrestfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'MODERATOR', 'OPERATOR')")
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<Computer> computerList = computerService.getAll();

        return computerList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'MODERATOR', 'OPERATOR')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdProduct(@PathVariable Long id){
        Computer serviceById = computerService.getById(id);
        return serviceById != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'MODERATOR', 'OPERATOR')")
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ComputerDto computerDto){
        Message message = computerService.add(computerDto);
        return message.isSuccess()
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        Message message = computerService.deleteById(id);
        return message.isSuccess()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize(value =  "hasAnyRole('SUPER_ADMIN', 'MODERATOR')")
    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@PathVariable Long id, @RequestBody ComputerDto computerDto){
        Message message = computerService.update(id, computerDto);
        return message.isSuccess()
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
