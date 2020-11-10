package com.highroll;
// import java.net.URL;
// import java.net.MalformedURLException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Card {

	private String name;
	// private URL art;

	public Card(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/* public URL getArt() {
		return art;
	} */
}