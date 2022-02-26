package uz.pcmarket.apppcmarketrestfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pcmarket.apppcmarketrestfull.entity.Computer;
import uz.pcmarket.apppcmarketrestfull.entity.Product;
import uz.pcmarket.apppcmarketrestfull.payload.ComputerDto;
import uz.pcmarket.apppcmarketrestfull.payload.Message;
import uz.pcmarket.apppcmarketrestfull.repository.ComputerRepository;
import uz.pcmarket.apppcmarketrestfull.repository.ModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    private ModelRepository modelRepository;

    public List<Computer> getAll(){
        return computerRepository.findAll();
    }
    public Computer getById(Long id){
        return computerRepository.findById(id).orElse(null);
    }

    public Message add(ComputerDto computerDto){

        Optional<Product> productOptional = modelRepository.findById(computerDto.getModelId());

        if (productOptional.isEmpty()){
            return new Message(false, "Category not found");
        }
        Computer computer = new Computer(
                null,
                computerDto.getName(),
                computerDto.getCpu(),
                computerDto.getGpu(),
                computerDto.getHdd(),
                computerDto.getRam(),
                computerDto.getSsd(),
                computerDto.getPrice(),
                computerDto.getDiagonal(),
                computerDto.getPowerUnit(),
                computerDto.getMotherBoard(),
                productOptional.get()
        );
        computerRepository.save(computer);
        return new Message(true, "Product added");
    }

    public Message deleteById(Long id){
        try {
            computerRepository.deleteById(id);
            return new Message(true, "Success deleted");
        }
        catch (Exception e){
            return new Message(false, "Error is not deleted");
        }
    }

}
