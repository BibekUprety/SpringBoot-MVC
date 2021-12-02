package com.bibek.firebase;

import com.bibek.firebase.fileStorage.FileStorageService;
import com.bibek.firebase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FirebaseApplication implements CommandLineRunner {

	private final ProductService productService;


	public static void main(String[] args) {
		SpringApplication.run(FirebaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		fileStorageService.loadAsResource();
		System.out.println(productService);
		System.out.println(productService.getImageByte(8));
	}
}
