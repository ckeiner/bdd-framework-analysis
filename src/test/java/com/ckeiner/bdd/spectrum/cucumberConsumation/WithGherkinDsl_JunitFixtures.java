package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.example;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.feature;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.given;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.scenario;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.scenarioOutline;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.then;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.when;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.withExamples;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ckeiner.CucumberEater;
import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;

/**
 * Uses before and after to proof that JUnits Before and After do not work.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class WithGherkinDsl_JunitFixtures
{
    {
        feature("Cucumber Consumation", () ->
            {
                System.out.println("Starting feature");
                final Variable<CucumberEater> eater = new Variable<>();
                scenario("Eating less cucumbers than I have ", () ->
                    {
                        System.out.println("Starting scenario");
                        given("I have 12 cucumbers", () ->
                            {
                                System.out.println("Executing scenario");
                                eater.set(new CucumberEater(12));
                            });
                        when("I eat 5 cucumbers", () ->
                            {
                                eater.get().eat(5);
                            });
                        then("I have 7 cucumbers left", () ->
                            {
                                assertThat(eater.get().cucumbers(), equalTo(7));
                            });
                    });

                scenarioOutline("Eating less cucumbers than I have ", (have, eat, remaining) ->
                    {
                        System.out.println("Starting scenario outline");
                        given("I have " + have + " cucumbers", () ->
                            {
                                System.out.println("Executing scenario outline");
                                eater.set(new CucumberEater(have));
                            });
                        when("I eat " + eat + " cucumbers", () ->
                            {
                                eater.get().eat(eat);
                            });
                        then("I have " + remaining + " cucumbers left", () ->
                            {
                                assertThat(eater.get().cucumbers(), equalTo(remaining));
                            });
                    }, withExamples(example(12, 5, 7), example(20, 5, 15)));
            });
    }

    @Before
    public void fooBefore()
    {
        System.out.println("Before Method");
    }

    @BeforeClass
    public static void fooBeforeClass()
    {
        System.out.println("Before Class Method");
    }

    @After
    public void fooAfter()
    {
        System.out.println("After Method");
    }

    @AfterClass
    public static void fooAfterClass()
    {
        System.out.println("After Class Method");
    }
}
