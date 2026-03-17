package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.engineeringdigest.journalApp.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testFindByUserName() {
		assertNotNull(userRepository.findByUserName("pratham"));
	}
}
