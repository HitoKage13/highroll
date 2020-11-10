package com.highroll;
import java.util.*;

public class BaseQuery implements Query {
    private String api;
    private String accessToken;
    private String type;
    private String deckClass;
    private String format;

    public BaseQuery(String type, String deckClass) {
        this.api = "https://us.api.blizzard.com/hearthstone/cards/?locale=en_US";
        this.accessToken = "&access_token=USQXf5Wq3lsFR7d8p9WVy3N3Nk8t2bcqQN";
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
        return (getAPI() + getQuery() + getAccess()); 
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

    @Override
    public String getAccess() {
        return accessToken;
    }
}
