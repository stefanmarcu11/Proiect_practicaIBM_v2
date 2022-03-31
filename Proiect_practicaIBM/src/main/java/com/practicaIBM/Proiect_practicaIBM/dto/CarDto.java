package com.practicaIBM.Proiect_practicaIBM.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarDto {

    private int id;
    private String regnumber;
    private String carbrand;
    private String model;
    private int power;
    private String type;
    private int year;
    private double consumption;
    private GarageDto garage;
}
