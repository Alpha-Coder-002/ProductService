package com.project.ProductService;



import com.project.ProductService.inheritancerelations.singletable.*;

import com.project.ProductService.models.Category;
import com.project.ProductService.models.Order;
import com.project.ProductService.models.Price;
import com.project.ProductService.models.Product;
import com.project.ProductService.repositories.CategoryRepository;
import com.project.ProductService.repositories.OrderRepository;
import com.project.ProductService.repositories.PriceRepository;
import com.project.ProductService.repositories.ProductRepository;
import com.project.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;
	private final OrderRepository orderRepository;

	public ProductServiceApplication(CategoryRepository categoryRepository,
									 ProductRepository productRepository,
									 PriceRepository priceRepository,
									 OrderRepository orderRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
		this.orderRepository = orderRepository;
	}

//	private UserRepository userRepository;
//	private StudentRepository studentRepository;
//	private MentorRepository mentorRepository;

//	ProductServiceApplication(@Qualifier("st_userRepository") UserRepository userRepository,@Qualifier("st_studentRepository") StudentRepository studentRepository,@Qualifier("st_mentorRepository") MentorRepository mentorRepository) {
//		this.userRepository = userRepository;
//		this.studentRepository = studentRepository;
//		this.mentorRepository = mentorRepository;
//	}
//	private MentorRepository mentorRepository;
//	private UserRepository userRepository;
//	private StudentRepository studentRepository;
//	private TaRepository taRepository;

//	ProductServiceApplication(@Qualifier("tpc_mentorRepository") MentorRepository mentorRepository,@Qualifier("tpc_userRepository") UserRepository userRepository, @Qualifier("tpc_studentRepository") StudentRepository studentRepository, @Qualifier("tpc_taRepository") TaRepository taRepository) {
//		this.mentorRepository = mentorRepository;
//		this.userRepository = userRepository;
//		this.studentRepository = studentRepository;
//		this.taRepository = taRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Alok");
//		mentor.setEmail("aloksinha02@gmail.com");
//		mentor.setAvgRating(4.5);
//		mentorRepository.save(mentor);

//		Student student = new Student();
//		student.setName("Alok");
//		student.setEmail("aloksinha02@gmail.com");
//		studentRepository.save(student);
//
//		Ta ta = new Ta();
//		ta.setName("Alok");
//		ta.setEmail("aloksinha02@gmail.com");
//		taRepository.save(ta);
//
//		User user = new User();
//		user.setName("Alok");
//		user.setEmail("aloksinha02@gmail.com");
//		userRepository.save(user);
//
//		userRepository.findAll().forEach(System.out::println);

//		Mentor mentor = new Mentor();
//		mentor.setName("Prasad");
//		mentor.setEmail("venkatPrasad02@gmail.com");
//		mentor.setAvgRating(4.5);
//		mentorRepository.save(mentor);

//		Student student = new Student();
//		student.setName("Rohan");
//		student.setEmail("rohansingh002@gmail.com");
//		student.setPsp(56.0);
//		studentRepository.save(student);

//		User user = new User();
//		user.setEmail("rakeshsingh78@gmail.com");
//		user.setName("Rakesh");
//		userRepository.save(user);
//		Category category = new Category();
//		category.setName("Iphone Devices");
//		Category savedCategory=categoryRepository.save(category);

//		Category category = categoryRepository.findById(UUID.fromString("7cf463b6-90c2-4f0d-a656-3827987a0fd6")).get();
//    List<Product> products=category.getProducts();
//    products.forEach(r -> System.out.println(r.getTitle()));

		Price price = new Price();
		price.setCurrency("INR");
		price.setValue(100000.0);

//		Price savedPrice=priceRepository.save(price);


		Order order = new Order();
		orderRepository.save(order);

		Category category = new Category();
		category.setName("Iphone_Devices");
		Category savedCategory=categoryRepository.save(category);


		Product product = new Product();
		product.setTitle("Iphone 15 pro");
		product.setDescription("The latest iPhone 15 pro");
		product.setPrice(price);
		product.setCategory(savedCategory);
		Product savedProduct=productRepository.save(product);

//		productRepository.deleteById(UUID.fromString("3870eb62-e163-4f95-86e9-a517c0dbcbae"));

	}
}
