package pl.pjaroszcompany.myfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.pjaroszcompany.myfood.config.InformationAboutAplication;

@SpringBootApplication
@EnableConfigurationProperties(value = {InformationAboutAplication.class})
@EnableScheduling
public class MyfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfoodApplication.class, args);
    }

}
