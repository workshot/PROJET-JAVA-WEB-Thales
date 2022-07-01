package model;

public class Client {

    private String id;
	private String nom;
	private String prenom;
	private String password;
	private String adresse;
	private String email;
	private String tel;
	private String livraison;

	public Client() {
	}

	public Client(String id, String nom, String prenom, String password, String adresse, String email, String tel,
			String livraison) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.livraison = livraison;
	}


	public Client(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLivraison() {
		return livraison;
	}

	public void setLivraison(String livraison) {
		this.livraison = livraison;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", adresse="
				+ adresse + ", email=" + email + ", tel=" + tel + ", livraison=" + livraison + "]";
	}
	

	
}
