package com.projects.dependency_injection;

import com.projects.dependency_injection.entities.Order;
import com.projects.dependency_injection.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.print("Código do produto: ");
		Integer code = scanner.nextInt();

		System.out.print("Preço: ");
		Double basic = scanner.nextDouble();

		Order order = new Order(code, basic, 20.00);
		Double total = orderService.total(order);
		System.out.printf("\nPedido código %d", order.getCode());
		System.out.printf("\nValor total: %.2f", total);

		scanner.close();
	}

	public static void main(String[] args) {

		SpringApplication.run(DependencyInjectionApplication.class, args);
	}


}
