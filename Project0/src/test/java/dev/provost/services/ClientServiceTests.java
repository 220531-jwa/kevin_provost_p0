package dev.provost.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.provost.models.Client;
import dev.provost.repositories.ClientDAO;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {
	
	@InjectMocks
	private static ClientService clientService;
	
	@Mock
	private static ClientDAO mockClientDao;

//	@Test
//	void testLogin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdatePassword() {
//		fail("Not yet implemented");
//	}

	@Test
	void testCreateClient() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllClients() {
		List<Client> clientsMock = new ArrayList<>();
		clientsMock.add(new Client(1, "Fake", "Person", "username", "password"));
		clientsMock.add(new Client(2, "Manny", "Mock", "user", "pass"));
		clientsMock.add(new Client(3, "Debbie", "Mock", "user", "pass"));
		clientsMock.add(new Client(4, "Gigi", "Mock", "user", "pass"));
		
		when(mockClientDao.getAllClients()).thenReturn(clientsMock);
		
		assertEquals(clientsMock, clientService.getAllClients());
	}

	@Test
	void testGetClientById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateClient() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteClient() {
		fail("Not yet implemented");
	}

}
