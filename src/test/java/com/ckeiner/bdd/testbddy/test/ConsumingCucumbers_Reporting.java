package com.ckeiner.bdd.testbddy.test;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.given;
import static com.ckeiner.testbddy.api.BddSuite.scenario;

import org.junit.Assert;
import org.junit.Test;

import com.ckeiner.CucumberEater;
import com.ckeiner.testbddy.api.AbstractExtentReportTest;
import com.ckeiner.testbddy.api.DynamicHolder;

public class ConsumingCucumbers_Reporting extends AbstractExtentReportTest
{
    @Test
    public void canConsumeCucumbers()
    {
        DynamicHolder<CucumberEater> cucumberHolder = new DynamicHolder<CucumberEater>();
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberHolder.set(new CucumberEater(12));
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberHolder.get().eat(5);
                        })
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberHolder.get().cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void throwError()
    {
        DynamicHolder<CucumberEater> cucumberHolder = new DynamicHolder<CucumberEater>();
        //@formatter:off
        feature("Erroneous cucumber consumption",
                () -> scenario("Eating erroneous cucumbers",
                        given("I have 12 cucumbers", () -> {
                            cucumberHolder.set(new CucumberEater(12));
                        })
                        .when("I eat 20 cucumbers", () -> {
                            cucumberHolder.get().eat(20);
                        })
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberHolder.get().cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void throwIntentionalException()
    {
        DynamicHolder<CucumberEater> cucumberHolder = new DynamicHolder<CucumberEater>();
        //@formatter:off
        feature("Cucumber consumption with intentional failure",
                () -> scenario("Eating cucumbers",
                        given("I have 12 cucumbers", () -> {
                            cucumberHolder.set(new CucumberEater(12));
                        })
                        .when("I eat 20 cucumbers", () -> {
                            cucumberHolder.get().eat(20);
                            throw new IllegalArgumentException("Intentional Exception");
                        })
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberHolder.get().cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }
}
