package br.com.softplan.sienge.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Component
@Entity
public class StreetEntity {

    final String PAVIMENTADA = "Pavimentada";
    final String NAO_PAVIMENTADA = "Não pavimentada";

    final double VALUE_PAVIMENTADA = 0.54;
    final double VALUE_NAO_PAVIMENTADA = 0.62;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idStreet;
    private String typeStreet;
    private double kilometer;


    public Long getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(Long idStreet) {
        this.idStreet = idStreet;
    }

    public String getTypeStreet() {
        return typeStreet;
    }

    public void setTypeStreet(String typeStreet) {
        this.typeStreet = typeStreet;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }


    public double getCostAll(){
        if(this.typeStreet.equalsIgnoreCase(PAVIMENTADA)) {
            return VALUE_PAVIMENTADA * kilometer;

        }else if(this.typeStreet.equalsIgnoreCase(NAO_PAVIMENTADA)){
            return VALUE_NAO_PAVIMENTADA * kilometer;
        }

        return 0;
    }

    public double getCostPavimentada(int kilometer){
        return VALUE_PAVIMENTADA * kilometer;
    }

    public double getCostNaoPavimentada(int kilometer){
        return VALUE_NAO_PAVIMENTADA * kilometer;
    }

}
