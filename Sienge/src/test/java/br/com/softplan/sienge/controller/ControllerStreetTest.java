package br.com.softplan.sienge.controller;


import br.com.softplan.sienge.main.App;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class ControllerPagesTest {


    @Autowired
    private MockMvc mvc;

    @Mock
    VehicleController vehicleController;


    @Test
    public void contexLoads() throws Exception {
        Assert.assertNotNull(vehicleController);
    }


    @Test
    public void sholdGetVechicleCost() throws Exception {
        mvc.perform(get("/street/pavimentada")
                .param("kilometer", "100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
