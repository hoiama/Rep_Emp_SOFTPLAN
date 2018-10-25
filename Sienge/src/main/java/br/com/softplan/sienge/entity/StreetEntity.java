package br.com.softplan.sienge.entity;

import java.util.List;

public class StreetEntity {

    final String PAVIMENTADA = "Pavimentada";
    final String NAO_PAVIMENTADA = "Não pavimentada";

    final double VALUE_PAVIMENTADA = 0.54;
    final double VALUE_NAO_PAVIMENTADA = 0.62;

    private String TypeStreet;
    private double kilometer;

    public String getTypeStreet() {
        return TypeStreet;
    }

    public void setTypeStreet(String typeStreet) {
        TypeStreet = typeStreet;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public double getCost(List<StreetEntity> strets){

        for (StreetEntity street : strets) {

            String streetType = street.getTypeStreet();
            double kilometer = street.getKilometer();

            if(streetType == PAVIMENTADA) {
                return VALUE_PAVIMENTADA * kilometer;

            }else if(streetType == NAO_PAVIMENTADA){
                return VALUE_NAO_PAVIMENTADA * kilometer;
            }
        }
        return 0;
    }

}
