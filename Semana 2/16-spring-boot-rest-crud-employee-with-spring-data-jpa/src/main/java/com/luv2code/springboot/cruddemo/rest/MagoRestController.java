package com.luv2code.springboot.cruddemo.rest;

import tools.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.cruddemo.entity.Mago;
import com.luv2code.springboot.cruddemo.service.MagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MagoRestController {

    private MagoService magoService;

    private JsonMapper jsonMapper;

    @Autowired
    public MagoRestController(MagoService theMagoService, JsonMapper theJsonMapper) {
        magoService = theMagoService;
        jsonMapper = theJsonMapper;
    }

    // expose "/magos" and return a list of magos
    @GetMapping("/magos")
    public List<Mago> findAll() {
        return magoService.findAll();
    }

    // add mapping for GET /magos/{employeeId}

    @GetMapping("/magos/{magoId}")
    public Mago getMago(@PathVariable int magoId) {

        Mago theMago = magoService.findById(magoId);

        if (theMago == null) {
            throw new RuntimeException("Mago no ha sido encontrado - " + magoId);
        }

        return theMago;
    }

    // add mapping for POST /magos - add new mago

    @PostMapping("/magos")
    public Mago addMago(@RequestBody Mago theMago) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theMago.setId(0);

        Mago dbMago = magoService.save(theMago);

        return dbMago;
    }

    // add mapping for PUT /magos - update existing magos

    @PutMapping("/magos")
    public Mago updateMago(@RequestBody Mago theMago) {

        Mago dbMago = magoService.save(theMago);

        return dbMago;
    }

    // add mapping for PATCH /magos/{magoId} - patch mago ... partial
    // update

    @PatchMapping("/magos/{magoId}")
    public Mago patchMago(@PathVariable int magoId,
                              @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing employee from database
        Mago tempMago = magoService.findById(magoId);

        if (tempMago == null) {
            throw new RuntimeException("Id de mago no encontrada - " + magoId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "La id del mago no puede ser modificada. Remueve id del request body.");
        }

        // Step 3: Apply the partial update
        // This creates a NEW employee object with the updates applied
        Mago patchedMago = jsonMapper.updateValue(tempMago, patchPayload);

        // Step 4: Save the updated employee to database and return it
        Mago dbMago = magoService.save(patchedMago);

        return dbMago;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/magos/{magoId}")
    public String deleteMago(@PathVariable int magoId) {

        Mago tempMago = magoService.findById(magoId);

        // throw exception if null

        if (tempMago == null) {
            throw new RuntimeException("Id de mago no encontrada - " + magoId);
        }

        magoService.deleteById(magoId);

        return "Se borró la Id del mago - " + magoId;
    }

}
