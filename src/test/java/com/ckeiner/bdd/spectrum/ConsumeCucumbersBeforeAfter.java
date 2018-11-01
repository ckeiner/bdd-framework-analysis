package com.ckeiner.bdd.spectrum;

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

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.greghaskins.spectrum.Spectrum;

/**
 * Uses before, after and some System.out.printlns to showcase the execution
 * order.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class ConsumeCucumbersBeforeAfter
{
    {
        feature("Cucumber Consumation", () ->
            {
                System.out.println("Starting feature");
                scenario("Eating less cucumbers than I have ", () ->
                    {
                        System.out.println("Starting scenario");
                        final AtomicInteger cukes = new AtomicInteger();
                        given("I have 12 cucumbers", () ->
                            {
                                System.out.println("Executing scenario");
                                cukes.set(12);
                            });
                        when("I eat 5 cucumbers", () ->
                            {
                                cukes.addAndGet(-5);
                            });
                        then("I have 7 cucumbers left", () ->
                            {
                                assertThat(cukes.get(), equalTo(7));
                            });
                    });

                scenarioOutline("Eating less cucumbers than I have ", (have, eat, remaining) ->
                    {
                        System.out.println("Starting scenario outline");
                        final AtomicInteger cukes = new AtomicInteger();
                        given("I have " + have + " cucumbers", () ->
                            {
                                System.out.println("Executing scenario outline");
                                cukes.set(have);
                            });
                        when("I eat " + eat + " cucumbers", () ->
                            {
                                cukes.addAndGet(-eat);
                            });
                        then("I have " + remaining + " cucumbers left", () ->
                            {
                                assertThat(cukes.get(), equalTo(remaining));
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
