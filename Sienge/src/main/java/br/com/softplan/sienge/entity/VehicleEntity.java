package br.com.softplan.sienge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleEntity {

    final String BAU = "Caminhão baú";
    final String CACAMBA = "Caminhão caçamba";
    final String CARRETA = "Carreta";

    final double VALUE_BAU = 1.00;
    final double VALUE_CACAMBA = 1.05;
    final double VALUE_CARRETA = 1.12;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVehicle;
    private String type;
    private double cost;


    public double getCostByVehicle(VehicleEntity vehicle){
        if(vehicle.getType() == BAU ){
            return cost * VALUE_BAU;

        } else if(vehicle.getType() == CACAMBA){
            return cost * VALUE_CACAMBA;

        } else if(vehicle.getType() == CARRETA){
            return cost * VALUE_CARRETA;
        }

        return 0;
    }

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
