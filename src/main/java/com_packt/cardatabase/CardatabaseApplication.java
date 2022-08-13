package com_packt.cardatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com_packt.cardatabase.domain.Car;
import com_packt.cardatabase.domain.CarRepository;
import com_packt.cardatabase.domain.Owner;
import com_packt.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication {
	//Inject repositories
	@Autowired 
    private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	public static void main(String[] args) {
		// After adding this comment the application is restarted
		
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	
	@Bean
    CommandLineRunner runner(){
      return args -> {
    	//Add owner objects and save these to database
    	  Owner owner1 = new Owner("John", "Johnson");
    	  Owner owner2 = new Owner("Mary", "Robinson");
    	  orepository.save(owner1);
    	  orepository.save(owner2);
    	  
    	// Save demo data to database
    	//Add car object with link to owners and save these to database.
          Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
          repository.save(car);
          car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
          repository.save(car);
          car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
          repository.save(car);
      };
    } 
}
