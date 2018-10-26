package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("street/")
@Controller
public class StreetController {

    @Autowired
    ServiceCost serviceCost;

    @PostMapping(path = "post", consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getStreetCost(
            @RequestBody List<StreetEntity> streetEntityList){

        double costStreet = serviceCost.getStreetCostWithKilometer(streetEntityList);
        return new ResponseEntity<>(costStreet, HttpStatus.OK);
    }
}
