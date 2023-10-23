package com.bhavit.csvreadwrite;

import com.bhavit.csvreadwrite.util.CsvHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvReadWriteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CsvReadWriteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CsvHandler.csvReadWrite();
	}
}
