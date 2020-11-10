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
    private SelectedClass dc = new SelectedClass("warlock");
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

        // Basic & Classic
        Query BarrensStablehand = new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "beast");
        Query Brightwing = new RarityDec(new BaseQuery("minion", dc.getAll()), "legendary");
        Query TomeOfIntellect = new BaseQuery("spell", "mage");

        // need to check if it can grab other classes' Demons
        Query CallOfTheVoid = new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "demon");
        Query BaneOfDoom = new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "demon");

        // Scholomance Academy
        Query Wandmaker = new ManaCostDec(new BaseQuery("spell", dc.getCurr()), "1");
        Query StewardOfScrolls = new BaseQuery("spell", dc.getCurr());
        Query OnyxMagescribe = new BaseQuery("spell", dc.getCurr());
        Query PlaguedProtodrake = new ManaCostDec(new BaseQuery("minion", dc.getAll()), "7");
        Query NatureStudies = new BaseQuery("spell", dc.getCurr());
        Query PartnerAssignment = new MinionTypeDec(new ManaCostDec(new BaseQuery("spell", dc.getCurr()), "2,3"), "beast");
        Query CarrionStudies = new TextFilterDec(new BaseQuery("minion", dc.getCurrNeutral()), "Deathrattle:");
        Query FirstDayOfSchool = new ManaCostDec(new BaseQuery("minion", dc.getAll()), "1");
        Query DraconicStudies = new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon");
        Query ShiftySophomore = new TextFilterDec(new BaseQuery("", dc.getCurrNeutral()), "Combo:");
        Query InstructorFireheart = new BaseQuery("spell", dc.getCurrNeutral());
        Query DemonicStudies = new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "demon");
        // Query AthleticStudies
        // Query InFormation
        Query TeachersPet = new ManaCostDec(new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "beast"), "3");
        // Query PrimordialStudies
        Query TrickTotem = new ManaCostDec(new BaseQuery("spell", dc.getAll()), "0,1,2,3");
        Query MagicTrick = new ManaCostDec(new BaseQuery("spell", "mage"), "0,1,2,3");
        Query WandThief = new BaseQuery("spell", "mage");
        Query JandiceBarov = new ManaCostDec(new BaseQuery("minion", dc.getAll()), "5");
        // Query Steeldancer

        String response = r.getForObject(
            "https://us.api.blizzard.com/hearthstone/cards/?textFilter={name}&locale=en_US&access_token=USQXf5Wq3lsFR7d8p9WVy3N3Nk8t2bcqQN",
            String.class, name);

        // System.out.println(FirstDayOfSchool.toString());
        String response2 = r.getForObject(FirstDayOfSchool.toString(), String.class);
        // System.out.println(response2);
        // list to return cards
        List<String> returnedList = new ArrayList();
        
        // parse API call into JSONObject and then into an array of cards
        JSONObject query = new JSONObject(response2);
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
