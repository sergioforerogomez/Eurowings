package com.eurowings.stepdefinitions;

import com.eurowings.screenplay.questions.TheFlightStatus;
import com.eurowings.screenplay.tasks.Accept;
import com.eurowings.screenplay.tasks.Search;
import com.eurowings.screenplay.tasks.Select;
import com.eurowings.screenplay.tasks.common.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.eurowings.utils.Constants.THE_DATE;
import static com.eurowings.utils.DateUtils.formatLocalDate;
import static com.eurowings.utils.DateUtils.parseDate;
import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.US;

public class FlightStatusStepDefinitions {
    final String WITH_DATE_FORMAT = "yyyy-MM-dd";

    @Given("{actor} is looking for Eurowings flights status")
    public void isLookingForAnEurowingsFlightStatus(Actor theActor) {
        theActor.attemptsTo(
                NavigateTo.theFlightStatusPage(),
                Accept.theConsent()
        );
    }

    @Given("{actor} is going from {string}")
    public void isGoingFrom(Actor theActor, String departureAirport) {
        theActor.attemptsTo(
                Select.theDepartureAirport(departureAirport)
        );
    }

    @Given("{actor} is going to {string}")
    public void isGoingTo(Actor theActor, String destinationAirport) {
        theActor.attemptsTo(
                Select.theDestinationAirport(destinationAirport)
        );
    }

    @Given("{actor} is travelling {string}")
    public void isTravelling(Actor theActor, String travelDate) {
        travelDate = parseDate(travelDate, WITH_DATE_FORMAT);
        theActor.attemptsTo(
                Select.theTravelDate(travelDate)
        );
        theActor.remember(THE_DATE.name, travelDate);
    }

    @When("{actor} looks for the flights routes status")
    public void looksForTheFlightsRoutesStatus(Actor theActor) {
        theActor.attemptsTo(
                Search.theFlightsStatus()
        );
    }

    @Then("all the flights routes status are shown for the given date")
    public void allTheFlightRoutesStatusAreShownForTheGivenDate() {
        final String withDateFormat = "EEE, dd/MM/";
        Actor theActor = OnStage.theActorInTheSpotlight();
        String expectedDate = formatLocalDate(parse(theActor.recall(THE_DATE.name), ofPattern(WITH_DATE_FORMAT)), withDateFormat, US);

        theActor.attemptsTo(
                Ensure.that(TheFlightStatus.searchDate()).isEqualTo(expectedDate),
                Ensure.that(TheFlightStatus.hasSearchResults()).isTrue()
        );
    }
}
