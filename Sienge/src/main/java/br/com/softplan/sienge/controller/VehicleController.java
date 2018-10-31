package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.softplan.sienge.service.ServiceCost;


@RequestMapping("vehicle")
@RestController
public class VehicleController {

    @Autowired
    ServiceCost serviceCost;


    /**
     * Get the cost about the vehicle used to transported the charge
     * @return double value os the cost
     */
    @GetMapping(path = "")
    public ResponseEntity getVehicleCost(
            @RequestParam(value="typeVehicle", required=true) String typeVehicle, VehicleEntity vehicle,
            @RequestParam double costWithKilometer){

        double cost = serviceCost.getKilometerCostWithVehicle(vehicle, costWithKilometer);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
}
