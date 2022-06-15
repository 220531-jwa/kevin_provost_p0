package dev.provost.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.provost.models.Client;
import dev.provost.utils.ConnectionUtil;

public class ClientDAO {
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	public Client createClient(Client c) {
		
		String sql = "insert into users values (default, ?, ?, ?, ?) returning *";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Client(
						rs.getInt("clientid"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass")
						);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Client> getAllClients() {
		// create an empty array list that will hold all the Clients returned from the database
		List<Client> clients = new ArrayList<>();
		
		// this is the sql statement that we'll be executing
		String sql = "select * from users";
		
		// try with resources - this will auto close any resources we need without a finally block
		try (Connection conn = cu.getConnection()) {
			// prepare our statement using the connection object
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// execute our statement and store the result set in a reference variable
			ResultSet rs = ps.executeQuery();
			
			// iterate over the result set, to get the values stored in each column and creating a Java Object with them
			while(rs.next()) {
				// use the getXXX() methods to retrieve the values stored in each column of this row of the result set
				int clientId = rs.getInt("clientid");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				
				Client c = new Client(clientId, firstName, lastName, username, password);
				
				clients.add(c);
			}
			return clients;
			
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return null;
	}
	
	public Client getClientById(int clientId) {
		
		String sql = "select * from users where clientid = ?"; // this question mark symbolizes and IN parameter for our statement
		
		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, clientId); // here we are setting the the "?" in our sql string to be the int clientId that's passed in to this method as an argument
		
			ResultSet rs = ps.executeQuery();
			
			// if the result set has a row/record
			if (rs.next()) {
				return new Client(
						rs.getInt("clientId"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; // Optional Class -> can help avoid NullPointer Exceptions (if any one is curious)
	}
	
	public Client getClientByUsername(String username) {
		
		return null;
	}
	
	public void updateClient(Client cChanged, int clientId) {
		
		String sql = "update users set first_name = ?, last_name = ?, username = ?, pass = ? where clientid = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cChanged.getFirstName());
			ps.setString(2, cChanged.getLastName());
			ps.setString(3, cChanged.getUsername());
			ps.setString(4, cChanged.getPassword());
			ps.setInt(5, clientId);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteClient(int clientId) {
		String sql = "delete from users where clientid = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, clientId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Client updateClientPassword(int clientId, String password) {
		
		String sql = "update users set pass = ? where clientid = ? returning *";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, clientId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Client(
						rs.getInt("clientId"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
