package br.com.softplan.sienge.service;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class ServiceCost {

    @Autowired
    StreetRepository streetRepository;

    public double getMainCost(VehicleEntity vehicle, List<StreetEntity> streets, ChargeEntity charge){
        return streets
                .stream()
                .mapToDouble(StreetEntity::getCost)
                .sum();

    }











}
