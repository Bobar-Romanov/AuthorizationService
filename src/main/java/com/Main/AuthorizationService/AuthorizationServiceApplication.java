package com.Main.AuthorizationService;

import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AuthorizationServiceApplication {




	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
		log.info("_________Application starts____________");
	}

}
