package com.practicaIBM.Proiect_practicaIBM.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name="tb_garage")
public class Garage {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="address")
    private String address;


    @Size(min = 3, max = 10)
    @Column(name="phone")
    private String phone;

    @Column(name="nr_cars")
    private int nr_cars;


    public Garage(String address, String phone, int nr_cars) {
        this.address = address;
        this.phone = phone;
        this.nr_cars = nr_cars;
    }

    public Garage() {
    }
}
