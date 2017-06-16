package io.kartsuri89.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.kartsuri89.Application;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
//@ComponentScan(basePackageClasses=Application.class)
public class SwaggerConfig {
	
	private static final String SWAGGER_VERSION = "1.0";
	private static final String LICENCE_TEXT = "Licence";
	private static final String title = "Cars API";
	private static final String description = "RESTful API for Cars";
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICENCE_TEXT)
				.version(SWAGGER_VERSION)
				.build();
	}
	
	@Bean
	public Docket carsApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				.paths(PathSelectors.any())
				.build();
	}

}
