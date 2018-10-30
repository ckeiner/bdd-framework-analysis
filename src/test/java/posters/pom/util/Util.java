package posters.pom.util;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

import com.xceptance.neodymium.util.Neodymium;

import io.qameta.allure.Step;
import posters.pom.pages.browsing.HomePage;

public class Util
{

    @Step("I open the homepage")
    public static HomePage openHomePage()
    {
        clearBrowserCookies();

        // open home page
        open(Neodymium.configuration().url());
        HomePage homePage = new HomePage();
        homePage.isExpectedPage();
        return homePage;
    }

}
