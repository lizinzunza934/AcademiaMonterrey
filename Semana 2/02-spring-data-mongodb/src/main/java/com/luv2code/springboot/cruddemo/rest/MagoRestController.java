package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Mago;
import tools.jackson.databind.json.JsonMapper;
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

    // expose "/employees" and return a list of employees
    @GetMapping("/magos")
    public List<Mago> findAll() {
        return magoService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    //
    // El employeeId ahora es String: un ObjectId de MongoDB, no un entero.

    @GetMapping("/magos/{magoId}")
    public Mago getMago(@PathVariable String magoId) {

        Mago theMago = magoService.findById(magoId);

        if (theMago == null) {
            throw new RuntimeException("Id de mago no encontrada - " + magoId);
        }

        return theMago;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/magos")
    public Mago addMago(@RequestBody Mago theMago) {

        // also just in case they pass an id in JSON ... set id to null
        // this is to force a save of new item ... instead of update
        //
        // En JPA esto era setId(0). En MongoDB el equivalente es null: si el id
        // viene nulo se inserta un documento nuevo, y si viene con valor se
        // REEMPLAZA el documento que ya existía con ese id.

        theMago.setId(null);

        Mago dbMago = magoService.save(theMago);

        return dbMago;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/magos")
    public Mago updateMago(@RequestBody Mago theMago) {

        Mago dbMago = magoService.save(theMago);

        return dbMago;
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial
    // update

    @PatchMapping("/magos/{magoId}")
    public Mago patchMago(@PathVariable String magoId,
                              @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing employee from database
        Mago tempMago = magoService.findById(magoId);

        if (tempMago == null) {
            throw new RuntimeException("Id del mago no ha sido encontrada - " + magoId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "La id del mago no puede ser modificada. Remueve Id del request body.");
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
    public String deleteMago(@PathVariable String magoId) {

        Mago tempMago = magoService.findById(magoId);

        // throw exception if null

        if (tempMago == null) {
            throw new RuntimeException("Id del mago no encontrada - " + magoId);
        }

        magoService.deleteById(magoId);

        return "Id de mago borrada - " + magoId;
    }

}
