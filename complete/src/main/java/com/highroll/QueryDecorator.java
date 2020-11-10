package com.highroll;
import java.util.*;

public abstract class QueryDecorator implements Query {
    protected Query query;

    public QueryDecorator(Query q) {
        super();
        this.query = q;
    }
}