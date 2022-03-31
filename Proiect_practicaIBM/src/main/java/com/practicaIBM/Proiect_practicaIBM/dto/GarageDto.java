package com.practicaIBM.Proiect_practicaIBM.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GarageDto {

    private int id;
    private String address;
    private String phone;
    private int nr_cars;
}
