package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.example;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.feature;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.given;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.scenarioOutline;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.then;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.when;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.withExamples;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.ckeiner.CucumberEater;
import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;

/**
 * Transmitting state between executions.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class StateWithOutline
{
    {
        feature("Circumvent the final requirement for variables", () ->
            {
                scenarioOutline("Eating less cucumbers than I have ", (have, eat, remaining) ->
                    {
                        Variable<CucumberEater> eater = new Variable<>();
                        given("I have " + have + " cucumbers", () ->
                            {
                                Assert.assertNull("Variable should be null", eater.get());
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
