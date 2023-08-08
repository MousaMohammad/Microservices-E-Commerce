package com.mousatech.inventoryservice;

import com.mousatech.inventoryservice.model.Inventory;
import com.mousatech.inventoryservice.repository.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadDate(InventoryRepo inventoryRepo){
		return args -> {
			inventoryRepo.save(Inventory.builder().sku("kd").quantity(10).build());
			inventoryRepo.save(Inventory.builder().sku("sd").quantity(20).build());
			inventoryRepo.save(Inventory.builder().sku("mk").quantity(30).build());
		};
	}
}
