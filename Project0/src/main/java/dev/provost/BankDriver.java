package dev.provost;
import dev.provost.controllers.AccountController;
import dev.provost.controllers.ClientController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class BankDriver {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
		
		app.start(8081);
		
		// Javalin provides us with a Context Class (ctx) that represents information 
		// about BOTH the Http Request AND Http Response Objects
		// we'll be using methods from the context class to handle our incoming http requests
		// and to send our http responses
		
		// lambdas - introduced functional programming to Java
		// (parameter) -> {// implementation}
		
		app.routes(() -> {
			path("/clients", () -> {
				get(ClientController::getAllClients);
				post(ClientController::createNewClient);
				path("/{id}", () -> {
					get(ClientController::getClientById);
					delete(ClientController::deleteClient);
					put(ClientController::updateClient); 
					patch(ClientController::updatePassword);
						path("/accounts", () -> {
							get(AccountController::getAccountsByUserId);
 							post(AccountController::createAccount);
 							path("/{accountId}", () -> {
 								get(AccountController::getAccountbyAccountId);
								delete(AccountController::deleteAccount);
// 								put(AccountController::updateBalance);
 							});
						});
 
					});
				});
		});
		

		
		app.get("/", ctx -> {
			ctx.status(200);
			ctx.result("Hello! Welcome to the landing page");
		});
		
	}
	

}
