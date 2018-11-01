package com.ckeiner.bdd.serenity.feature;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.ckeiner.bdd.serenity.stepdefinition.BrowsingStep;
import com.xceptance.neodymium.util.Neodymium;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;

/**
 * Shows how using the Enclosed-Runner can separate features into scenarios with
 * different test data.
 * 
 * @author ckeiner
 *
 */
@RunWith(Enclosed.class)
public class WhenBrowsingWithParameters
{
    public static abstract class SharedSetup
    {
        @Steps
        public static BrowsingStep browsingStep;

        @Before
        public void setUpBrowser()
        {
            browsingStep.open_Browser("Chrome");
            browsingStep.open_the_homepage();
        }

        @After
        public void destroyBrowser()
        {
            Neodymium.getDriver().close();
        }
    }

    @RunWith(SerenityRunner.class)
    public static class WhenIBrowseNormally extends SharedSetup
    {
        @Test
        public void browseToTopLevelCategory()
        {
            browsingStep.open_Category("World of Nature");
            browsingStep.should_See_Products_In_Catalog();
        }

        @Test
        public void browseToSubCategory()
        {
            browsingStep.open_Subcategory("Flowers", "World of Nature");
            browsingStep.should_See_Products_Of_Subcategory("Flowers");
        }
    }

    @RunWith(SerenityParameterizedRunner.class)
    public static class WhenIBrowseWithParameters extends SharedSetup
    {
        @TestData
        public static Collection<String[]> testData()
        {
            return Arrays.asList(new String[][] { { "World of Nature", "Trees" }, { "Transportation", "Air Travel" } });
        }

        private final String categoryName;

        private final String subCategoryName;

        public WhenIBrowseWithParameters(String categoryName, String subCategoryName)
        {
            this.categoryName = categoryName;
            this.subCategoryName = subCategoryName;
        }

        @Test
        public void browseToTopLevelCategory()
        {
            browsingStep.open_Category(categoryName);
            browsingStep.should_See_Products_In_Catalog();
        }

        @Test
        public void browseToSubCategory()
        {
            browsingStep.open_Subcategory(subCategoryName, categoryName);
            browsingStep.should_See_Products_Of_Subcategory(subCategoryName);
        }
    }

}
