package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.softplan.sienge.service.ServiceCost;


@RequestMapping("vehicle")
@RestController
public class VehicleController {

    @Autowired
    ServiceCost serviceCost;

    @PostMapping(path = "", consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getVehicleCost(
            @RequestBody VehicleEntity vehicle){
        System.out.println(vehicle.getTypeVehicle());
        double cost = serviceCost.getKilometerCostWithVehicle(vehicle, 54.00);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
}
