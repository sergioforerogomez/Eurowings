package com.eurowings.screenplay.tasks.common;

import com.eurowings.pages.FlightStatusPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theFlightStatusPage() {
        return Task.where(
                "{0} opens the flight status page",
                Open.browserOn().the(FlightStatusPage.class)
        );
    }
}
