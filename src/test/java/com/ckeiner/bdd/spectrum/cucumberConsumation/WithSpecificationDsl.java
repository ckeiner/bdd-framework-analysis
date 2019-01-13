package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

import com.ckeiner.CucumberEater;
import com.greghaskins.spectrum.Spectrum;

/**
 * Consuming cucumbers with SpecificationDSL.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class WithSpecificationDsl
{
    {
        describe("Cucumber Consumation", () ->
            {
                it("Eating less cucumbers than I have ", () ->
                    {
                        CucumberEater eater = new CucumberEater(12);
                        eater.eat(5);
                        assertThat(eater.cucumbers(), equalTo(7));
                    });

                describe("Eating less cucumbers than I have with Examples", () ->
                    {
                        it("12, 5, 7", () ->
                            {
                                consumeCucumbers(12, 5, 7);
                            });

                        it("20, 5, 15", () ->
                            {
                                consumeCucumbers(20, 5, 15);
                            });
                    });
            });
    }

    public static void consumeCucumbers(int have, int eat, int remaining)
    {
        CucumberEater eater = new CucumberEater(have);
        eater.eat(eat);
        assertThat(eater.cucumbers(), equalTo(remaining));
    }
}
