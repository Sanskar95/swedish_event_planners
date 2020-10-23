package com.kth.sep;

import com.kth.sep.entity.User;
import com.kth.sep.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SepApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			List<User> users = new ArrayList<>();
			User user= new User();
			user.setPassword("admin");
			user.setUsername("admin");
			user.setRole("ADMIN");

			User user1= new User();
			user1.setPassword("hr");
			user1.setUsername("hr");
			user1.setRole("HR");

			User user2= new User();
			user2.setPassword("cso");
			user2.setUsername("cso");
			user2.setRole("CUSTOMER_SERVICE_OFFICER");

			User user3= new User();
			user3.setPassword("scso");
			user3.setUsername("scso");
			user3.setRole("SENIOR_CUSTOMER_SERVICE_OFFICER");

			User user4= new User();
			user4.setPassword("financialManager");
			user4.setUsername("financialManager");
			user4.setRole("FINANCIAL_MANAGER");

			User user5= new User();
			user5.setPassword("productionManager");
			user5.setUsername("productionManager");
			user5.setRole("PRODUCTION_MANAGER");

			User user6= new User();
			user6.setPassword("subteam");
			user6.setUsername("subteam");
			user6.setRole("SUBTEAM");

			User user7= new User();
			user6.setPassword("serviceManager");
			user6.setUsername("serviceManager");
			user6.setRole("SERVICE_MANAGER");
			

			users.add(user);
			users.add(user1);
			users.add(user2);
			users.add(user3);
			users.add(user4);
			users.add(user5);
			users.add(user6);
			users.add(user7);

			userRepository.saveAll(users);
		};
	}

}
