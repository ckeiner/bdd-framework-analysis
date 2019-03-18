package com.ckeiner.bdd.testbddy.tests;

import static com.xceptance.testbddy.api.BddSuite.feature;
import static com.xceptance.testbddy.api.BddSuite.given;
import static com.xceptance.testbddy.api.BddSuite.scenario;

import org.junit.Assert;
import org.junit.Test;

import com.ckeiner.CucumberEater;

public class ConsumingCucumbers_Reporting
{
    CucumberEater cucumberEater;

    @Test
    public void canConsumeCucumbers()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberEater.eat(5);
                        })
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void throwError()
    {
        //@formatter:off
        feature("Erroneous cucumber consumption",
                () -> scenario("Eating erroneous cucumbers",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 20 cucumbers", () -> {
                            cucumberEater.eat(20);
                        })
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void throwIntentionalException()
    {
        //@formatter:off
        feature("Cucumber consumption with intentional failure",
                () -> scenario("Eating cucumbers",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 20 cucumbers", () -> {
                            cucumberEater.eat(20);
                            throw new IllegalArgumentException("Intentional Exception");
                        })
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }
}
