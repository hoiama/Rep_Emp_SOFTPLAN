package br.com.softplan.sienge.service;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class ServiceCost {

    @Autowired
    StreetEntity streetEntity;

    DecimalFormat formatDouble = new DecimalFormat(".##");


    public double getStreetCostWithKilometer(List<StreetEntity> streets){
        return Double.valueOf(formatDouble.format(
                streets
                .stream()
                .mapToDouble(StreetEntity::getCostAll)
                .sum()
        ));
    }

    public double getStreetCostWithKilometerPavimentada(int kilometer){
        return Double.valueOf(formatDouble.format(streetEntity.getCostPavimentada(kilometer)));
    }

    public double getStreetCostWithKilometerNaoPavimentada(int kilometer){
        return Double.valueOf(formatDouble.format(streetEntity.getCostNaoPavimentada(kilometer)));
    }

    public double getKilometerCostWithVehicle(VehicleEntity vehicle, double costWithKilometer){
        return Double.valueOf(formatDouble.format(vehicle.getCostByVehicle(costWithKilometer)));
    }

    public double getCostKilometerWithWeight(ChargeEntity chargeEntity, double kilometer){
        return Double.valueOf(formatDouble.format(chargeEntity.getCostKilometerWithWeight(kilometer)));
    }

}
