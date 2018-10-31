package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("street")
@RestController
public class StreetController {

    @Autowired
    ServiceCost serviceCost;


    /**
     * Get the street cost by the paved street and not paved street
     * @param streetEntityList List of json steets in the request
     * @return double value os the cost
     */
    @PostMapping(path = "")
    public ResponseEntity getStreetCost(
            @RequestBody List<StreetEntity> streetEntityList){

        double costStreet = serviceCost.getStreetCostWithKilometer(streetEntityList);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }


    /**
     * Get the street cost by the paved street
     * @return double value os the cost
     */
    @GetMapping(path = "/pavimentada")
    public ResponseEntity getStreetPavimentadaCost(
            @RequestParam int kilometer){

        double costStreet = serviceCost.getStreetCostWithKilometerPavimentada(kilometer);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }


    /**
     * Get the street cost by the paved not street
     * @return double value os the cost
     */
    @GetMapping(path = "/nao-pavimentada")
    public ResponseEntity getStreetPavimentadaCostNaoPavimentada(
            @RequestParam int kilometer){

        double costStreet = serviceCost.getStreetCostWithKilometerNaoPavimentada(kilometer);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }
}
