package dev.provost;
import dev.provost.controllers.AccountController;
import dev.provost.controllers.ClientController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class BankDriver {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
		
		app.start(8080);
		
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
							get(AccountController::getAccountsByClientId);
 							post(AccountController::createAccount);
 							path("/{accountId}", () -> {
 								get(AccountController::getAccountbyAccountId);
								delete(AccountController::deleteAccount);
								put(AccountController::updateAccount);
// 								patch(AccountController::changeBalance);
 							});
						});
 
					});
				});
		});
		
		app.error(404, ctx -> {
			ctx.result("Not Found");
		});
		
		app.get("/", ctx -> {
			ctx.status(200);
			ctx.result("Hello! Welcome to the landing page");
		});
		
	}
	

}
