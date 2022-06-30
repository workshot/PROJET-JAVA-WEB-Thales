package model;

import java.util.HashMap;
import java.util.Map;

public class Panier {
	private Map<Integer, Integer> items; // idArticle ; quantite

	public Panier() {
		this.items = new HashMap<>();
	}

	public void addItem(Article article, int quantite) {
		if (items.containsKey(article.getId())) {
			quantite += items.get(article.getId());
		}
		items.put(article.getId(), quantite);
	}

	public Map<Integer, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Integer, Integer> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Panier [items=" + items + "]";
	}

}
