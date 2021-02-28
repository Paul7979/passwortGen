package at.technikum.passwortGen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PasswortGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswortGenApplication.class, args);
	}

}
