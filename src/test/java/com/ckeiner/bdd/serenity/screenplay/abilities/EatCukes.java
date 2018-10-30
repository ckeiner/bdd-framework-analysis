package com.ckeiner.bdd.serenity.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;

public class EatCukes implements Ability
{
    int amountCukes;

    public EatCukes()
    {
        amountCukes = 0;
    }

    public static EatCukes eatCucumbers()
    {
        return new EatCukes();
    }

    public EatCukes cukes()
    {
        return this;
    }

    public void has(int number)
    {
        amountCukes = number;
    }

    public void eats(int number)
    {
        if (number > amountCukes)
        {
            throw new IllegalArgumentException("Cannot eat more cukes than you have");
        }
        amountCukes = amountCukes - number;
    }

    public int hasLeft()
    {
        return amountCukes;
    }
}
