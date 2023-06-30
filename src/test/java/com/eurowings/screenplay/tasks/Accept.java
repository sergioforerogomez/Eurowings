package com.eurowings.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.eurowings.pages.FlightStatusPage.ACCEPT_CONSENT_BUTTON;

public class Accept {
    public static Performable theConsent() {
        return Task.where(
                "{0} accepts the consent",
                Click.on(ACCEPT_CONSENT_BUTTON)
        );
    }
}
