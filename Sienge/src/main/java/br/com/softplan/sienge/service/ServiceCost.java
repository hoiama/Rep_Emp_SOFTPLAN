package br.com.softplan.sienge.service;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceCost {

    @Autowired
    private StreetEntity streetEntity;


    public double MainCostDistance(VehicleEntity vehicle, List<StreetEntity> streets, ChargeEntity charge){
        return streetEntity.getCost(streets);

    }











}
