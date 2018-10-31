package br.com.softplan.sienge.controller;


import br.com.softplan.sienge.main.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class ControllerStreetTest {


    @Autowired
    private MockMvc mvc;

    @Mock
    VehicleController vehicleController;


    @Test
    public void contexLoads() throws Exception {
        Assert.assertNotNull(vehicleController);
    }


    @Test
    public void sholdGetStreetPavimentadaCost() throws Exception {
        mvc.perform(get("/street/pavimentada")
                .param("kilometer", "100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

    @Test
    public void sholdGetStreeNoPavimentadatCost() throws Exception {
        mvc.perform(get("/street/nao-pavimentada")
                .param("kilometer", "100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }
}
