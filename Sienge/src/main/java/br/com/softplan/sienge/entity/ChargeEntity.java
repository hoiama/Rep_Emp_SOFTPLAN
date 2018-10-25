package br.com.softplan.sienge.entity;

public class ChargeEntity {

    final double WEIGTH = 0.02;
    final double WEIGTH_LIMIT = 5;

    private int weight;
    private double cost;

    public double getCostByWeight(double weight){
        if (weight > WEIGTH_LIMIT){
            return weight * WEIGTH;
        } else{
            return 0;
        }
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
