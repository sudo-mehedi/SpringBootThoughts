package com.winrysoft.thought;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThoughtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThoughtApplication.class, args);
	}

	// @Autowired
	// ThoughtRepository thoughtRepository;

	// @Bean
	// public CommandLineRunner commandLineRunner() {
	// Thought thought = new Thought();
	// thought.setContent("Hello world!");
	// thought.setIsPublic(true);
	// thought.setCreatedAt(java.time.LocalDateTime.now());
	// return args -> {
	// thoughtRepository.save(thought);
	// };
	// }

}
