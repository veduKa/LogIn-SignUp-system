package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.User;

public class UserDAOImplemetation {
	
	Connection connection = ConnectionManager.getInstance().getConnection();
	
	public ArrayList<User> getUsers() throws SQLException {

		 ArrayList<User> users = new ArrayList<User>();
		String query = "SELECT * FROM users";
		ResultSet rs = null;

		try (
				Statement statement = connection.createStatement();) {

			rs = statement.executeQuery(query);

			while (rs.next()) {
				users.add(new User( rs.getString("Username"), rs.getString("Name"),
						rs.getString("Surname"), rs.getString("Password")));
			
			}

		}

		return users;
	}
	
	public void addUser(String username, String name, String surname, String password) throws SQLException {

		String query = "INSERT INTO userlist(Username, Name, Surname, Password) VALUES (?, ?, ?, ?)";
		
		try (
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, username);
			statement.setString(2, name);
			statement.setString(3, surname);
			statement.setString(4, password);

			statement.executeUpdate();
			System.out.println("Izvršeno.");
		}
	}
	
	
	public void changeUsername(String newUsername, String username) throws SQLException
	{
		String query = "UPDATE userlist SET username = ? WHERE username = '" + username + "'";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.setString(1, newUsername);

			statement.executeUpdate();

			System.out.println("Sifra je promijenjena.");
		}
	}
	
	
	public void changeName(String name, String username) throws SQLException
	{
		String query = "UPDATE userlist SET name = ? WHERE username = '" + username + "'";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.setString(1, name);

			statement.executeUpdate();

			System.out.println("Ime je promijenjeno.");
		}
	}
	
	public void changeSurname(String surname, String username) throws SQLException
	{
		String query = "UPDATE userlist SET surname = ? WHERE username = '" + username + "'";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.setString(1, surname);

			statement.executeUpdate();

			System.out.println("Prezime je promijenjeno.");
		}
	}
	
	public void changePassword(String password, String username) throws SQLException
	{
		String query = "UPDATE userlist SET password = ? WHERE username = '" + username + "'";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.setString(1, password);

			statement.executeUpdate();

			System.out.println("Sifra je promijenjena.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
