package com.ckeiner.bdd.cucumber.support;

import com.xceptance.neodymium.util.Neodymium;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;

public class DriverHook
{
    // have a lower order number than default in order to shut down the driver after
    // the test case specific after hooks
    @After(order = 100, value = "@Web")
    public void tearDown()
    {
        Neodymium.getDriver().close();
    }
    
    @BeforeStep("SomeTag")
    public void taggedStep() {
    	System.out.println("Tagged Step Hook");
    }
    
    @BeforeStep
    public void beforeStep() {
    	System.out.println("Step Hook");
    }

}
