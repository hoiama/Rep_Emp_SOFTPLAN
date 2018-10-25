package br.com.softplan.sienge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Costs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdCosts;
    private double streetCostWithKilometer;
    private double vehicleCost;
    private double weightCostByKilometer;

    public double getStreetCostWithKilometer() {
        return streetCostWithKilometer;
    }

    public void setStreetCostWithKilometer(double streetCostWithKilometer) {
        this.streetCostWithKilometer = streetCostWithKilometer;
    }

    public double getVehicleCost() {
        return vehicleCost;
    }

    public void setVehicleCost(double vehicleCost) {
        this.vehicleCost = vehicleCost;
    }

    public double getWeightCostByKilometer() {
        return weightCostByKilometer;
    }

    public void setWeightCostByKilometer(double weightCostByKilometer) {
        this.weightCostByKilometer = weightCostByKilometer;
    }
}
