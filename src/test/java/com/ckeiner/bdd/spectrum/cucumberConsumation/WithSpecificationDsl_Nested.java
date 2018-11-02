package com.ckeiner.bdd.spectrum.cucumberConsumation;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

import com.greghaskins.spectrum.Spectrum;

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
                it("Eating less cucumbers than I have ", () ->
                    {
                        System.out.println("Executing outer it");
                        int cukes = 12;
                        cukes = cukes - 5;
                        assertThat(cukes, equalTo(7));
                    });

                describe("Eating less cucumbers than I have with Examples", () ->
                    {
                        System.out.println("Executing inner describe");
                        int cukes = 12;
                        cukes = cukes - 5;
                        assertThat(cukes, equalTo(7));

                        it("Eating less cucumbers than I have ", () ->
                            {
                                System.out.println("Executing inner it");
                                int newCukes = 12;
                                newCukes = newCukes - 5;
                                assertThat(newCukes, equalTo(7));
                            });
                    });
            });
    }
}
