package com.highroll;
import java.util.*;

class CardData {
    private Map<String, Query> cd;
    private SelectedClass dc = new SelectedClass("warlock");

    public CardData() {
        this.cd = new HashMap<String, Query>();
        this.initialise();
    }

    public Map<String, Query> getCardData() {
        return this.cd;
    }

	public void initialise() {
        // Basic & Classic
        this.cd.put("Barrens Stablehand", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "beast"));
        this.cd.put("Brightwing", new RarityDec(new BaseQuery("minion", dc.getAll()), "legendary"));
        this.cd.put("Tome of Intellect", new BaseQuery("spell", "mage"));

        // need to check if it can grab other classes' Demons
        this.cd.put("Call of the Void", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "demon"));
        this.cd.put("Bane of Doom", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "demon"));

        // Scholomance Academy
        this.cd.put("Wandmaker", new ManaCostDec(new BaseQuery("spell", dc.getCurrNeutral()), "1"));
        this.cd.put("Steward of Scrolls", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Onyx Magescribe", new BaseQuery("spell", dc.getCurr()));
        this.cd.put("Plagued Protodrake", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "7"));
        this.cd.put("Nature Studies", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Partner Assignment", new MinionTypeDec(new ManaCostDec(new BaseQuery("spell", dc.getCurr()), "2,3"), "beast"));
        this.cd.put("Carrion Studies", new KeywordDec(new BaseQuery("minion", dc.getCurrNeutral()), "deathrattle"));
        this.cd.put("First Day of School", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "1"));
        this.cd.put("Draconic Studies", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Shifty Sophomore", new KeywordDec(new BaseQuery("", dc.getCurrNeutral()), "combo"));
        this.cd.put("Instructor Fireheart", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Demonic Studies", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "demon"));
        this.cd.put("Athletic Studies", new KeywordDec(new BaseQuery("minion", dc.getCurrNeutral()), "rush"));
        this.cd.put("In Formation!", new KeywordDec(new BaseQuery("minion", dc.getCurrNeutral()), "taunt"));
        this.cd.put("Teacher's Pet", new ManaCostDec(new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "beast"), "3"));
        this.cd.put("Primordial Studies", new KeywordDec(new BaseQuery("minion", dc.getCurrNeutral()), "spell damage"));
        this.cd.put("Trick Totem", new ManaCostDec(new BaseQuery("spell", dc.getAll()), "0,1,2,3"));
        this.cd.put("Magic Trick", new ManaCostDec(new BaseQuery("spell", "mage"), "0,1,2,3"));
        this.cd.put("Wand Thief", new BaseQuery("spell", "mage"));
        this.cd.put("Jandice Barov", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "5"));

        // Ashes of Outland
        this.cd.put("Netherwalker", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "demon"));
        this.cd.put("Marsh Hydra", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "8"));
        this.cd.put("Netherwind Portal", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "4"));
        this.cd.put("Font of Power", new BaseQuery("minion", "mage"));
        this.cd.put("Apexis Smuggler", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Apexis Blast", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "5"));
        this.cd.put("Evocation", new BaseQuery("spell", "mage"));
        this.cd.put("Solarian Prime", new BaseQuery("spell", "mage"));
        this.cd.put("Underlight Angling Rod", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "murloc"));
        this.cd.put("Murgurgle Prime", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "murloc"));
        this.cd.put("Renew", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Sethekk Veilweaver", new BaseQuery("spell", "priest"));
        this.cd.put("Skeletal Dragon", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Marshspawn", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Serpentshrine Portal", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "3"));
        this.cd.put("Shadow Council", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "demon"));
    }
}