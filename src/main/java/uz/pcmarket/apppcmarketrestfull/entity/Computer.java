package uz.pcmarket.apppcmarketrestfull.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpu;

    @Column(nullable = false)
    private Integer gpu;

    @Column(nullable = false)
    private Integer hdd;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer ssd;

    private Integer price;

    private Double diagonal;

    private Double powerUnit;

    private String motherBoard;

    @ManyToOne(optional = false)
    private Product model;
}
