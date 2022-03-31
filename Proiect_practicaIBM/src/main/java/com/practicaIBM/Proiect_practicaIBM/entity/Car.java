package com.practicaIBM.Proiect_practicaIBM.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_cars")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="regnumber")
    private String regnumber;

    @Column(name="marca")
    private String carbrand;

    @Column(name="model")
    private String model;

    @Column(name="power")
    private int power;

    @Column(name= "type")
    private String type;

    @Column(name= "an")
    private int year;

    @Column(name="consum")
    private double consumption;

    @ManyToOne
    @JoinColumn(name="id_garage")
    private Garage garage;
}
