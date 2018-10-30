/**
 * 
 */
package posters.pom.components;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import posters.pom.pages.browsing.CategoryPage;

/**
 * @author pfotenhauer
 */
public class TopNavigation extends AbstractComponent
{
    @Override
    public void isComponentAvailable()
    {
        $("#categoryMenu").should(exist);
    }

    public CategoryPage clickCategory(String categoryName)
    {
        $(By.linkText(categoryName)).scrollTo().click();
        return new CategoryPage();
    }

    public CategoryPage clickSubCategoryByName(String categoryName, String subCategoryName)
    {
        // Open the category page
        $(By.linkText(categoryName)).hover();
        // Clicks the subcategory with position @{subCategoryPosition}
        // belonging to the category with position @{categoryPosition}
        $(By.linkText(subCategoryName)).click();
        return new CategoryPage();
    }
}
