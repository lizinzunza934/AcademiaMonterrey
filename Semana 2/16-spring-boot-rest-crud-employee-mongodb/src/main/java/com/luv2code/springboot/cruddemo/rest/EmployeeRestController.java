package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Mago;
import tools.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper) {
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Mago> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    //
    // El employeeId ahora es String: un ObjectId de MongoDB, no un entero.

    @GetMapping("/employees/{employeeId}")
    public Mago getEmployee(@PathVariable String employeeId) {

        Mago theMago = employeeService.findById(employeeId);

        if (theMago == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theMago;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Mago addEmployee(@RequestBody Mago theMago) {

        // also just in case they pass an id in JSON ... set id to null
        // this is to force a save of new item ... instead of update
        //
        // En JPA esto era setId(0). En MongoDB el equivalente es null: si el id
        // viene nulo se inserta un documento nuevo, y si viene con valor se
        // REEMPLAZA el documento que ya existía con ese id.

        theMago.setId(null);

        Mago dbMago = employeeService.save(theMago);

        return dbMago;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Mago updateEmployee(@RequestBody Mago theMago) {

        Mago dbMago = employeeService.save(theMago);

        return dbMago;
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial
    // update

    @PatchMapping("/employees/{employeeId}")
    public Mago patchEmployee(@PathVariable String employeeId,
                              @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing employee from database
        Mago tempMago = employeeService.findById(employeeId);

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
        Mago dbMago = employeeService.save(patchedMago);

        return dbMago;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {

        Mago tempMago = employeeService.findById(employeeId);

        // throw exception if null

        if (tempMago == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
