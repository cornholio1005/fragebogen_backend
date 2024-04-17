package com.example.fragebogenbackend;

import com.example.fragebogenbackend.model.Participant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class FragebogenBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FragebogenBackendApplication.class, args);
	}


}
