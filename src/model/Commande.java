package model;

import java.util.Date;

public class Commande {
	private int id;
	private String idClient;
	private Date date;
	private double total;

	public Commande() {
	}

	public Commande(int id, String idClient, Date date, double total) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.date = date;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", idClient=" + idClient + ", date=" + date + ", total=" + total + "]";
	}

}
