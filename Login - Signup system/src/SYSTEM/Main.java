package SYSTEM;

import java.util.Scanner;

import DAO.UserDAOImplemetation;
import DTO.User;


public class Main {
	static Scanner input = new Scanner (System.in);
	static String loggedNow;

	public static void main(String[] args) {
	menuInterface();
	}
	
	public static void menuInterface() {
		System.out.println("--------------------DOBRODOŠLI--------------------");
		System.out.println("\nOdaberite jednu od sljedeæih opcija?\n");
		System.out.println("1. Login ");
		System.out.println("2. Register\n");
		System.out.print("Vaš izbor je: ");
		menu();
	}
	
	
	public static void menu() {
		
		int izbor = input.nextInt();
		
		switch (izbor) {
		case 1: {
			login();
			break;
		}
		case 2: {
			register();
			break;
		}
		default:
			invalidInputMessage();
			break;
		}
	}
	
	
	public static void login() {
		
		System.out.println("Unesite username: ");
		String username = input.next();
		
		System.out.println("Unesite password: ");
		String password = input.next();
		User user = new User(username, password);
		
		if (user.isLoginSuccessful() == true)
		{
			loggedInInterface();
			loggedNow = username;
		}
		
		else
		{
			System.out.println("Dogodila se pogreška, vraæamo vas na poèetni meni.");
			menuInterface();
		}
	};
	
	public static void register() {
		
		System.out.println("Odabrali ste opciju registrovanja. Unesite vaš username: ");
		String username = input.next();
		
		System.out.println("Unesite ime: ");
		String name = input.next();
		
		System.out.println("Unesite prezime: ");
		String surname = input.next();
		
		System.out.println("Unesite password: ");
		String password = input.next();
		
		User user = new User(username, name, surname, password);
		
		try
		{
			UserDAOImplemetation addData = new UserDAOImplemetation();
			addData.addUser(username, name, surname, password);
			System.out.println("Uspješno ste se registrovali! Vraæamo vas na poèetni meni.");
			menuInterface();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Dogodila se pogreška, vraæamo vas na poèetni meni.");
			menuInterface();
		}
	};
	
	
	public static void invalidInputMessage() {
		
		System.out.println("Odaberite neku od vazecih opcija.");
		menu();
	};
	
	
	public static void loggedInInterface() {
		System.out.println("-------------------- Uspješno ste se ulogovali --------------------");
		System.out.println("\nOdaberite jednu od sljedeæih opcija?");
		System.out.println("1. Promijenite username");
		System.out.println("2. Promijenite ime");
		System.out.println("3. Promijenite prezime");
		System.out.println("4. Promijenite šifru");
		System.out.print("Vaš izbor je: ");
		loggedInMenu();
	}
	
	public static void loggedInMenu() {
		
		int izbor2 = input.nextInt();
		
		switch (izbor2) {
		case 1: {
			changeUsername();
			break;
		}
		case 2: {
			changeName();
			break;
		}
		case 3: {
			changeSurname();
			break;
		}
		case 4: {
			changePassword();
			break;
		}
		default:
			invalidInputMessage();
			break;
		}
	}
	
	
	public static void changeUsername() {
		
		System.out.println("Unesite novi username: ");
		String newUsername = input.next();
		
		try
		{
			UserDAOImplemetation user = new UserDAOImplemetation();
			user.changeSurname(newUsername, loggedNow);
			loggedInInterface();
			loggedNow = newUsername;
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			invalidInputMessage();
			loggedInInterface();
		}
	}
	
	
	public static void changeName() {
		
		System.out.println("Unesite novo ime: ");
		String ime = input.next();
		
		try
		{
			UserDAOImplemetation user = new UserDAOImplemetation();
			user.changeName(ime, loggedNow);
			loggedInInterface();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			invalidInputMessage();
			loggedInInterface();
		}
	}
	
	
	public static void changeSurname() {
		
		System.out.println("Unesite novo prezime: ");
		String prezime = input.next();
		
		try
		{
			UserDAOImplemetation user = new UserDAOImplemetation();
			user.changeSurname(prezime, loggedNow);
			loggedInInterface();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			invalidInputMessage();
			loggedInInterface();
		}
	}
	

	public static void changePassword() {
		
		System.out.println("Unesite novu sifru: ");
		String sifra = input.next();
		
		try
		{
			UserDAOImplemetation user = new UserDAOImplemetation();
			user.changeSurname(sifra, loggedNow);
			loggedInInterface();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			invalidInputMessage();
			loggedInInterface();
		}
	}

}




