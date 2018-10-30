package com.ckeiner.bdd.serenity.stepdefinition;

import com.xceptance.neodymium.util.WebDriverUtils;

import net.thucydides.core.annotations.Step;
import posters.pom.dataobjects.persona.LoginPersona;
import posters.pom.pages.browsing.HomePage;
import posters.pom.pages.browsing.LoginPage;
import posters.pom.pages.browsing.RegisterPage;
import posters.pom.util.Util;

public class HomepageStep
{

    @Step("{0} is opened")
    public void open_Browser(String browsername)
    {
        WebDriverUtils.setUp(browsername);
    }

    @Step("When I open the homepage")
    public void open_the_homepage()
    {
        HomePage homePage = Util.openHomePage();
        homePage.isExpectedPage();
    }

    @Step("Then I want to see the header")
    public void see_the_header()
    {
        HomePage homePage = new HomePage();
        homePage.hasHeader();
    }

    @Step("I register as {0}")
    public void registerAs(String firstName)
    {
        LoginPersona persona = LoginPersona.named(firstName);
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.clickRegister();
        LoginPage loginPage = registerPage.registerAs(persona);
        loginPage.isExpectedPage();
    }

    @Step("I want to be able to login as {0}")
    public void loginAs(String firstName)
    {
        LoginPersona persona = LoginPersona.named(firstName);
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginAs(persona);
        homePage.validateSuccessfulLogin(persona);
    }

}
