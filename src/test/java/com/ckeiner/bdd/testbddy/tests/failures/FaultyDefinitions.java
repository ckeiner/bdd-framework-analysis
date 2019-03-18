package com.ckeiner.bdd.testbddy.tests.failures;

import static com.xceptance.testbddy.api.BddSuite.feature;
import static com.xceptance.testbddy.api.BddSuite.given;
import static com.xceptance.testbddy.api.BddSuite.scenario;

import org.junit.Assert;
import org.junit.Test;

import com.xceptance.testbddy.core.bdd.steps.Steps;
import com.xceptance.testbddy.core.throwables.errors.FeatureError;
import com.xceptance.testbddy.core.throwables.exceptions.FeatureException;

public class FaultyDefinitions
{

    @Test(expected = NullPointerException.class)
    public void throwsErrorWhenNull()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have", (Steps) null)
            ).test();
        //@formatter:on
    }

    @Test(expected = FeatureError.class)
    public void convertsErrorWhenStepDefFails()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have", 
                        given("Step that throws an error", () -> {
                            Assert.assertFalse(true);
                        })
                )
            ).test();
        //@formatter:on
    }

    @Test(expected = FeatureException.class)
    public void convertssExceptionWhenStepDefFails()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have", 
                        given("Step that throws an error", () -> {
                            throw new IllegalArgumentException();
                        })
                )
            ).test();
        //@formatter:on
    }

}
