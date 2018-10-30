package com.ckeiner.bdd.serenity.screenplay.consequence;

import com.ckeiner.bdd.serenity.screenplay.abilities.EatCukes;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class RemainingCucumbers implements Question<Integer>
{

    public static RemainingCucumbers remainingCucumbersAre()
    {
        return Instrumented.instanceOf(RemainingCucumbers.class).withProperties();
    }

    // @Step("Actor has Cucumbers left")
    @Step("{0} has Cucumbers left")
    @Override
    public Integer answeredBy(Actor actor)
    {
        return actor.usingAbilityTo(EatCukes.class).hasLeft();
    }

}
