package com.ckeiner.bdd.testbddy.tests;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.scenario;
import static com.ckeiner.testbddy.api.BddSuite.with;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class CommonSuperclass
{
    @Test
    public void shouldFindSuperClass()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have",
                        with(new ArrayList<>(), new HashSet<>())
                ),
                () -> scenario("Eating less cucumbers than I have",
                        with(1, "String")
                )
            ).test();
        //@formatter:on
    }

}
