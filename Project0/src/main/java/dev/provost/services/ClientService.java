package dev.provost.services;

import java.util.List;

import dev.provost.models.Client;
import dev.provost.repositories.ClientDAO;

public class ClientService {
	
	private static ClientDAO clientDao = new ClientDAO();
	
	
	//login
	public Client login(String username, String password) {
		
		Client c = clientDao.getClientByUsername(username);
		
		if (c.getPassword().equals(password)) {
			return c;
		}
		return null;
	}
	
	public Client updatePassword(int clientId, String password) {
		// check if that client exists
		return clientDao.updateClientPassword(clientId, password);
	}
	
	// register / create client
	public Client createClient(Client c) {
		Client createdClient = clientDao.createClient(c);
		return createdClient;
	}

	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	public Client getClientById(int clientId) throws Exception {
		// this is where you could put some business logic 
		// for example checking if the Client returned by clientDao.getClientById(clientId) is null 
		Client c = clientDao.getClientById(clientId);
		
		if (c == null) {
			throw new Exception("Client not found");
		}
		
		return c;
	}

	public void deleteClient(int clientId) {
		clientDao.deleteClient(clientId);
	}
	
	public void updateClient(Client cChanged, int clientId) {
		clientDao.updateClient(cChanged, clientId);
	}


	

}
