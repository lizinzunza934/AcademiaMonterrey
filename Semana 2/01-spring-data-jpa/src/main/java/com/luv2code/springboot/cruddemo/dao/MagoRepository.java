package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Mago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagoRepository extends JpaRepository<Mago, Integer> {

    // that's it ... no need to write any code LOL!

}
