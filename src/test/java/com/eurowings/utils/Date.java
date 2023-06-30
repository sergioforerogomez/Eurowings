package com.eurowings.utils;

public enum Date {
    TODAY("today"), TOMORROW("tomorrow");

    public final String date;

    Date(String date) {
        this.date = date;
    }
}
