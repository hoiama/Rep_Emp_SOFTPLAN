package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("charge")
@RestController
public class ChargeController {

    @Autowired
    ServiceCost serviceCost;


    /**
     * Get the cost about the charge transported in street
     * @return double value os the cost
     */
    @GetMapping(path = "")
    @ResponseBody
    public ResponseEntity getVehicleCost(
            @RequestParam(value = "weight", required=true) int weight,  ChargeEntity charge,
            @RequestParam(value = "kilometer", required=true) double kilometer){

        double cost = serviceCost.getCostKilometerWithWeight(charge, kilometer);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
}
