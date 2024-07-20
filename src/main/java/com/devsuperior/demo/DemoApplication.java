package com.devsuperior.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//passwordEnconder.encode() gera um hash
		System.out.println("ENCODE = " + passwordEncoder.encode("123456"));

		//Vai comparar a senha com o hash gerado
		boolean result = passwordEncoder.matches("123456","$2a$10$OaiNS4hiofrVZ/TifNar5OXbb/UbeEjvWhSH4aBnS7M5jRH20uYWq");

		System.out.println("RESULTADO = " + result);
	}
}
