package pl.pjaroszcompany.myfood.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "info")
public class InformationAboutAplication {

    private String name;

    @Getter
    @Setter
    static class Information {
        private String info;
    }

}
