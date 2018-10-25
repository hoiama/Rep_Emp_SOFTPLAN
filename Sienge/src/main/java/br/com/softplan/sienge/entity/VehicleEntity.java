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

    private String typeVehicle;


    public double getCostByVehicle(double costByVehicle){
        if(this.typeVehicle == BAU ){
            return costByVehicle * VALUE_BAU;

        } else if(this.typeVehicle == CACAMBA){
            return costByVehicle * VALUE_CACAMBA;

        } else if(this.typeVehicle == CARRETA){
            return costByVehicle * VALUE_CARRETA;
        }

        return 0;
    }

    public String getBAU() {
        return BAU;
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
