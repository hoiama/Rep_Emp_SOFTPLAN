package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.List;

@RequestMapping("cost")
@Controller
public class CostController {

    @Autowired
    ServiceCost serviceCost;

    @PostMapping
    public void getMainCost(
            @RequestBody VehicleEntity vehicle,
            @RequestBody List<StreetEntity> streets,
            @RequestBody ChargeEntity charge) {

        //serviceCost.getMainCost(vehicle, streets, charge);
    }

}
