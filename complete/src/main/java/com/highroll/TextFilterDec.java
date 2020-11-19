package com.highroll;
import java.util.*;

public class TextFilterDec extends QueryDecorator {
    private String textFilter;

    public TextFilterDec(Query q, String textFilter) {
        super(q);
        this.textFilter = textFilter;
    }

    @Override
    public String getQuery() {
        return (query.getQuery() + "&textFilter=" + textFilter);
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