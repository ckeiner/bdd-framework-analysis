package com.ckeiner.bdd.testbddy.testdata;

import com.ckeiner.CucumberEater;

public class CucumberData
{
    public int cucumbers;

    public int eaten;

    public int left;

    CucumberEater eater;

    public CucumberData(int cucumbers, int eaten, int left)
    {
        this.cucumbers = cucumbers;
        this.eaten = eaten;
        this.left = left;
        this.eater = new CucumberEater();
    }

    @Override
    public String toString()
    {
        return "Have: " + cucumbers + ", Eat: " + eaten + ", Left: " + left;
    }

    public void eat(int numberEaten)
    {
        eater.eat(numberEaten);
    }

    public int cucumbers()
    {
        return eater.cucumbers();
    }

    public void setCucumbers(int cucumbers)
    {
        this.cucumbers = cucumbers;
    }
}
