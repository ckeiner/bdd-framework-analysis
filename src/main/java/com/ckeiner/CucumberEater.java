package com.ckeiner;

public class CucumberEater
{
    private Integer cucumbers;

    public CucumberEater()
    {
    }

    public CucumberEater(int cucumbers)
    {
        this.cucumbers = cucumbers;
    }

    public void eat(int numberEaten)
    {
        this.cucumbers = this.cucumbers - numberEaten;
    }

    public int cucumbers()
    {
        return cucumbers;
    }

    public void setCucumbers(int cucumbers)
    {
        this.cucumbers = cucumbers;
    }
}
