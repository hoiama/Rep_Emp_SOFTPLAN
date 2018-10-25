package br.com.softplan.sienge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChargeEntity {

    final double WEIGTH = 0.02;
    final int WEIGTH_LIMIT = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idWigth;
    private int weight;
    private double cost;

    public double getCostKilometerWithWeight(double kilometer){
        if (weight > WEIGTH_LIMIT){
            int excess = this.weight - WEIGTH_LIMIT;
            return excess * WEIGTH * kilometer;

        } else{
            return 0;
        }
    }

    public Long getIdWigth() {
        return idWigth;
    }

    public void setIdWigth(Long idWigth) {
        this.idWigth = idWigth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
