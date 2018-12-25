package br.com.softplan.sienge.controller;

import br.com.softplan.sienge.main.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class ControllerVehicleTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    VehicleController vehicleController;

    @Test
    public void contexLoads() throws Exception {
        Assert.assertNotNull(vehicleController);
    }

    @Test
    public void sholdGetVehicleCost() throws Exception {
        mvc.perform(get("/vehicle")
                .param("typeVehicle", "cacamba")
                .param("costWithKilometer", "100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

}
