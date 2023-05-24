package cgd.rampupcgd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RampUpCgdApplication {

  public static void main(String[] args) {
    SpringApplication.run(RampUpCgdApplication.class, args);
  }

}
