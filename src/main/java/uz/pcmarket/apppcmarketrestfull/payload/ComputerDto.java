package uz.pcmarket.apppcmarketrestfull.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDto {

    private String name;
    private String cpu;
    private Integer gpu;
    private Integer hdd;
    private Integer ram;
    private Integer ssd;
    private Integer price;
    private Double diagonal;
    private Double powerUnit;
    private String motherBoard;
    private Long modelId;

}
