package com.highroll;
import java.util.*;

public class MinionTypeDec extends QueryDecorator {
    private String minionType;

    public MinionTypeDec(Query q, String minionType) {
        super(q);
        this.minionType = minionType;
    }

    @Override
    public String getQuery() {
        return (query.getQuery() + "&minionType=" + minionType);
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