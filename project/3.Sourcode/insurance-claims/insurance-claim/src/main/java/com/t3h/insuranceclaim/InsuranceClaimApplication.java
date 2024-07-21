package com.t3h.insuranceclaim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.t3h.insuranceclaim")
public class InsuranceClaimApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceClaimApplication.class, args);
	}

}
