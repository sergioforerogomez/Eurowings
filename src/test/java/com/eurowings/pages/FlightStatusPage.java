package com.eurowings.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.function.Function;

@DefaultUrl("https://www.eurowings.com/en/information/at-the-airport/flight-status.html")
public class FlightStatusPage extends PageObject {
    public static Target ACCEPT_CONSENT_BUTTON = Target.the("Accept consent button").located(By.cssSelector(".cookie-consent--cta-accept"));
    public static Target DEPARTURE_AIRPORT_BUTTON = Target.the("Departure airport button").located(By.cssSelector(".o-compact-search__bar-item--station-select-origin button"));
    public static Target DEPARTURE_AIRPORT_INPUT = Target.the("Departure airport input").located(By.cssSelector(".o-compact-search__bar-item--station-select-origin input"));
    public static Target DESTINATION_AIRPORT_BUTTON = Target.the("Destination airport button").located(By.cssSelector(".o-compact-search__bar-item--station-select-destination button"));
    public static Target DESTINATION_AIRPORT_INPUT = Target.the("Destination airport input").located(By.cssSelector(".o-compact-search__bar-item--station-select-destination input"));
    public static Target SEARCH_FLIGHTS_STATUS_DATE = Target.the("Search flights status date").located(By.cssSelector(".o-search-flight-status__date-navigation__date--active"));
    public static Target SEARCH_RESULTS = Target.the("Search results").located(By.cssSelector(".o-search-flight-status__card"));
    public static Target SHOW_FLIGHT_STATUS_BUTTON = Target.the("Show flight status button").located(By.cssSelector(".fieldset-form-footer button"));
    public static Target TRAVEL_DATE_INPUT = Target.the("Travel date input").located(By.name("datepicker_input_27"));
    public static Target TRAVEL_DATE_NAVIGATION_BUTTON = Target.the("Travel date navigation button").located(By.cssSelector(".calendar__previous-month:not([disabled]),.calendar__next-month:not([disabled])"));
    public static Function<String, Target> TRAVEL_DATE_VALUE = date -> Target.the("Travel date value").located(By.cssSelector(String.format("[value='%s']", date)));
}
