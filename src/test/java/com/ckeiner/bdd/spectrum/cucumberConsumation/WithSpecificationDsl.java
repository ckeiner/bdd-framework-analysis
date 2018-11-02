package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

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
                        int cukes = 12;
                        cukes = cukes - 5;
                        assertThat(cukes, equalTo(7));
                    });

                describe("Eating less cucumbers than I have with Examples", () ->
                    {
                        it("12, 5, 7", () ->
                            {
                                int cukes = 12;
                                cukes = cukes - 5;
                                assertThat(cukes, equalTo(7));
                            });

                        it("20, 5, 15", () ->
                            {
                                int cukes = 20;
                                cukes = cukes - 5;
                                assertThat(cukes, equalTo(15));
                            });

                    });
            });
    }
}
