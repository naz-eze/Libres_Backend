package app.libres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibresApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibresApplication.class, args);
	}

}
