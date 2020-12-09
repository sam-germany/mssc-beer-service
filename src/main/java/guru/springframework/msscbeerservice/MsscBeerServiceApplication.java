package guru.springframework.msscbeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication(exclude = ArtemisAutoConfiguration.class)
public class MsscBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscBeerServiceApplication.class, args);
    }

}
/*
(exclude = ArtemisAutoConfiguration.class)
if we get a JMSSecurityException then if we put this it will not come.

 */
