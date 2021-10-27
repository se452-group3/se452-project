package edu.depaul.cdm.se452.group3.project;

import edu.depaul.cdm.se452.group3.project.dao.AcceptedJobsRepository;
import edu.depaul.cdm.se452.group3.project.dao.DogSittingRepository;
import edu.depaul.cdm.se452.group3.project.dao.ProductRepository;
import edu.depaul.cdm.se452.group3.project.entities.AcceptedJobs;
import edu.depaul.cdm.se452.group3.project.entities.DogSitting;
import edu.depaul.cdm.se452.group3.project.entities.Product;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}


	//CRUD test for product object
	@Bean
	public CommandLineRunner saveCourseReview(ProductRepository repository) {
		return (args) -> {

			for(int i=0; i < 5; i++) {
				Product product = new Product();
				product.setId(repository.findAll().size() + 1);
				product.setPrice(20);
				product.setCategoryId(String.format("Food %s",i ));
				product.setProductName(String.format("test %s", i));
				product.setProductDescription(String.format("test %s", i));
				product.setProductName(String.format("Test Food%s", i));
				product.setImageURL("www.google.com");
				repository.save(product);
				System.out.println(product);
			}

			List<Product> allProducts = repository.findAll();

			for (Product productItem : allProducts) {
				System.out.println(productItem.getProductName());
			}
			repository.deleteAll();

		};
	}

	@Bean
	public CommandLineRunner saveDogSitting(DogSittingRepository repository){
		return (args) -> {
			DogSitting dogSitTesting = new DogSitting();
			dogSitTesting.setId(repository.findAll().size() + 1);
			dogSitTesting.setJobDescption("testtqwqdqwdw");
			dogSitTesting.setServiceLevel(5);
			dogSitTesting.setJobLocation("San Jose");

			repository.save(dogSitTesting);
			System.out.println(repository.findAll());

		};
		}

	@Bean
	public CommandLineRunner saveAcceptedJobs(AcceptedJobsRepository repository){
		return (args) -> {
			AcceptedJobs acceptedjobs = new AcceptedJobs();
			acceptedjobs.setJoblocal(true);
			acceptedjobs.setOwnerID(1);
			acceptedjobs.setWalkerID(1);

			repository.save(acceptedjobs);

			System.out.println(repository.findAll());
		};
	}
	}