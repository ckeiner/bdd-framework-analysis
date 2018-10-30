package com.ckeiner.bdd.serenity.screenplay.performables;

import com.ckeiner.bdd.serenity.screenplay.abilities.EatCukes;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Get implements Task
{
    int cucumbers;

    public Get(int cucumbers)
    {
        this.cucumbers = cucumbers;
    }

    // @Step("{0} has Cucumbers")
    @Step("{0} has #cucumbers cucumbers left")
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.usingAbilityTo(EatCukes.class).has(cucumbers);
    }

    public Get cucumbers()
    {
        return this;
    }

    public static Get get(int number)
    {
        return Instrumented.instanceOf(Get.class).withProperties(number);
    }

}
