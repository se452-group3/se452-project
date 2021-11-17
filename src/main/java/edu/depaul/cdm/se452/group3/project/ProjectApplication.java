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

			repository.save(dogSitTesting);

			DogSitting dogSitTesting2 = new DogSitting();
			dogSitTesting.setId(repository.findAll().size() + 1);
			dogSitTesting.setJobDescption("Sitting for my two pitbulls");
			dogSitTesting.setServiceLevel(5);
			dogSitTesting.setJobLocation("Lincoln Park");

			repository.save(dogSitTesting2);


			DogSitting dogSitTesting3 = new DogSitting();
			dogSitTesting.setId(repository.findAll().size() + 1);
			dogSitTesting.setJobDescption("Dog-sit my Rhodesian Ridgeback named Jack");
			dogSitTesting.setServiceLevel(5);
			dogSitTesting.setJobLocation("Lakeview");

			repository.save(dogSitTesting3);


			DogSitting dogSitTesting4 = new DogSitting();
			dogSitTesting.setId(repository.findAll().size() + 1);
			dogSitTesting.setJobDescption("Keep my poodle name Apollo company");
			dogSitTesting.setServiceLevel(3);
			dogSitTesting.setJobLocation("Lakeview East");

			repository.save(dogSitTesting4);

			DogSitting dogSitTesting5 = new DogSitting();
			dogSitTesting.setId(repository.findAll().size() + 1);
			dogSitTesting.setJobDescption("Sit for my Irish Wolfhound named Duke.");
			dogSitTesting.setServiceLevel(1);
			dogSitTesting.setJobLocation("Oak Park");

			repository.save(dogSitTesting5);

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


			repository.save(dogWalking);



			DogWalking dogWalking2 = new DogWalking();
			dogWalking.setId(2);
			dogWalking.setJobLocation("Chicago, IL");
			dogWalking.setJobDescption("Walking my 6 month golden retriever Julie");
			dogWalking.setTotalDistance(4);

			repository.save(dogWalking2);


			DogWalking dogWalking3 = new DogWalking();
			dogWalking.setId(3);
			dogWalking.setJobLocation("Aurora, IL");
			dogWalking.setJobDescption("Walking my pitbull Fido");
			dogWalking.setTotalDistance(4);

			repository.save(dogWalking3);


			DogWalking dogWalking4 = new DogWalking();
			dogWalking.setId(4);
			dogWalking.setJobLocation("Wheaton, IL");
			dogWalking.setJobDescption("Walking my Great Dane marbles");
			dogWalking.setTotalDistance(5);

			repository.save(dogWalking4);


			DogWalking dogWalking5 = new DogWalking();
			dogWalking.setId(5);
			dogWalking.setJobLocation("Rosemont, IL");
			dogWalking.setJobDescption("Walking my 2 year old Chihuahua Pepe");

			repository.save(dogWalking5);




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


			AcceptedJobs acceptedjobs2 = new AcceptedJobs();
			acceptedjobs.setJoblocal(true);
			acceptedjobs.setOwnerID(2);
			acceptedjobs.setWalkerID(2);

			repository.save(acceptedjobs2);



			AcceptedJobs acceptedjobs3 = new AcceptedJobs();
			acceptedjobs.setJoblocal(true);
			acceptedjobs.setOwnerID(3);
			acceptedjobs.setWalkerID(3);

			repository.save(acceptedjobs3);

			AcceptedJobs acceptedjobs4 = new AcceptedJobs();
			acceptedjobs.setJoblocal(false);
			acceptedjobs.setOwnerID(4);
			acceptedjobs.setWalkerID(4);

			repository.save(acceptedjobs4);

			AcceptedJobs acceptedjobs5 = new AcceptedJobs();
			acceptedjobs.setJoblocal(false);
			acceptedjobs.setOwnerID(5);
			acceptedjobs.setWalkerID(5);

			repository.save(acceptedjobs5);

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


			Reviews review2 = new Reviews();
			review.setPID(2);
			review.setUID(2);
			review.setComment("My dog has so much more exercise now!");
			review.setRating(5);

			repository.save(review2);

			Reviews review3 = new Reviews();
			review.setPID(3);
			review.setUID(3);
			review.setComment("During the pandemic I'm able to social-distance and hang out with dogs because of Dog Party!");
			review.setRating(5);

			repository.save(review3);

			Reviews review4 = new Reviews();
			review.setPID(4);
			review.setUID(4);
			review.setComment("Five stars.");
			review.setRating(5);

			repository.save(review4);

			Reviews review5 = new Reviews();
			review.setPID(5);
			review.setUID(5);
			review.setComment("Trusted company.");
			review.setRating(5);

			repository.save(review5);

			System.out.println(repository.findAll());
		};
	}


}