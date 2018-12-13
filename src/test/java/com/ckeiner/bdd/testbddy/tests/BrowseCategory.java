package com.ckeiner.bdd.testbddy.tests;

import static com.ckeiner.testbddy.api.BddSuite.feature;
import static com.ckeiner.testbddy.api.BddSuite.given;
import static com.ckeiner.testbddy.api.BddSuite.scenario;
import static com.ckeiner.testbddy.api.BddSuite.then;
import static com.ckeiner.testbddy.api.BddSuite.withData;

import org.junit.Test;

import com.ckeiner.testbddy.core.bdd.steps.Steps;
import com.xceptance.neodymium.util.Neodymium;
import com.xceptance.neodymium.util.WebDriverUtils;

import posters.pom.pages.browsing.CategoryPage;
import posters.pom.pages.browsing.HomePage;
import posters.pom.util.Util;

public class BrowseCategory
{
    public HomePage homepage;

    public CategoryPage categoryPage;

    @Test
    public void canBrowseCategories()
    {
        //@formatter:off
        feature("Can browse categories",
                () -> scenario("I browse a category",
                        withData("World of Nature")
                        .given(setUp())
                        .when("I open <data>", (data) -> {
                            homepage = new HomePage();
                            categoryPage = homepage.topNavigation.clickCategory(data);
                        })
                        .then("The site has the header <data>", data -> {
                            categoryPage.validate(data);
                        })
                        .then(tearDown())
                    ),
                () -> scenario("I browse a subcategory",
                        withData(new ClickedCategory("World of Nature", "Flowers"))
                        .given(setUp())
                        .when("I open <data.subCategoryName> of <data.categoryName>", (data) -> {
                            homepage = new HomePage();
                            categoryPage = homepage.topNavigation.clickSubCategoryByName(data.categoryName, data.subCategoryName);
                        })
                        .then("The site has the header <data.subCategoryName>", data -> {
                            categoryPage.validate(data.subCategoryName);
                        })
                        .then(tearDown())
                    )
        ).test();
        //@formatter:on
    }

    private Steps setUp()
    {
        return given("I open the browser", () ->
            {
                WebDriverUtils.setUp("Chrome");
                Util.openHomePage();
            });
    }

    private Steps tearDown()
    {
        return then("I close the browser", () ->
            {
                Neodymium.getDriver().close();
            });
    }

    public static class ClickedCategory
    {
        public String categoryName;

        public String subCategoryName;

        public ClickedCategory(String categoryName, String subCategoryName)
        {
            this.categoryName = categoryName;
            this.subCategoryName = subCategoryName;
        }

        @Override
        public String toString()
        {
            return "Category: \"" + categoryName + "\" with subcategory: \"" + subCategoryName + "\"";
        }
    }

}
