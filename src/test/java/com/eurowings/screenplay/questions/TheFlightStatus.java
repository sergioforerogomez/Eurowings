package com.eurowings.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;

import static com.eurowings.pages.FlightStatusPage.SEARCH_FLIGHTS_STATUS_DATE;
import static com.eurowings.pages.FlightStatusPage.SEARCH_RESULTS;

public class TheFlightStatus {
    public static Question<String> searchDate() {
        return Question.about("{0} gets the search date").answeredBy(
                Text.of(SEARCH_FLIGHTS_STATUS_DATE)
        );
    }

    public static Question<Boolean> hasSearchResults() {
        return Question.about("{0} validates there are search results").answeredBy(
                Presence.of(SEARCH_RESULTS)
        );
    }
}
