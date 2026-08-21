package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MagoRepository;
import com.luv2code.springboot.cruddemo.entity.Mago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagoServiceImpl implements MagoService {

    private MagoRepository magoRepository;

    @Autowired
    public MagoServiceImpl(MagoRepository theMagoRepository) {
        magoRepository = theMagoRepository;
    }

    @Override
    public List<Mago> findAll() {
        return magoRepository.findAll();
    }

    @Override
    public Mago findById(int theId) {
        Optional<Mago> result = magoRepository.findById(theId);

        Mago theMago = null;

        if (result.isPresent()) {
            theMago = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theMago;
    }

    @Override
    public Mago save(Mago theMago) {
        return magoRepository.save(theMago);
    }

    @Override
    public void deleteById(int theId) {
        magoRepository.deleteById(theId);
    }
}






