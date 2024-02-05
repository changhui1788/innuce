package com.mc.innuce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mc.innuce.domain.news.selenium.service.CrawlingNewsService;

@EnableScheduling
@SpringBootApplication
public class InnuceApplication implements CommandLineRunner {
	@Autowired
	CrawlingNewsService cns;
	
	public static void main(String[] args) {

		SpringApplication.run(InnuceApplication.class, args);
		
		
	}

	// test code
	@Override
	public void run(String... args) throws Exception {
		cns.crawllingCategoryNews();
	}
	
}