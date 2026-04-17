package dev.danvega;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.service.UserService;	
import dev.danvega.controller.UserController;
import dev.danvega.domain.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Json2dbApplication {

	@SuppressWarnings("unused")
	private final UserService userService;
    @SuppressWarnings("unused")
	private final UserController userController;

    Json2dbApplication(UserController userController, UserService userService) {
        this.userController = userController;
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(Json2dbApplication.class, args);
	}

	@SuppressWarnings("null")
	@Bean
	CommandLineRunner runner(UserService userService){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			//TypeReference<List<User>>  typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream, new TypeReference<List<User>>(){});
				userService.save((User) users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
	    };
	}
}
