package com.highroll;
import java.util.*;

public class ManaCostDec extends QueryDecorator {
    private String manaCost;

    public ManaCostDec(Query q, String mana) {
        super(q);
        this.manaCost = mana;
    }

    @Override
    public String getQuery() {
        return (query.getQuery() + "&manaCost=" + manaCost);
    }

    @Override
    public String toString() {
        return (getAPI() + getQuery() + getAccess()); 
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

    @Override
    public String getAccess() {
        return query.getAccess();
    }
}