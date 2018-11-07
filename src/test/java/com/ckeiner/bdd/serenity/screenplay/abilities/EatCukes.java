package com.ckeiner.bdd.serenity.screenplay.abilities;

import com.ckeiner.CucumberEater;

import net.serenitybdd.screenplay.Ability;

public class EatCukes implements Ability
{
    private CucumberEater eater;

    public EatCukes()
    {
        eater = new CucumberEater();
    }

    public static EatCukes eatCucumbers()
    {
        return new EatCukes();
    }

    public EatCukes cukes()
    {
        return this;
    }

    public void has(int cucumbers)
    {
        eater.setCucumbers(cucumbers);
    }

    public void eats(int eaten)
    {
        eater.eat(eaten);
    }

    public int hasLeft()
    {
        return eater.cucumbers();
    }
}
