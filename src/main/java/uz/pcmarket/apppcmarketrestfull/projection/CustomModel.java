package uz.pcmarket.apppcmarketrestfull.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pcmarket.apppcmarketrestfull.entity.Product;

@Projection(types = Product.class)
public interface CustomModel {

    Long getId();

    String getName();

}
