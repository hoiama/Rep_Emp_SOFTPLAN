package br.com.softplan.sienge.service;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;

import java.util.List;

public class serviceCost {

    private StreetEntity streetEntity;


    public double MainCostDistance(VehicleEntity vehicle, List<StreetEntity> streets, ChargeEntity charge){
        return streetEntity.getCost(streets);

    }











}
