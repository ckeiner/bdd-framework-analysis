package com.ckeiner.bdd.testbddy.tests;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.given;
import static com.ckeiner.testbddy.api.BddSuite.scenario;

import org.junit.Assert;
import org.junit.Test;

import com.ckeiner.CucumberEater;
import com.ckeiner.testbddy.api.PendingRunnable;

public class StatusTests
{
    CucumberEater cucumberEater;

    @Test
    public void skipStep()
    {
        //@formatter:off
        feature("Skip a Step",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberEater.eat(5);
                        })
                        .skip()
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void ignoreStep()
    {
        //@formatter:off
        feature("Ignore a step",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberEater.eat(5);
                        })
                        .ignore()
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        }).wip()
                    ).wip()
            ).wip().test();
        //@formatter:on
    }

    @Test
    public void wipStep()
    {
        //@formatter:off
        feature("Step is WIP",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberEater.eat(5);
                        })
                        .wip()
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void skipScenario()
    {
        //@formatter:off
        feature("Skip a scenario",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberEater.eat(5);
                        })
                        .wip()
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    ).skip()
            ).test();
        //@formatter:on
    }

    @Test
    public void ignoreFeature()
    {
        //@formatter:off
        feature("Ignore a feature",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", () -> {
                            cucumberEater.eat(5);
                        })
                        .wip()
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).ignore().test();
        //@formatter:on
    }

    @Test
    public void wipFeature()
    {
        //@formatter:off
        feature("Feature is WIP",
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
            ).wip().test();
        //@formatter:on
    }

    @Test
    public void pendingStep()
    {
        //@formatter:off
        feature("A step is pending",
                () -> scenario("Eating less cucumbers than I have",
                        given("I have 12 cucumbers", () -> {
                            cucumberEater = new CucumberEater(12);
                        })
                        .when("I eat 5 cucumbers", new PendingRunnable())
                        .then("I have 7 cucumbers left", () -> {
                            Assert.assertEquals(7, cucumberEater.cucumbers());
                        })
                    )
            ).test();
        //@formatter:on
    }

    @Test
    public void pendingScenario()
    {
        //@formatter:off
        feature("A scenario is pending",
                () -> scenario("Eating less cucumbers than I have")
            ).test();
        //@formatter:on
    }
}
