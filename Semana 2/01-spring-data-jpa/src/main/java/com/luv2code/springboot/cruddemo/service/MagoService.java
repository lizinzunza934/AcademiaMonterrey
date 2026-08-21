package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Mago;

import java.util.List;

public interface MagoService {

    List<Mago> findAll();

    Mago findById(int theId);

    Mago save(Mago theMago);

    void deleteById(int theId);

}
