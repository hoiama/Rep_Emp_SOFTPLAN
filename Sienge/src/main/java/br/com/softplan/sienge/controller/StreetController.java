package br.com.softplan.sienge.controller;

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

@RequestMapping("street")
@RestController
public class StreetController {

    @Autowired
    ServiceCost serviceCost;

    @PostMapping(path = "")
    public ResponseEntity getStreetCost(
            @RequestBody List<StreetEntity> streetEntityList){

        double costStreet = serviceCost.getStreetCostWithKilometer(streetEntityList);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }


    @GetMapping(path = "/pavimentada")
    public ResponseEntity getStreetPavimentadaCost(
            @RequestParam int kilometer){

        double costStreet = serviceCost.getStreetCostWithKilometerPavimentada(kilometer);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }


    @GetMapping(path = "/nao-pavimentada")
    public ResponseEntity getStreetPavimentadaCostNaoPavimentada(
            @RequestParam int kilometer){

        double costStreet = serviceCost.getStreetCostWithKilometerNaoPavimentada(kilometer);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }
}
