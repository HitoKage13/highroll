package com.highroll;
import java.util.*;

public class RarityDec extends QueryDecorator {
    private String rarity;

    public RarityDec(Query q, String rarity) {
        super(q);
        this.rarity = rarity;
    }

    @Override
    public String getQuery() {
        return (query.getQuery() + "&rarity=" + rarity);
    }

    @Override
    public String toString() {
        return (getAPI() + getQuery());
    }

    @Override
    public String getType() {
        return query.getType();
    }

    @Override
    public String getDeckClass() {
        return query.getDeckClass();
    }

    @Override
    public String getFormat() {
        return query.getFormat();
    }

    @Override
    public String getAPI() {
        return query.getAPI();
    }
}