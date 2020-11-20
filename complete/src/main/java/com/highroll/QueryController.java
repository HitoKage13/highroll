package com.highroll;

import java.util.*;
import java.net.URL;
import java.net.MalformedURLException;

import org.json.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin
@RequestMapping("/cards")
public class QueryController {
    private final String api = "https://us.api.blizzard.com/hearthstone/cards?";
    private AccessToken a = new AccessToken();
    private String accessToken = "?access_token=" + getToken();
    private static final String template = "Class: %s!";

    public String getToken() {
        return this.a.getToken();
    }

    // searches for a single card
    @RequestMapping(value="/search/{name}", method = RequestMethod.GET)
    public String getCard(@PathVariable("name") String name) {
        // API call
        RestTemplate r = new RestTemplate();
        String response = r.getForObject(
            "https://us.api.blizzard.com/hearthstone/cards/?textFilter={name}&collectible=1&locale=en_US&access_token=" + getToken(),
            String.class, name);

        // parse into JSON
        JSONObject query = new JSONObject(response);
        JSONArray cards = query.getJSONArray("cards");
        List<JSONObject> jList = new ArrayList();
        int count = 0;
        for (Object c : cards) {
            JSONObject json = new JSONObject().put("name", ((JSONObject)c).getString("name"))
            .put("image", ((JSONObject)c).getString("image"));
            jList.add(json);
            count += 1;
            if (count >= 10) {
                break;
            }
        }
        
        // JSONObject card = query.getJSONArray("cards").getJSONObject(0);
        return jList.toString();
        // return card.toString();
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
    public String fetchCardChoices(@PathVariable("name") String name) {
        // API call
        RestTemplate r = new RestTemplate();
        List<JSONObject> returnedList = new ArrayList();
        // get the associated card from card database
        CardData cd = new CardData();
        Map<String, Query> data = cd.getCardData();
        Query q = data.get(name);
        String response = r.getForObject(q.toString() + "&access_token=" + getToken(), String.class);

        // parse into JSON to get all the results
        JSONObject query = new JSONObject(response);
        JSONArray cards = query.getJSONArray("cards");
        for (Object c : cards) {
            returnedList.add((JSONObject)c);
        }

        // return a list of the names
        return returnedList.toString();
    }
}
