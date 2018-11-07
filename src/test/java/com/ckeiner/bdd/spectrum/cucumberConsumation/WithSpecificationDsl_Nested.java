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
 * Shows how the execution in describe and it works.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class WithSpecificationDsl_Nested
{
    {
        describe("Cucumber Consumation", () ->
            {
                final Variable<CucumberEater> eater = new Variable<>();
                it("Eating less cucumbers than I have ", () ->
                    {
                        System.out.println("Executing outer it");
                        eater.set(new CucumberEater(12));
                        eater.get().eat(5);
                        assertThat(eater.get().cucumbers(), equalTo(7));
                    });

                describe("Eating less cucumbers than I have with Examples", () ->
                    {
                        System.out.println("Executing inner describe");
                        eater.set(new CucumberEater(12));
                        eater.get().eat(5);
                        assertThat(eater.get().cucumbers(), equalTo(7));

                        it("Eating less cucumbers than I have ", () ->
                            {
                                System.out.println("Executing inner it");
                                eater.set(new CucumberEater(12));
                                eater.get().eat(5);
                                assertThat(eater.get().cucumbers(), equalTo(7));
                            });
                    });
            });
    }
}
