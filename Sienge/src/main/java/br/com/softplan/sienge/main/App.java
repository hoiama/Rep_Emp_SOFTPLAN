package br.com.softplan.sienge.main;

import br.com.softplan.sienge.controller.CostController;
import br.com.softplan.sienge.entity.ChargeEntity;
import br.com.softplan.sienge.repository.StreetRepository;
import br.com.softplan.sienge.service.ServiceCost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackageClasses = {ChargeEntity.class})
@EnableJpaRepositories(basePackageClasses = StreetRepository.class)
@ComponentScan(basePackageClasses= {CostController.class, ServiceCost.class})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
