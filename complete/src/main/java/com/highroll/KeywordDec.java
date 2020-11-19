package com.highroll;
import java.util.*;

public class KeywordDec extends QueryDecorator {
    private String keyword;

    public KeywordDec(Query q, String keyword) {
        super(q);
        this.keyword = keyword;
    }

    @Override
    public String getQuery() {
        return (query.getQuery() + "&keyword=" + keyword);
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