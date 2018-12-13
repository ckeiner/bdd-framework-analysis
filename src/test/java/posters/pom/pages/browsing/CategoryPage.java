package posters.pom.pages.browsing;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.Random;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

/**
 * @author pfotenhauer
 */
public class CategoryPage extends AbstractBrowsingPage
{
    @Override
    @Step("ensure this is a category page")
    public void isExpectedPage()
    {
        $("#productOverview").should(exist);
    }

    public void validateCategoryName(String categoryName)
    {
        // Category name
        // Ensures the category headline contains the category name
        $("#titleCategoryName").shouldBe(text(categoryName));
    }

    @Override
    public void validateStructure()
    {
        super.validateStructure();

        // Amount of results
        // Assures the amount of posters displayed in the headline is not 0.
        $("#totalProductCount").shouldNotBe(exactText("0"));
        // Results
        // Assures there's at least one product shown
        $("#product0").shouldBe(visible);
    }

    /**
     * @param productName
     */
    public void validateProductVisible(String productName)
    {
        $("#productOverview .thumbnails .thumbnail a > img.pImage[title='" + productName + "']").shouldBe(visible);
    }

    /**
     * @param categoryName
     */
    public void validate(String categoryName)
    {
        validateStructure();
        validateCategoryName(categoryName);
    }

    @Step("click on a product by name \"{productName}\"")
    public ProductdetailPage clickProductByName(String productName)
    {
        // Open the product detail page
        // Click on the product's image and open the product overview page
        // Click the product link to open the product detail page
        $("#productOverview .thumbnails .thumbnail a > img.pImage[title='" + productName + "']").scrollTo().click();
        return new ProductdetailPage();
    }

    /**
     * @param row
     * @param column
     * @return
     */
    @Step("get a product name by position in grid")
    public String getProductNameByPosition(int row, int column)
    {
        SelenideElement rowContainer = $("#productOverview").findAll(".thumbnails.row").get(row - 1);
        return rowContainer.find("h4.pName", column - 1).text();
    }

    /**
     * @param row
     * @param column
     * @return
     */
    @Step("click on a product by position in grid")
    public ProductdetailPage clickProductByPosition(int row, int column)
    {
        // Open the product detail page
        // Clicks a product by position. Because of the html code, this requires x and y
        // coordinates.
        SelenideElement rowContainer = $$("#productOverview > .row").get(row - 1);
        rowContainer.find(".thumbnail", column - 1).scrollTo().click();
        return new ProductdetailPage();
    }

    public String getRandomProductDetailName(Random random)
    {
        ElementsCollection rows = $("#productOverview").findAll(".thumbnails.row");
        int numberOfRows = rows.size();
        int productIndexX = random.nextInt(numberOfRows);

        SelenideElement row = rows.get(productIndexX);
        int numberOfColumns = row.findAll(".thumbnail").filter(visible).size();
        int productIndexY = random.nextInt(numberOfColumns);

        return getProductNameByPosition(productIndexX + 1, productIndexY + 1);
    }
}
