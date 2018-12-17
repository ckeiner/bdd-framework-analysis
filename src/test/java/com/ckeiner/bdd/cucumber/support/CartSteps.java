package com.ckeiner.bdd.cucumber.support;

import java.util.Random;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import posters.pom.dataobjects.Product;
import posters.pom.pages.browsing.CartPage;
import posters.pom.pages.browsing.CategoryPage;
import posters.pom.pages.browsing.HomePage;
import posters.pom.pages.browsing.ProductdetailPage;

public class CartSteps
{
    public Random random = new Random();

    public Product product;

    public String[] searchTerms = { "Grizzly Bear", "Tomato", "Indian Summer" };

    @When("I search for a random product")
    public void searchRandomProduct()
    {
        // Search for a random searchTerm in the list of search term and search for it
        int searchIndex = random.nextInt(searchTerms.length);
        CategoryPage categoryPage = new HomePage().search.categoryPageResult(searchTerms[searchIndex]);
        // Validate the category page
        categoryPage.validateStructure();
        // Get a random product name
        String productName = categoryPage.getRandomProductDetailName(random);
        // Click on the random product
        ProductdetailPage productdetailPage = categoryPage.clickProductByName(productName);
        productdetailPage.validate(productName);
    }

    @When("I place the product in the cart")
    public void addToCart()
    {
        ProductdetailPage productdetailPage = new ProductdetailPage();
        productdetailPage.validateStructure();
        product = productdetailPage.getProduct();
        String size = productdetailPage.getChosenSize();
        String style = productdetailPage.getChosenStyle();
        productdetailPage.addToCart(size, style);
        productdetailPage.miniCart.validateMiniCart(1, product);
        productdetailPage.miniCart.openMiniCart();
        CartPage cartPage = productdetailPage.miniCart.openCartPage();
        cartPage.validateStructure();
        cartPage.validateCartItem(1, product);
    }

    @Then("the product should be in the cart")
    public void shouldBeInCart()
    {
        CartPage cartPage = new CartPage();
        cartPage.validateStructure();
        cartPage.validateCartItem(1, product);
    }

}
