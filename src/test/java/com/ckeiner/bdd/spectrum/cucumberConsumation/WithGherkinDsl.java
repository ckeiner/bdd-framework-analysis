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

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.runner.RunWith;

import com.greghaskins.spectrum.Spectrum;

/**
 * Consuming cucumbers with GherkinDSL.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class WithGherkinDsl
{
    {
        feature("Cucumber Consumation", () ->
            {
                scenario("Eating less cucumbers than I have ", () ->
                    {
                        final AtomicInteger cukes = new AtomicInteger();
                        given("I have 12 cucumbers", () ->
                            {
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
                        final AtomicInteger cukes = new AtomicInteger();
                        given("I have " + have + " cucumbers", () ->
                            {
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
}
