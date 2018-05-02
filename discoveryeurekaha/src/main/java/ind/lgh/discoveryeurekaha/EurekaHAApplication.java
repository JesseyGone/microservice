package ind.lgh.discoveryeurekaha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lgh
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaHAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHAApplication.class, args);
    }
}
