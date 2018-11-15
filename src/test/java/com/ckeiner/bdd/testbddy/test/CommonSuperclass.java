package com.ckeiner.bdd.testbddy.test;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.scenario;
import static com.ckeiner.testbddy.api.BddSuite.withData;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import com.ckeiner.testbddy.api.AbstractExtentReportTest;

public class CommonSuperclass extends AbstractExtentReportTest
{
    @Test
    public void canConsumeCucumbersWithTestData()
    {
        //@formatter:off
        feature("Cucumber consumption",
                () -> scenario("Eating less cucumbers than I have",
                        withData(new ArrayList<>(), new HashSet<>())
                        .given("I have <data.cucumbers> cucumbers", (data) -> {
                            
                        })
                        .when("I eat <data.eaten> cucumbers", (data) -> {
                            
                        })
                        .then("I have <data.left> cucumbers left", (data) -> {
                            
                        })
                    )
            ).test();
        //@formatter:on
    }

}
