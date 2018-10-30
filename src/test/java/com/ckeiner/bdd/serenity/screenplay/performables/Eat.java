package com.ckeiner.bdd.serenity.screenplay.performables;

import com.ckeiner.bdd.serenity.screenplay.abilities.EatCukes;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Eat implements Task
{
    int eatsCukes;

    public Eat(int eatsCukes)
    {
        this.eatsCukes = eatsCukes;
    }

    @Step("{0} eats #eatsCukes cucumbers")
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.usingAbilityTo(EatCukes.class).eats(eatsCukes);
    }

    public static Eat eat(int number)
    {
        return Instrumented.instanceOf(Eat.class).withProperties(number);
    }

    public Eat cucumbers()
    {
        return this;
    }

}
