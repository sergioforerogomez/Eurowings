package com.eurowings.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.eurowings.pages.FlightStatusPage.SHOW_FLIGHT_STATUS_BUTTON;

public class Search {
    public static Performable theFlightsStatus() {
        return Task.where(
                "{0} search the flights status",
                Click.on(SHOW_FLIGHT_STATUS_BUTTON)
        );
    }
}
