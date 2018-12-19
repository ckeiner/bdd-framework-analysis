package com.ckeiner.bdd.serenity.feature;

import static com.ckeiner.bdd.serenity.screenplay.abilities.EatCukes.eatCucumbers;
import static com.ckeiner.bdd.serenity.screenplay.consequence.RemainingCucumbers.remainingCucumbersAre;
import static com.ckeiner.bdd.serenity.screenplay.performables.Eat.eat;
import static com.ckeiner.bdd.serenity.screenplay.performables.Get.get;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;

/**
 * As a business owner <br>
 * I want to know how much cucumbers my consumers eat <br>
 * So I can offer individual plans later on <br>
 * 
 * @author ckeiner
 */
@RunWith(SerenityRunner.class)
public class WhenEatingCucumbers
{

    //@formatter:off
    Actor kim = Actor.named("Kim")
            .whoCan(eatCucumbers());
    //@formatter:on

    /**
     * Given I have 12 cucumbers<br>
     * When I eat 5 cucumbers<br>
     * Then I have 7 cucumbers left <br>
     */
    @Test
    public void eating_cucumbers()
    {
        givenThat(kim).wasAbleTo(get(12).cucumbers());
        when(kim).attemptsTo(eat(5).cucumbers());
        then(kim).should(seeThat(remainingCucumbersAre(), equalTo(7)));
    }

    @Test
    public void eating_dynamic_cucumbers()
    {
        Random random = new Random();
        int eat = random.nextInt();
        int have = random.nextInt(eat);
        givenThat(kim).wasAbleTo(get(eat).cucumbers());
        when(kim).attemptsTo(eat(have).cucumbers());
        then(kim).should(seeThat(remainingCucumbersAre(), equalTo(eat - have)));
    }

}
