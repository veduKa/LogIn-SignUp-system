package DTO;

public class User {
	
		private String username;
		private String name;
		private String surname;
		private String password;
		private boolean loginSuccessful;

		public User(String username, String name, String surname, String password) {
			super();
			this.username = username;
			this.name = name;
			this.surname = surname;
			this.password = password;
		}
		
		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
			setLoginSuccessful(true);
		}
		
		
		
		
		
		
		
		public String getName() {
			return name;
		}

		public String getUsername() {
			return username;
		}

		public String getSurname() {
			return surname;
		}

		public String getPassword() {
			return password;
		}
		
		public boolean isLoginSuccessful() {
			return loginSuccessful;
		}

		public void setLoginSuccessful(boolean loginSuccessful) {
			this.loginSuccessful = loginSuccessful;
		}
		
	}

