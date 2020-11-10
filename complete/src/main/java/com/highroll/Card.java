package com.highroll;
// import java.net.URL;
// import java.net.MalformedURLException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Card {

	private String name;
	private Query q;
	// private URL art;

	public Card(String name, Query q) {
		this.name = name;
		this.q = q;
	}

	public String getName() {
		return name;
	}

	public Query getQuery() {
		return q;
	}

	/* public URL getArt() {
		return art;
	} */
}