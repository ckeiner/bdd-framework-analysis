package com.ckeiner.functional;

import org.junit.Assert;
import org.junit.Test;

public class FinalFun
{
    public String foo;

    @Test
    public void shouldOverwriteField()
    {
        Runnable fooSetter = () -> foo = "bar";
        Runnable fooConfirmer = () -> Assert.assertEquals("bar", foo);
        fooSetter.run();
        fooConfirmer.run();
    }
}