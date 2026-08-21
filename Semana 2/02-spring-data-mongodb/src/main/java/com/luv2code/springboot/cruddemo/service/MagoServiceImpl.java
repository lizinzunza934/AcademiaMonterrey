package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Mago;
import com.luv2code.springboot.cruddemo.repository.MagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagoServiceImpl implements MagoService {

    // Antes se inyectaba EmployeeDAO. Ahora es el repositorio de Spring Data,
    // que no tiene implementación escrita a mano.
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
    public Mago findById(String theId) {

        // findById() devuelve Optional<Employee>. Lo convertimos a null para
        // conservar el mismo contrato que tenía la versión con JPA: el
        // controlador sigue comprobando "if (tempEmployee == null)".
        return magoRepository.findById(theId).orElse(null);
    }

    // Ojo: aquí ya no hay @Transactional.
    //
    // MongoDB en modo standalone (un contenedor suelto, sin replica set) no
    // soporta transacciones multi-documento. Y no hacen falta: cada operación
    // toca un solo documento, y MongoDB garantiza atomicidad por documento.
    @Override
    public Mago save(Mago theMago) {
        return magoRepository.save(theMago);
    }

    @Override
    public void deleteById(String theId) {
        magoRepository.deleteById(theId);
    }
}
