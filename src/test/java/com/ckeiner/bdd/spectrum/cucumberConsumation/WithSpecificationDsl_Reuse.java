package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

import com.greghaskins.spectrum.Spectrum;

/**
 * Consuming cucumbers with SpecificationDSL and the content of the it-methods
 * factored out.
 * 
 * @author ckeiner
 *
 */
@RunWith(Spectrum.class)
public class WithSpecificationDsl_Reuse
{
    {
        describe("Cucumber Consumation", () ->
            {
                it("Eating less cucumbers than I have ", () ->
                    {

                        eatCukes(12, 5, 7);
                    });

                describe("Eating less cucumbers than I have with Examples", () ->
                    {
                        it("12, 5, 7", () ->
                            {
                                eatCukes(12, 5, 7);
                            });

                        it("20, 5, 15", () ->
                            {
                                eatCukes(20, 5, 15);
                            });
                    });
            });
    }

    public static void eatCukes(int have, int eat, int left)
    {
        int cukes = have;
        cukes = cukes - eat;
        assertThat(cukes, equalTo(left));
    }
}
