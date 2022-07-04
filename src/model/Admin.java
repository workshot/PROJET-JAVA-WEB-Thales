package model;

public class Admin {

    private String login;
	private String password;
	private Boolean actif;

	public Admin() {
	}

	public Admin(String login, String password, Boolean actif) {
		this.login = login;
		this.password = password;
		this.actif = actif;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Admin [login=" + login + ", password=" + password + ", actif=" + actif + "]";
	}
	
}
