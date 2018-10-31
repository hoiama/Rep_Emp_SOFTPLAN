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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class ControllerChargeTest {


    @Autowired
    private MockMvc mvc;

    @Mock
    ChargeController chargeController;


    @Test
    public void contexLoads() throws Exception {
        Assert.assertNotNull(chargeController);
    }


    @Test
    public void sholdGetChargeCost() throws Exception {
        mvc.perform(get("/charge")
                .param("kilometer", "100")
                .param("weight", "100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }
    GsonTester gson
    String json = gson.toJson(stub);
    @Test
    public void sholdGetChargeCost2() throws Exception {
        mvc.perform(post("/charge")
                .content(asJsonString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }


}
