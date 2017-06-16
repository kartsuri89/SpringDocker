package io.kartsuri89;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.kartsuri89.model.Car;
import io.kartsuri89.repo.CarMongoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SpringBootApplication
@RestController(value="/carService")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Api(value="CarControllerAPI",produces=MediaType.APPLICATION_JSON_VALUE)
public class Application {
	
	@Autowired
    private CarMongoRepository carRepository;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/")
	@ApiOperation("Get simple api test link")
	public String demo(){
		return "Suriya - Here Docker comes with simple demo";
	}
	
	@GetMapping("/test/{name}")
	@ApiOperation("Get simple api test link with param")
	public String demo(@PathVariable("name") String name){
		return "Hello "+name+ " !!!";
	}
	
	@GetMapping("/save")
    public String home() {
		Car car = new Car("Benz");
		carRepository.save(car);
        return "Data posted..!!";
    }

}
