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
			dogSitTesting.setJobDateHolder(now.toString());


			service.addDogSitting(dogSitTesting);

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