package com.Shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class ShopNowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopNowApplication.class, args);
	}

//	@Bean
//	SellerService getService() {
//		return new SellerServicesImpl();
//	}
}
