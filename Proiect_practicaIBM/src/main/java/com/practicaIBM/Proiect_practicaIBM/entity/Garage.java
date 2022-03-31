package com.practicaIBM.Proiect_practicaIBM.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tb_garage")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="address")
    private String address;


    @Size(min = 3, max = 10)
    @Column(name="phone")
    private String phone;

    @Column(name="nr_cars")
    private int nr_cars;

    @OneToMany(mappedBy = "garage", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Car> carList;
}
