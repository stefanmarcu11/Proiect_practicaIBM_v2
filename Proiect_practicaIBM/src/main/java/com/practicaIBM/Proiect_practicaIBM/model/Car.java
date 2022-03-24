package com.practicaIBM.Proiect_practicaIBM.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_cars")
public class Car {


    @Id
    @GeneratedValue
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

    public Car(String regnumber, String  carbrand, String model, int power, String type, int year, double consumption) {
        this.regnumber=regnumber;
        this.carbrand = carbrand;
        this.model = model;
        this.power = power;
        this.type = type;
        this.year= year;
        this.consumption = consumption;
    }

    public Car() {
    }
}
