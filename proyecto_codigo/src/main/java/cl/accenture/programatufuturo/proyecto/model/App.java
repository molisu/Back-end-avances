package cl.accenture.programatufuturo.proyecto.model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"cl.accenture.programatufuturo.proyecto"})
@EnableSwagger2
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }

}
