package br.com.softplan.sienge.main;

import br.com.softplan.sienge.entity.EstimateEntity;
import br.com.softplan.sienge.repository.EstimateRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackageClasses = {EstimateEntity.class})
@EnableJpaRepositories(basePackageClasses = EstimateRepository.class)
@ComponentScan(basePackages= {"br.com.softplan.sienge"})
@SpringBootApplication
public class App {
    public String getGreeting() {

        return "Hello world.";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println(new App().getGreeting());
    }
}
