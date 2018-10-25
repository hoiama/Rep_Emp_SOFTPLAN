package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Service;
import java.util.List;

@RequestMapping("cost")
public class CostController {

    @Autowired
    ServiceCost serviceCost;

    @GetMapping("/main")
    public void getMainCost(
            @RequestParam VehicleEntity vehicle,
            @RequestParam List<StreetEntity> streets,
            @RequestParam ChargeEntity charge) {

        serviceCost.getMainCost(vehicle, streets, charge);
    }
}
