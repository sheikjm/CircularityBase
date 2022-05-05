package com.trustrace.circularity;

import com.trustrace.circularity.entity.User;
import com.trustrace.circularity.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication()
@OpenAPIDefinition(info = @Info(title = "Circularity API", version = "2.0", description = "Api Information"))
public class CircularityApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CircularityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user=new User();
		user.setId(2L);
		user.setRole("Admin");
		user.setUsername("jsheik@gmail.com");
		user.setPassword("123");

		userRepository.save(user);

	}
}
