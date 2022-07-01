package model;

public class ItemCommande {
	private int idCommande;
	private int idArticle;
	private int quantite;
	private double prixUnitaire;

	public ItemCommande() {
	}

	public ItemCommande(int idCommande, int idArticle, int quantite, double prixUnitaire) {
		this.idCommande = idCommande;
		this.idArticle = idArticle;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	@Override
	public String toString() {
		return "ItemCommande [idCommande=" + idCommande + ", idArticle=" + idArticle + ", quantite=" + quantite
				+ ", prixUnitaire=" + prixUnitaire + "]";
	}

}
