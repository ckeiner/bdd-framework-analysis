package com.ckeiner.bdd.testbddy.tests;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.given;
import static com.ckeiner.testbddy.api.BddSuite.scenario;
import static com.ckeiner.testbddy.api.BddSuite.with;

import org.junit.Assert;
import org.junit.Test;

import com.ckeiner.CucumberEater;
import com.ckeiner.bdd.testbddy.testdata.CucumberData;

public class ConsumingCucumbers
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
    public void canConsumeErroneousCucumbers()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating cucumbers",
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
    public void canConsumeCucumbersWithTestData()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have",
                        with(new CucumberData(12, 5, 7), new CucumberData(12, 20, 12))
                        .given("I have <data.cucumbers> cucumbers", (data) -> {
                            data.setCucumbers(data.cucumbers);
                        })
                        .when("I eat <data.eaten> cucumbers", (data) -> {
                            data.eat(data.eaten);
                        })
                        .then("I have <data.left> cucumbers left", (data) -> {
                            Assert.assertEquals(data.left, data.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

}
