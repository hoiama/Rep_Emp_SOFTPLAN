package br.com.softplan.sienge.service;

import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.entity.StreetEntity;
import br.com.softplan.sienge.entity.VehicleEntity;
import br.com.softplan.sienge.main.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@DataJpaTest
public class ServiceCostTest {

    @Autowired
    private ServiceCost serviceCost;


    private VehicleEntity vehicleEntity;
    private StreetEntity streetEntity;
    private ChargeEntity chargeEntity;
    private List<StreetEntity> streetEntities;
    private double streetCostWithKilometer = 54.00;
    private double delta = 0.01;

    @Before
    public void getVehicle(){
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setTypeVehicle("cacamba");
        this.vehicleEntity = vehicleEntity;
    }


    @Before
    public void getStreetEntity(){
        StreetEntity streetEntity = new StreetEntity();
        streetEntity.setKilometer(100);
        streetEntity.setTypeStreet("Pavimentada");
        this.streetEntity = streetEntity;
    }

    @Before
    public void getListStrets(){
        List<StreetEntity> streetEntities = new ArrayList<>();
        streetEntities.add(streetEntity);
        this.streetEntities = streetEntities;
    }

    @Before
    public void getCharge(){
        ChargeEntity chargeEntity = new ChargeEntity();
        chargeEntity.setWeight(8);
        this.chargeEntity = chargeEntity;
    }

    @Test
    public void shouldAtributesNotNull() {
        assertNotNull(vehicleEntity);
        assertNotNull(streetEntities);
        assertNotNull(streetEntity);
        assertNotNull(chargeEntity);
        assertNotNull(serviceCost);
    }

    @Test
    public void shouldGetStreetCostWithKilometer(){
        double streetCostWithKilometer = serviceCost.getStreetCostWithKilometer(streetEntities);
        assertNotNull(streetCostWithKilometer);
        assertEquals(streetCostWithKilometer, streetCostWithKilometer, delta);

    }

    @Test
    public void shouldGetKilometerCostWithVehicle(){
        double withVehicleCost = serviceCost.getKilometerCostWithVehicle(vehicleEntity, streetCostWithKilometer);
        assertNotNull(withVehicleCost);
        assertEquals(2.7, withVehicleCost, delta);
    }

    @Test
    public void shouldGetCostKilometerWithWeight(){
        double costKilometerWithWeight = serviceCost.getCostKilometerWithWeight(chargeEntity, streetEntity.getKilometer());
        assertNotNull(costKilometerWithWeight);
        assertEquals(6.0, costKilometerWithWeight, delta);
    }
}
