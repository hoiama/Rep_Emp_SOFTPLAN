package br.com.softplan.sienge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VehicleEntity {

    final String BAU = "bau";
    final String CACAMBA = "cacamba";
    final String CARRETA = "carreta";

    final double VALUE_BAU = 1.00;
    final double VALUE_CACAMBA = 1.05;
    final double VALUE_CARRETA = 1.12;


    private Long idVehicle;
    private String typeVehicle;


    public double getCostByVehicle(double costByVehicle){
        if(this.typeVehicle.equalsIgnoreCase(BAU)){
            return (costByVehicle * VALUE_BAU) - costByVehicle;

        } else if(this.typeVehicle.equalsIgnoreCase(CACAMBA)){
            return (costByVehicle * VALUE_CACAMBA) - costByVehicle;

        } else if(this.typeVehicle.equalsIgnoreCase(CARRETA)){
            return (costByVehicle * VALUE_CARRETA) - costByVehicle;
        }

        return 0.0;
    }


    public Long getIdVehicle() {
        return idVehicle;
    }


    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }


    public String getTypeVehicle() {
        return typeVehicle;
    }


    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }
}
