package com.highroll;
import java.util.*;

class CardData {
    private Map<String, Query> cd;
    private SelectedClass dc = new SelectedClass("mage");

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

        // Madness at the Darkmoon Faire
        this.cd.put("K'thir Ritualist", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "4"));
        this.cd.put("Cenarion Ward", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "8"));
        this.cd.put("Snack Run", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Palm Reading", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Magicfin", new RarityDec(new BaseQuery("minion", dc.getAll()), "legendary"));

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

        // Galakrond's Awakening
        this.cd.put("Chopshop Copter", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "mech"));
        this.cd.put("Dark Prophecy", new ManaCostDec(new BaseQuery("minion", dc.getCurrNeutral()), "2"));
        this.cd.put("Waxmancy", new KeywordDec(new BaseQuery("minion", dc.getCurrNeutral()), "battlecry"));
        this.cd.put("Twisted Knowledge", new BaseQuery("", "warlock"));

        // Descent of Dragons
        // is this all classes?
        this.cd.put("Zul'Drak Ritualist", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "1"));
        this.cd.put("Cobalt Spellkin", new ManaCostDec(new BaseQuery("spell", dc.getCurrNeutral()), "1"));
        this.cd.put("Transmogrifier", new RarityDec(new BaseQuery("minion", dc.getAll()), "legendary"));
        this.cd.put("Wyrmrest Purifier", new BaseQuery("", dc.getCurr()));
        this.cd.put("Draconic Studies", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Skyfin", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "murloc"));
        this.cd.put("Dragonqueen Alexstrasza", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "dragon"));
        this.cd.put("Emerald Explorer", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Ysera, Unleashed", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "dragon"));
        this.cd.put("Primordial Explorer", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Azure Explorer", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Arcane Breath", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Bronze Explorer", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "dragon"));
        this.cd.put("Lightforged Crusader", new BaseQuery("", "paladin"));
        this.cd.put("Bandersmosh", new RarityDec(new BaseQuery("minion", dc.getAll()), "legendary"));
        this.cd.put("Sky Raider", new MinionTypeDec(new BaseQuery("minion", dc.getCurrNeutral()), "pirate"));

        // Saviors of Uldum
        this.cd.put("Jar Dealer", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "1"));
        this.cd.put("Fishflinger", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "murloc"));
        this.cd.put("Golden Scarab", new ManaCostDec(new BaseQuery("", dc.getCurrNeutral()), "4"));
        this.cd.put("Vulpera Scoundrel", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Hunter's Pack", new BaseQuery("", "hunter"));
        this.cd.put("Dune Sculptor", new BaseQuery("minion", "mage"));
        this.cd.put("Puzzle Box of Yogg-Saron", new BaseQuery("spell", dc.getAll()));
        this.cd.put("Raid the Sky Temple", new BaseQuery("spell", "mage"));
        this.cd.put("Pharaoh Cat", new KeywordDec(new BaseQuery("minion", dc.getAll()), "reborn"));
        this.cd.put("Whirlkick Master", new KeywordDec(new BaseQuery("", dc.getCurrNeutral()), "combo"));
        this.cd.put("Plague of Murlocs", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "murloc"));
        this.cd.put("Diseased Vulture", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "3"));
        this.cd.put("Frightened Flunky", new KeywordDec(new BaseQuery("minion", dc.getCurrNeutral()), "taunt"));

        // Rise of Shadows
        this.cd.put("Exotic Mountseller", new ManaCostDec(new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "beast"), "3"));
        this.cd.put("Big Bad Archmage", new ManaCostDec(new BaseQuery("minion", dc.getAll()), "6"));
        this.cd.put("Lifeweaver", new BaseQuery("spell", "druid"));
        this.cd.put("Crystalsong Portal", new BaseQuery("minion", "druid"));
        this.cd.put("Marked Shot", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Shimmerfly", new BaseQuery("spell", "hunter"));
        this.cd.put("Messenger Raven", new BaseQuery("minion", "mage"));
        this.cd.put("Magic Trick", new ManaCostDec(new BaseQuery("spell", "mage"), "0,1,2,3"));
        this.cd.put("Mana Cyclone", new BaseQuery("spell", "mage"));
        this.cd.put("Power of Creation", new ManaCostDec(new BaseQuery("minion", dc.getCurrNeutral()), "6"));
        this.cd.put("Kalecgos", new BaseQuery("spell", dc.getCurrNeutral()));
        this.cd.put("Underbelly Angler", new MinionTypeDec(new BaseQuery("minion", dc.getAll()), "murloc"));
        this.cd.put("Swampqueen Hagatha", new BaseQuery("spell", "shaman"));
        this.cd.put("Arch-Villain Rafaam", new RarityDec(new BaseQuery("minion", dc.getAll()), "legendary"));
    }
}