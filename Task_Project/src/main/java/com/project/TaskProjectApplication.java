package com.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskProjectApplication.class, args);
		

	
		
		
		System.out.println("Starting project");
	}
	//modal mapper method 
	@Bean
	public  ModelMapper modelmapper()
{
	return new ModelMapper();
}

}
