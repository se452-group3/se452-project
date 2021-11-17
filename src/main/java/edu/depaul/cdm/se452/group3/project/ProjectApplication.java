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

import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

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

			HashMap<String, String> description = new HashMap<>();
			HashMap<String, String> url = new HashMap<>();
			HashMap<String, Double> price = new HashMap<>();
			HashMap<String, String> title = new HashMap<>();

			description.put("Food", "In Wag Dry Dog Food Turkey & Lentil Recipe, real poultry comes first because that's what dogs need to thrive.");

			description.put("Toys", "Slide puzzle game is a fun way to engage your dog's mind and activate their problem solving-skills.");

			description.put("Accessories", "closed cell Neoprene rubber material that retains less stink than traditional collars");

			description.put("GroomingSupplies", "The kit includes 1 × 6.5-inch thinning shear, 1 × 6.5-inch curved scissor, " +
					"1 × 6.5-inch straight scissor, 1 × pet comb, 1 × cleaning cloth, 1 × black leather case");

			url.put("Food", "https://m.media-amazon.com/images/I/71xBPL2vKaL._AC_SL1500_.jpg");
			url.put("Toys", "https://m.media-amazon.com/images/I/81f0nZ921HL._AC_SL1500_.jpg");
			url.put("Accessories", "https://m.media-amazon.com/images/I/41cfkteyRQL._AC_SX466_.jpg");
			url.put("GroomingSupplies","https://m.media-amazon.com/images/I/71Wx98ZSrxS._AC_SL1500_.jpg");

			price.put("Food", 24.99);
			price.put("Toys", 19.99);
			price.put("Accessories", 25.00);
			price.put("GroomingSupplies", 17.99);

			title.put("Food", "Wag Dog food");
			title.put("Toys", "Nina Ottosson by Outward Hound");
			title.put("Accessories", "EzyDog Neo Collar");
			title.put("GroomingSupplies", "GLADOG Professional Grooming Scissors");

			for(int i=0; i < 20; i++) {
				Random ran = new Random();
				int x = ran.nextInt(4 - 0);
				String type = categories.get(x);

				Product product = new Product();
				product.setPrice(price.get(type));
				product.setCategoryId(type);
				product.setProductName(title.get(type));
				product.setProductDescription(description.get(type));
				product.setImageURL(url.get(type));
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

			LocalDateTime now = LocalDateTime.now();

			DogSitting dogSitTesting = new DogSitting();
			dogSitTesting.setJobDescption("testtqwqdqwdw");
			dogSitTesting.setServiceLevel(5);
			dogSitTesting.setJobLocation("San Jose");
			dogSitTesting.setJobDateHolder("2021-12-27T1:30");

			service.addDogSitting(dogSitTesting);

			DogSitting dogSitTesting2 = new DogSitting();
			dogSitTesting2.setJobDescption("Sitting for my two pitbulls");
			dogSitTesting2.setServiceLevel(5);
			dogSitTesting2.setJobLocation("Lincoln Park");
			dogSitTesting2.setJobDateHolder("2021-11-25T1:45");

			service.addDogSitting(dogSitTesting2);


			DogSitting dogSitTesting3 = new DogSitting();
			dogSitTesting3.setJobDescption("Dog-sit my Rhodesian Ridgeback named Jack");
			dogSitTesting3.setServiceLevel(5);
			dogSitTesting3.setJobLocation("Lakeview");
			dogSitTesting3.setJobDateHolder("2021-11-19T2:45");

			service.addDogSitting(dogSitTesting3);


			DogSitting dogSitTesting4 = new DogSitting();
			dogSitTesting4.setJobDescption("Keep my poodle name Apollo company");
			dogSitTesting4.setServiceLevel(3);
			dogSitTesting4.setJobLocation("Lakeview East");
			dogSitTesting4.setJobDateHolder("2021-11-30T4:30");

			service.addDogSitting(dogSitTesting4);

			DogSitting dogSitTesting5 = new DogSitting();
			dogSitTesting5.setJobDescption("Sit for my Irish Wolfhound named Duke.");
			dogSitTesting5.setServiceLevel(1);
			dogSitTesting5.setJobLocation("Oak Park");
			dogSitTesting5.setJobDateHolder("2021-11-29T1:45");

			service.addDogSitting(dogSitTesting5);


		};
	}

	@Bean
	public CommandLineRunner saveDogWalking(DogWalkingRepository repository, DogWalkingService service) {
		return (args) -> {
			repository.deleteAll();

			DogWalking dogWalking = new DogWalking();
			dogWalking.setJobLocation("Chicago, IL");
			dogWalking.setJobDescption("Walking my 4 year old terrier Max.");
			dogWalking.setTotalDistance(2);
			dogWalking.setJobDateHolder("2021-11-29T1:45");

			service.addWalking(dogWalking);



			DogWalking dogWalking2 = new DogWalking();
			dogWalking2.setJobLocation("Chicago, IL");
			dogWalking2.setJobDescption("Walking my 6 month golden retriever Julie");
			dogWalking2.setTotalDistance(4);
			dogWalking2.setJobDateHolder("2021-11-19T6:45");

			service.addWalking(dogWalking2);


			DogWalking dogWalking3 = new DogWalking();
			dogWalking3.setJobLocation("Aurora, IL");
			dogWalking3.setJobDescption("Walking my pitbull Fido");
			dogWalking3.setTotalDistance(4);
			dogWalking3.setJobDateHolder("2021-12-14T9:45");

			service.addWalking(dogWalking3);


			DogWalking dogWalking4 = new DogWalking();
			dogWalking4.setJobLocation("Wheaton, IL");
			dogWalking4.setJobDescption("Walking my Great Dane marbles");
			dogWalking4.setTotalDistance(5);
			dogWalking4.setJobDateHolder("2021-12-23T2:45");

			service.addWalking(dogWalking4);


			DogWalking dogWalking5 = new DogWalking();
			dogWalking5.setJobLocation("Rosemont, IL");
			dogWalking5.setJobDescption("Walking my 2 year old Chihuahua Pepe");
			dogWalking5.setTotalDistance(2);
			dogWalking5.setJobDateHolder("2021-12-26T12:45");

			service.addWalking(dogWalking5);
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
			acceptedjobs2.setJoblocal(true);
			acceptedjobs2.setOwnerID(2);
			acceptedjobs2.setWalkerID(2);

			repository.save(acceptedjobs2);



			AcceptedJobs acceptedjobs3 = new AcceptedJobs();
			acceptedjobs3.setJoblocal(true);
			acceptedjobs3.setOwnerID(3);
			acceptedjobs3.setWalkerID(3);

			repository.save(acceptedjobs3);

			AcceptedJobs acceptedjobs4 = new AcceptedJobs();
			acceptedjobs4.setJoblocal(false);
			acceptedjobs4.setOwnerID(4);
			acceptedjobs4.setWalkerID(4);

			repository.save(acceptedjobs4);

			AcceptedJobs acceptedjobs5 = new AcceptedJobs();
			acceptedjobs5.setJoblocal(false);
			acceptedjobs5.setOwnerID(5);
			acceptedjobs5.setWalkerID(5);

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
			review2.setPID(2);
			review2.setUID(2);
			review2.setComment("My dog has so much more exercise now!");
			review2.setRating(5);

			repository.save(review2);

			Reviews review3 = new Reviews();
			review3.setPID(3);
			review3.setUID(3);
			review3.setComment("During the pandemic I'm able to social-distance and hang out with dogs because of Dog Party!");
			review3.setRating(5);

			repository.save(review3);

			Reviews review4 = new Reviews();
			review4.setPID(4);
			review4.setUID(4);
			review4.setComment("Five stars.");
			review4.setRating(5);

			repository.save(review4);

			Reviews review5 = new Reviews();
			review5.setPID(5);
			review5.setUID(5);
			review5.setComment("Trusted company.");
			review5.setRating(5);

			repository.save(review5);

			System.out.println(repository.findAll());
		};
	}


}