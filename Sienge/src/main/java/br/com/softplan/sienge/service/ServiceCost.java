package br.com.softplan.sienge.service;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceCost {

    @Autowired
    StreetRepository streetRepository;


    public double getMainCost(VehicleEntity vehicle, List<StreetEntity> streets, ChargeEntity charge){

        double streetCostWithKilometer = getStreetCostWithKilometer(streets);
        double vehicleCost = getKilometerCostWithVehicle(vehicle, streetCostWithKilometer);
        double weightCostByKilometer = getCostKilometerWithWeight(charge, streets);
        return streetCostWithKilometer + vehicleCost + weightCostByKilometer;
    }


    public double getStreetCostWithKilometer(List<StreetEntity> streets){
        return streets
                .stream()
                .mapToDouble(StreetEntity::getCost)
                .sum();
    }


    public double getKilometerCostWithVehicle(VehicleEntity vehicle, double costWithKilometer){
        return vehicle.getCostByVehicle(costWithKilometer);
    }


    public double getCostKilometerWithWeight(ChargeEntity chargeEntity, List<StreetEntity> streets){
        double kilometer = streets
                                .stream()
                                .mapToDouble(StreetEntity::getKilometer).sum();

        return chargeEntity.getCostKilometerWithWeight(kilometer);
    }

}
