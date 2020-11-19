package com.highroll;

import java.util.*;
import java.net.URL;
import java.net.MalformedURLException;

import org.json.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;s
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cards")
public class QueryController {
    private final String api = "https://us.api.blizzard.com/hearthstone/cards?";
    private AccessToken a = new AccessToken();
    private String accessToken = "?access_token=" + getToken();
    private static final String template = "Class: %s!";

    public String getToken() {
        return this.a.getToken();
    }

    // don't need this function
    public String getCard(String name) {
        // API call
        RestTemplate r = new RestTemplate();
        String response = r.getForObject(
            "https://us.api.blizzard.com/hearthstone/cards/?name={name}&locale=en_US&access_token=" + getToken(),
            String.class, name);

        // parse into JSON
        JSONObject query = new JSONObject(response);
        JSONObject card = query.getJSONArray("cards").getJSONObject(0);
        return card.getString("name");
    }

    // Test query
	@GetMapping("/classes")
	public void getClass(@RequestParam(value="name", defaultValue = "Mage") String name) throws MalformedURLException  {
        System.out.println(name);
        //return new Card(String.format(template, name));
        // return new Card("Mage", new URL("www.google.com"));
    }

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
    }
    
    // Queries the card you are searching for
    @RequestMapping(value="/data/{name}", method = RequestMethod.GET)
    public List<String> fetchCardChoices(@PathVariable("name") String name) {
        // API call
        RestTemplate r = new RestTemplate();
        List<String> returnedList = new ArrayList();
        // get the associated card from card database
        CardData cd = new CardData();
        Map<String, Query> data = cd.getCardData();
        Query q = data.get(name);
        String response = r.getForObject(q.toString() + "&access_token=" + getToken(), String.class);

        // parse into JSON to get all the results
        JSONObject query = new JSONObject(response);
        JSONArray cards = query.getJSONArray("cards");
        for (Object c : cards) {
            returnedList.add(((JSONObject)c).getString("name"));
        }

        // return a list of the names
        return returnedList;
    }
}
