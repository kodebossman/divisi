package za.co.za.nharire.divisi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DivisiApplication {

	public static void main(String[] args) {

		SpringApplication.run(DivisiApplication.class, args);
		log.info("DIVISI FARMERS APPLICATION STARTED SUCCESSFULLY!!!!");

	}

}
