package com.practicaIBM.Proiect_practicaIBM.dto;

public class GarageDto {

    private int id;
    private String address;
    private String phone;
    private int nr_cars;

    public GarageDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNr_cars() {
        return nr_cars;
    }

    public void setNr_cars(int nr_cars) {
        this.nr_cars = nr_cars;
    }
}
