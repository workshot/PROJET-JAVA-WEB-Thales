package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Panier {
	private Map<Article, Integer> items; // Article : quantite

	public Panier() {
		this.items = new HashMap<>();
	}

	public void addItem(Article article, int quantite) {
		if (items.containsKey(article)) {
			quantite += items.get(article);
		}
		items.put(article, quantite);
	}

	public Map<Article, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Article, Integer> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Panier [items=" + items + "]";
	}

	public double getTotal() {
		double total = 0;
		for(Entry<Article, Integer> entry : items.entrySet()) {
			total += entry .getKey().getPrix() * entry .getValue();			
		}
		return total;
	}

}
