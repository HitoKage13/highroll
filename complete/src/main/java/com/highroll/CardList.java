package com.highroll;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CardList {

	private List<Card> cards;

	public CardList() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.cards.add(card);
    }

    public String getName(Card c) {
        return c.getName();
    }

    public List<Card> getCards() {
        return this.cards;
    }
    
    public void printNames() {
        for (Card c : cards) {
            System.out.println(c.getName());
        }
    }

	/* public URL getArt() {
		return art;
	} */
}