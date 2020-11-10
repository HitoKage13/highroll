package com.example.springboot;

import java.util.*;
import java.net.URL;
import java.net.MalformedURLException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cards")
public class QueryController {

    private final String api = "https://us.api.blizzard.com/hearthstone/cards?";
    private final String accessToken = "?access_token=USQXf5Wq3lsFR7d8p9WVy3N3Nk8t2bcqQN";
    private static final String template = "Class: %s!";
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
    
    @GetMapping("/test")
    public void getCard(@RequestParam(value="name", defaultValue="Wandmaker") String name) {
        RestTemplate r = new RestTemplate();
        System.out.println("testttttt");
        CardList response = r.getForObject(
            "https://us.api.blizzard.com/hearthstone/cards/?name=" + name + "&locale=en_US&access_token=USQXf5Wq3lsFR7d8p9WVy3N3Nk8t2bcqQN", CardList.class);
        
        System.out.println("gahhhhhhhh");
        List<Card> cards = response.getCards();
        System.out.println(cards.length);
    }

}
