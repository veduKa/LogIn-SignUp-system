package SYSTEM;

import DAO.UserDAOImplemetation;

public class Validation {

	
	
	
	public static boolean usernameValdation(String username)
	{
		UserDAOImplemetation user = new UserDAOImplemetation();
		
		try
		{
			for (int i = 0; i < user.getUsers().size(); i++)
			{
				if (username.equals(user.getUsers().get(i).getUsername()))
				{
					return true;
				}
			}
		}
		
		catch (Exception e)
		{
			System.out.println("Dogodila se greška, vraæamo vas na poèetni meni");
			Main.menuInterface();
		}
		return false;
	}
	
	
	public static boolean passwordValidation(String username, String password)
	{
		UserDAOImplemetation user = new UserDAOImplemetation();
		
		try
		{
			for (int i = 0; i < user.getUsers().size(); i++)
			{
				if (username.equals(user.getUsers().get(i).getUsername()))
				{
					if (password.equals(user.getUsers().get(i).getPassword()))
					{
						return true;
					}
				}
			}
		}
		
		catch (Exception e)
		{
			System.out.println("Dogodila se greška, vraæamo vas na poèetni meni");
			Main.menuInterface();
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
