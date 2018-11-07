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

import org.junit.runner.RunWith;

import com.ckeiner.CucumberEater;
import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;

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
                final Variable<CucumberEater> eater = new Variable<>();
                scenario("Eating less cucumbers than I have ", () ->
                    {
                        given("I have 12 cucumbers", () ->
                            {
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
                        given("I have " + have + " cucumbers", () ->
                            {
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
}
