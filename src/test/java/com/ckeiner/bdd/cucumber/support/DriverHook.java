package com.ckeiner.bdd.cucumber.support;

import com.xceptance.neodymium.util.Neodymium;

import cucumber.api.java.After;

public class DriverHook
{
    // have a lower order number than default in order to shut down the driver after
    // the test case specific after hooks
    @After(order = 100, value = "@Web")
    public void tearDown()
    {
        Neodymium.getDriver().close();
    }

}
