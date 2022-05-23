package be.pxl.superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
@ServletComponentScan
public class SuperheroBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroBackendApplication.class, args);
	}

}
