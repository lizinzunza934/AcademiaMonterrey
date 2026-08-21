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

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Mago> findAll() {
        return magoService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Mago getEmployee(@PathVariable int employeeId) {

        Mago theMago = magoService.findById(employeeId);

        if (theMago == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theMago;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Mago addEmployee(@RequestBody Mago theMago) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theMago.setId(0);

        Mago dbMago = magoService.save(theMago);

        return dbMago;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Mago updateEmployee(@RequestBody Mago theMago) {

        Mago dbMago = magoService.save(theMago);

        return dbMago;
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial
    // update

    @PatchMapping("/employees/{employeeId}")
    public Mago patchEmployee(@PathVariable int employeeId,
                              @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing employee from database
        Mago tempMago = magoService.findById(employeeId);

        if (tempMago == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "Employee id cannot be modified. Remove 'id' from request body.");
        }

        // Step 3: Apply the partial update
        // This creates a NEW employee object with the updates applied
        Mago patchedMago = jsonMapper.updateValue(tempMago, patchPayload);

        // Step 4: Save the updated employee to database and return it
        Mago dbMago = magoService.save(patchedMago);

        return dbMago;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Mago tempMago = magoService.findById(employeeId);

        // throw exception if null

        if (tempMago == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        magoService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
