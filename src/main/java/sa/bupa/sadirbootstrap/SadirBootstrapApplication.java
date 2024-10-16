package sa.bupa.sadirbootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SadirBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SadirBootstrapApplication.class, args);
    }

}
