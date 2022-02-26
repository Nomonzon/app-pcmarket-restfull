package uz.pcmarket.apppcmarketrestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pcmarket.apppcmarketrestfull.entity.Product;
import uz.pcmarket.apppcmarketrestfull.projection.CustomModel;


@RepositoryRestResource(excerptProjection = CustomModel.class, path = "model", collectionResourceRel = "list")
public interface ModelRepository extends JpaRepository<Product, Long> {

}
