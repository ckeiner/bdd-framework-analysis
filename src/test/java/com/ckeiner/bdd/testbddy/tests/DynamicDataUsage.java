package com.ckeiner.bdd.testbddy.tests;

import static com.xceptance.testbddy.api.BddSuite.feature;
import static com.xceptance.testbddy.api.BddSuite.given;
import static com.xceptance.testbddy.api.BddSuite.scenario;
import static com.xceptance.testbddy.api.BddSuite.with;

import org.junit.Assert;
import org.junit.Test;

import com.greghaskins.spectrum.Variable;
import com.xceptance.testbddy.core.throwables.errors.FeatureError;

public class DynamicDataUsage
{
    @Test
    public void canUseContainerToCircumentFinal()
    {
        //@formatter:off
        feature("Circumvent the final requirement for variables",
                () -> {
                    Variable<Integer> someInt = new Variable<>();
                    return scenario("Define with container",
                            given("I set the variable", () -> {
                                someInt.set(12);
                            })
                            .then("The value is set", () -> {
                                Assert.assertEquals(12, someInt.get().intValue());
                            })
                            .when("I change the variable", () -> {
                                someInt.set(24);
                            })
                            .then("I should have another value", () -> {
                                Assert.assertEquals(24, someInt.get().intValue());
                            })
                    );
                },
                () -> {
                    return scenario("Use test data to save dynamic parts",
                            with(new TestData<String>(), new TestData<String>())
                            .given("I set the variable", (data) -> {
                                Assert.assertNull("Dynamic Part should be null", data.dynamicPart);
                                data.dynamicPart = "Some String";
                            })
                            .then("The value is set", (data) -> {
                                Assert.assertEquals("Some String", data.dynamicPart);
                            })
                            .when("I change the variable", (data) -> {
                                data.dynamicPart = "Some other String";
                            })
                            .then("I should have another value", (data) -> {
                                Assert.assertEquals("Some other String", data.dynamicPart);
                            })
                    );
                }
            ).test();
        //@formatter:on
    }

    @Test(expected = FeatureError.class)
    public void containerShouldFailWithOutline()
    {
        //@formatter:off
        feature("Container Variable Circumvention fails with a scenarioOutline",
                () ->
                {
                    Variable<Integer> someInt = new Variable<>();
                    return scenario("Outline with container variable",
                            with("first run", "second run")
                            .given("I set the variable", () -> {
                                Assert.assertNull("Variable should be null", someInt.get());
                                someInt.set(12);
                            })
                            .then("The value is set", () -> {
                                Assert.assertEquals(12, someInt.get().intValue());
                            })
                            .when("I change the variable", () -> {
                                someInt.set(24);
                            })
                            .then("I should have another value", () -> {
                                Assert.assertEquals(24, someInt.get().intValue());
                            })
                    );
                }).test();
        //@formatter:on
    }

    private class TestData<R>
    {
        public R dynamicPart;

        public TestData()
        {
        }
    }
}
