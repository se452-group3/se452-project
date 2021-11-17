package edu.depaul.cdm.se452.group3.project;

import edu.depaul.cdm.se452.group3.project.dao.*;
import edu.depaul.cdm.se452.group3.project.entities.*;
import edu.depaul.cdm.se452.group3.project.services.DogSittingService;
import edu.depaul.cdm.se452.group3.project.services.DogWalkingService;
import edu.depaul.cdm.se452.group3.project.services.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}


	//CRUD test for product object
	@Bean
	public CommandLineRunner saveProduct(ProductRepository repository, ProductService service) {
		return (args) -> {
			repository.deleteAll();

			List<String> categories = new ArrayList<>();
			categories.add("Food");
			categories.add("Toys");
			categories.add("Accessories");
			categories.add("GroomingSupplies");

			for(int i=0; i < 20; i++) {
				Random ran = new Random();
				int x = ran.nextInt(4 - 0);
				System.out.println(x + "LOOOKHERE");
				Product product = new Product();
//				product.setId(repository.findAll().size() + 1);
				product.setPrice(20);
				product.setCategoryId(categories.get(x));
				product.setProductName("Wag Dog food");
				product.setProductDescription("Dog food for dogs");
				product.setImageURL("https://m.media-amazon.com/images/I/71xBPL2vKaL._AC_SL1500_.jpg");
				service.productSave(product);
			}

			List<Product> allProducts = repository.findAll();

			for (Product productItem : allProducts) {
				System.out.println(productItem.getProductName());
			}
		};
	}

	@Bean
	public CommandLineRunner saveDogSitting(DogSittingRepository repository, DogSittingService service){
		return (args) -> {
			repository.deleteAll();


			DogSitting dogSitTesting = new DogSitting();
			dogSitTesting.setId(repository.findAll().size() + 1);
			dogSitTesting.setJobDescption("testtqwqdqwdw");
			dogSitTesting.setServiceLevel(5);
			dogSitTesting.setJobLocation("San Jose");

			//dogSitTesting.setJobDateHolder("2021-12-27T18:30");

			//service.addDogSitting(dogSitTesting);

			repository.save(dogSitTesting);

			System.out.println(repository.findAll());

		};
		}

	@Bean
	public CommandLineRunner saveDogWalking(DogWalkingRepository repository, DogWalkingService service) {
		return (args) -> {
			repository.deleteAll();

			DogWalking dogWalking = new DogWalking();
			dogWalking.setId(1);
			dogWalking.setJobLocation("Chicago, IL");
			dogWalking.setJobDescption("Walking my 4 year old terrier Max.");
			dogWalking.setTotalDistance(2);
			//dogWalking.setJobDateHolder("2021-12-27T18:30");
			//service.addDogWalking(dogWalking);


			repository.save(dogWalking);


			System.out.println(repository.findAll());
		};
	}

	@Bean
	public CommandLineRunner saveAcceptedJobs(AcceptedJobsRepository repository){
		return (args) -> {
			repository.deleteAll();

			AcceptedJobs acceptedjobs = new AcceptedJobs();
			acceptedjobs.setJoblocal(true);
			acceptedjobs.setOwnerID(1);
			acceptedjobs.setWalkerID(1);

			repository.save(acceptedjobs);

			System.out.println(repository.findAll());
		};
	}

	@Bean
	public CommandLineRunner saveReview(ReviewsRepository repository){
		return (args) -> {
			repository.deleteAll();

			Reviews review = new Reviews();
			review.setPID(1);
			review.setUID(1);
			review.setComment("I love this app.");
			review.setRating(5);

			repository.save(review);

			System.out.println(repository.findAll());
		};
	}


}