package io.kartsuri89;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kartsuri89.model.Car;
import io.kartsuri89.repo.CarMongoRepository;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application {
	
	@Autowired
    private CarMongoRepository carRepository;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/")
	public String demo(){
		return "Suriya - Here Docker comes with simple demo";
	}
	
	@GetMapping("/save")
    public String home() {
		Car car = new Car("Benz");
		carRepository.save(car);
        return "Data posted..!!";
    }

}
