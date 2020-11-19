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
        this.accessToken = generateToken();
        this.type = type;
        this.deckClass = deckClass;
        this.format = "standard";
    }

    public String generateToken() {
        AccessToken a = new AccessToken();
        return "&access_token=" + a.getToken();
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
