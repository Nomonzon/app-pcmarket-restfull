package uz.pcmarket.apppcmarketrestfull.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pcmarket.apppcmarketrestfull.entity.Computer;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    List<Computer> findByModelId(Long model_id);

    @Query(value = "SELECT * FROM laptop l" +
            " JOIN model on model_id = model.id"+
            " WHERE l.model_id=:modelId", nativeQuery = true)
    List<Computer> getLaptopsByModel(Long modelId);



}
