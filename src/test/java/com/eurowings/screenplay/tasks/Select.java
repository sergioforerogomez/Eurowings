package com.eurowings.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.eurowings.pages.FlightStatusPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static org.openqa.selenium.Keys.ENTER;

public class Select {
    public static Performable theDepartureAirport(String departureAirport) {
        return Task.where(
                "{0} selects the departure airport",
                Click.on(DEPARTURE_AIRPORT_BUTTON),
                Enter.theValue(departureAirport).into(DEPARTURE_AIRPORT_INPUT).thenHit(ENTER),
                WaitUntil.the(DEPARTURE_AIRPORT_INPUT, isNotVisible())
        );
    }

    public static Performable theDestinationAirport(String destinationAirport) {
        return Task.where(
                "{0} selects the destination airport",
                Click.on(DESTINATION_AIRPORT_BUTTON),
                Enter.theValue(destinationAirport).into(DESTINATION_AIRPORT_INPUT).thenHit(ENTER),
                WaitUntil.the(DESTINATION_AIRPORT_INPUT, isNotVisible())
        );
    }

    public static Performable theTravelDate(String travelDate) {
        return Task.where(
                "{0} selects the travel date",
                new SelectTravelDate(travelDate)
        );
    }

    static class SelectTravelDate implements Performable {
        private final String travelDate;

        public SelectTravelDate(String travelDate) {
            this.travelDate = travelDate;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Click.on(TRAVEL_DATE_INPUT)
            );
            if (!TRAVEL_DATE_VALUE.apply(travelDate).resolveFor(actor).isPresent()) {
                actor.attemptsTo(
                        Click.on(TRAVEL_DATE_NAVIGATION_BUTTON)
                );
            }
            actor.attemptsTo(
                    Click.on(TRAVEL_DATE_VALUE.apply(travelDate))
            );
        }
    }
}
