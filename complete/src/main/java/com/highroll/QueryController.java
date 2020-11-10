package com.highroll;

import java.util.*;
import java.net.URL;
import java.net.MalformedURLException;
import org.json.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
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
    private final String accessToken = "?access_token=USQXf5Wq3lsFR7d8p9WVy3N3Nk8t2bcqQN";
    private static final String template = "Class: %s!";

    // Test query
	@GetMapping("/classes")
	public Card getClass(@RequestParam(value="name", defaultValue = "Mage") String name) throws MalformedURLException  {
        System.out.println(name);
        return new Card(String.format(template, name));
        // return new Card("Mage", new URL("www.google.com"));
    }

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
    
    // Queries the card you are searching for
    @RequestMapping(value="/data/{name}", method = RequestMethod.GET)
    public List<String> getCard(@PathVariable("name") String name) {
        // API call
        RestTemplate r = new RestTemplate();
        String response = r.getForObject(
            "https://us.api.blizzard.com/hearthstone/cards/?textFilter={name}&locale=en_US&access_token=USQXf5Wq3lsFR7d8p9WVy3N3Nk8t2bcqQN",
            String.class, name);
        
        // list to return cards
        List<String> returnedList = new ArrayList();
        
        // parse API call into JSONObject and then into an array of cards
        JSONObject query = new JSONObject(response);
        JSONArray cardList = query.getJSONArray("cards");

        for (Object card : cardList) {
            returnedList.add(((JSONObject)card).getString("name"));
            // for testing outputs
            // System.out.println(((JSONObject)card).getString("name"));
        }

        // for testing outputs
        // System.out.println("");

        // return a list of the names
        return returnedList;
    }
}
