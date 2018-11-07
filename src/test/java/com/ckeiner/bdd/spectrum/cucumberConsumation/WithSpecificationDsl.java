package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

import com.ckeiner.CucumberEater;
import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;

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
                final Variable<CucumberEater> eater = new Variable<>();
                it("Eating less cucumbers than I have ", () ->
                    {
                        eater.set(new CucumberEater(12));
                        eater.get().eat(5);
                        assertThat(eater.get().cucumbers(), equalTo(7));
                    });

                describe("Eating less cucumbers than I have with Examples", () ->
                    {
                        it("12, 5, 7", () ->
                            {
                                eater.set(new CucumberEater(12));
                                eater.get().eat(5);
                                assertThat(eater.get().cucumbers(), equalTo(7));
                            });

                        it("20, 5, 15", () ->
                            {
                                eater.set(new CucumberEater(12));
                                eater.get().eat(5);
                                assertThat(eater.get().cucumbers(), equalTo(7));
                            });
                    });
            });
    }
}
