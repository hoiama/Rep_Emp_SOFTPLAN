package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("charge")
@RestController
public class ChargeController {

    @Autowired
    ServiceCost serviceCost;

    @GetMapping(path = "")
    @ResponseBody
    public ResponseEntity getVehicleCost(
            @RequestParam(value = "weight", required=true) int weight,  ChargeEntity charge,
            @RequestParam(value = "kilometer", required=true) double kilometer){

        double cost = serviceCost.getCostKilometerWithWeight(charge, kilometer);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
}
