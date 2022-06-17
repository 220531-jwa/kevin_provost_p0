package dev.provost.controllers;

import java.util.List;

import dev.provost.models.Client;
import dev.provost.services.ClientService;
import io.javalin.http.Context;

public class ClientController {
	
	private static ClientService cs = new ClientService();
//	private static ClientService cs;
//	
//	public ClientController(ClientService cs) {
//		this.cs = cs;
//	}

	public static void getAllClients(Context ctx) {
		ctx.status(200);
		List<Client> clients = cs.getAllClients();
		ctx.json(clients);
	}
	
	public static void createNewClient(Context ctx) {
		ctx.status(201);
		Client clientFromRequestBody = ctx.bodyAsClass(Client.class);
		Client c = cs.createClient(clientFromRequestBody); // unmarshalling
		ctx.json(c);
	}
	
	public static void getClientById(Context ctx) {
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		Client c = null;
		try {
			c = cs.getClientById(clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (c != null) {
		ctx.status(200);
		ctx.json(c);
		} else {
			ctx.status(404);
		}
	}
	
	public static void deleteClient(Context ctx) {
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		
		try {
			cs.deleteClient(clientId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void updateClient(Context ctx) {
		int clientId = Integer.parseInt(ctx.pathParam("id"));	
		Client cChanged = ctx.bodyAsClass(Client.class); //unmarshalling
		try {
			cs.updateClient(cChanged, clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	public static void updatePassword(Context ctx) {
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		Client c = ctx.bodyAsClass(Client.class); // {"password": "newPassword"}
//		System.out.println(c.getPassword());
		ctx.status(200);
		cs.updatePassword(clientId, c.getPassword());
	}
}
