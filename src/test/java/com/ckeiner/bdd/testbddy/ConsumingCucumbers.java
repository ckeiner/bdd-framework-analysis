package com.ckeiner.bdd.testbddy;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.given;
import static com.ckeiner.testbddy.api.BddSuite.scenario;
import static com.ckeiner.testbddy.api.BddSuite.withData;

import org.junit.Assert;
import org.junit.Test;

import com.ckeiner.CucumberEater;
import com.ckeiner.bdd.testbddy.testdata.CucumberData;
import com.ckeiner.testbddy.api.DynamicHolder;

public class ConsumingCucumbers
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
                    ),
                () -> scenario("Eating more cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberHolder.set(new CucumberEater(12));
                        })
                        .when("I eat 20 cucumbers", () -> {
                            cucumberHolder.get().eat(20);
                        })
                        .then("I have 12 cucumbers left", () -> {
                            Assert.assertEquals(12, cucumberHolder.get().cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void canConsumeCucumbersWithTestData()
    {
        DynamicHolder<CucumberEater> cucumberHolder = new DynamicHolder<CucumberEater>();
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have",
                        withData(new CucumberData(12, 5, 7), new CucumberData(12, 20, 12))
                        .given("I have 12 cucumbers", (data) -> {
                            cucumberHolder.set(new CucumberEater(data.cucumbers));
                        })
                        .when("I eat 5 cucumbers", (data) -> {
                            cucumberHolder.get().eat(data.eaten);
                        })
                        .then("I have 7 cucumbers left", (data) -> {
                            Assert.assertEquals(data.left, cucumberHolder.get().cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }
}
