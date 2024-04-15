package tn.esprit.rh.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
@RestController
public class AchatApplication {
@GetMapping("")
public String getMessage(){
    return "working...";
}
    public static void main(String[] args) {
        SpringApplication.run(AchatApplication.class, args);
    }

}
