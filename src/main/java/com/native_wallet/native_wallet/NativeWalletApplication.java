package com.native_wallet.native_wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NativeWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativeWalletApplication.class, args);
	}

}
