package posters.pom.pages.browsing;

import static com.codeborne.selenide.Selenide.$;

import posters.pom.components.ErrorMessage;
import posters.pom.components.Footer;
import posters.pom.components.Header;
import posters.pom.components.MiniCart;
import posters.pom.components.Search;
import posters.pom.components.SuccessMessage;
import posters.pom.components.TopNavigation;
import posters.pom.components.UserMenu;
import posters.pom.pages.AbstractPageObject;

public abstract class AbstractBrowsingPage extends AbstractPageObject
{

    public Header header = new Header();

    public Footer footer = new Footer();

    public MiniCart miniCart = new MiniCart();

    public Search search = new Search();

    public TopNavigation topNavigation = new TopNavigation();

    public UserMenu userMenu = new UserMenu();

    public SuccessMessage successMessage = new SuccessMessage();

    public ErrorMessage errorMessage = new ErrorMessage();

    @Override
    public void validateStructure()
    {
        isExpectedPage();

        header.isComponentAvailable();
        footer.isComponentAvailable();
        miniCart.isComponentAvailable();
        search.isComponentAvailable();
        topNavigation.isComponentAvailable();
        userMenu.isComponentAvailable();
        successMessage.isComponentAvailable();
        errorMessage.isComponentAvailable();
    }

    public LoginPage clickLogin()
    {
        $("#userMenu .goToLogin").click();
        return new LoginPage();
    }

    public RegisterPage clickRegister()
    {
        userMenu.openRegister();
        return new RegisterPage();
    }

}
