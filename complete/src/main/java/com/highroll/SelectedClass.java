package com.highroll;
import java.util.*;

public class SelectedClass {
    private String deckClass;

    public SelectedClass(String deckClass) {
        this.deckClass = deckClass;
    }

    public String getCurr() {
        return this.deckClass;
    }

    public String getCurrNeutral() {
        return this.deckClass + ",neutral";
    }

    public String getAll() {
        return "all";
    }
}