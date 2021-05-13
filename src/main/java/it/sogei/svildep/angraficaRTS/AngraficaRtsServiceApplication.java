package it.sogei.svildep.angraficaRTS;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("it.sogei.svildep.common")
@ComponentScan("it.sogei.svildep")
@RequiredArgsConstructor
@SpringBootApplication
public class AngraficaRtsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngraficaRtsServiceApplication.class, args);
	}

}
