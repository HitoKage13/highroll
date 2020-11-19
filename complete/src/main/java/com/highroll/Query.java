package com.highroll;
import java.util.*;

public interface Query {
    // String addQuery(String s);
    String getQuery();
    String getType();
    String getFormat();
    String getDeckClass();
    String getAPI();
    String toString();
}