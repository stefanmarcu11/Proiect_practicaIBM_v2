package com.practicaIBM.Proiect_practicaIBM.exception;

import com.practicaIBM.Proiect_practicaIBM.model.Car;
import com.practicaIBM.Proiect_practicaIBM.model.Garage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Requested item not found")
public class NotFoundException extends RuntimeException {

    private String objIdentifier;

    public <T> NotFoundException(Class<T> cls, int id) {
        super(cls.getSimpleName() + " with id: " + id+ " does not exist!");
    }

    public String getObjIdentifier() {

        return objIdentifier;
    }

}
