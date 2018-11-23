package com.ckeiner.bdd.spectrum.reuse.fixtures.gherkin;

import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.example;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.feature;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.given;
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
 * Uses a method to extract common before steps.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class MethodReuse
{
    {
        feature("A feature", () ->
            {
                final Variable<CucumberEater> eater = new Variable<>();
                scenarioOutline("Eating less cucumbers than I have ", (browser, have, eat, remaining) ->
                    {
                        openBrowser(browser);

                        given("I have " + have + " cucumbers", () ->
                            {
                                eater.set(new CucumberEater(12));
                            });
                        when("I eat " + eat + " cucumbers", () ->
                            {
                                eater.get().eat(5);
                            });
                        then("I have 7 cucumbers left", () ->
                            {
                                assertThat(eater.get().cucumbers(), equalTo(7));
                            });
                    }, withExamples(example("Chrome", 12, 5, 7), example("Firefox", 20, 5, 15)));
            });
    }

    private static void openBrowser(String browser)
    {
        given(browser + " is opened", () ->
            {
                System.out.println(browser);
            });
    }
}
