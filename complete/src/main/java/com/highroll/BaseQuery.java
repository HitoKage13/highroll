package com.highroll;
import java.util.*;

public class BaseQuery implements Query {
    private String api;
    private String type;
    private String deckClass;
    private String format;

    public BaseQuery(String type, String deckClass) {
        this.api = "https://us.api.blizzard.com/hearthstone/cards/?locale=en_US";
        this.type = type;
        this.deckClass = deckClass;
        this.format = "standard";
    }

    @Override
    public String getQuery() {
        return ("&type=" + getType() + "&class=" + getDeckClass() + "&set=" + getFormat());
    }

    @Override
    public String toString() {
        return (getAPI() + getQuery()); 
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDeckClass() {
        return deckClass;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getAPI() {
        return api;
    }
}
