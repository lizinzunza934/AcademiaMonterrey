package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Mago;

import java.util.List;

public interface EmployeeService {

    List<Mago> findAll();

    Mago findById(String theId);

    Mago save(Mago theMago);

    void deleteById(String theId);

}
