package com.ckeiner.bdd.serenity.feature;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ckeiner.bdd.serenity.stepdefinition.BrowsingStep;
import com.xceptance.neodymium.util.Neodymium;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;

/**
 * Browses posters catalogue.<br>
 * This is implemented with a Steps-Library.
 * 
 * @author ckeiner
 *
 */
@RunWith(SerenityParameterizedRunner.class)
public class WhenBrowsingCategories
{
    @Steps
    public static BrowsingStep browsingStep;

    @TestData
    public static Collection<String[]> testData()
    {
        return Arrays.asList(new String[][] { { "World of Nature", "Trees" }, { "Transportation", "Air Travel" } });
    }

    private final String categoryName;

    private final String subCategoryName;

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

    public WhenBrowsingCategories(String categoryName, String subCategoryName)
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
