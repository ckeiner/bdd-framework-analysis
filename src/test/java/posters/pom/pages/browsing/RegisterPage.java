package posters.pom.pages.browsing;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import posters.pom.dataobjects.persona.LoginPersona;

/**
 * @author pfotenhauer
 */
public class RegisterPage extends AbstractBrowsingPage
{

    private SelenideElement registerForm = $("#formRegister");

    private SelenideElement firstnameField = $("#firstName");

    private SelenideElement lastnameField = $("#lastName");

    private SelenideElement emailField = $("#eMail");

    private SelenideElement passwordField = $("#password");

    private SelenideElement passwordRepeatField = $("#passwordAgain");

    private SelenideElement registerButton = $("#btnRegister");

    @Override
    @Step("ensure this is a register page")
    public void isExpectedPage()
    {
        registerForm.should(exist);
    }

    @Step("fill and send register form")
    public LoginPage sendRegisterForm(LoginPersona persona, String passwordRepeat)
    {
        // Fill out the registration form
        // Type the last name parameter into the last name field.
        lastnameField.val(persona.getLastName());
        // Type the first name parameter into the first name field.
        firstnameField.val(persona.getFirstName());
        // Type the email parameter into the email field.
        emailField.val(persona.getLoginData().getEmail());
        // Type the password parameter into the password field.
        passwordField.val(persona.getLoginData().getPassword());
        // Type the second password parameter into the second password field.
        passwordRepeatField.val(passwordRepeat);
        // Register and open the login page if successful
        // Click on the Register Button
        registerButton.scrollTo().click();

        return new LoginPage();
    }

    /**
     * @param user
     * @param passwordRepeat
     * @return
     */
    public LoginPage registerAs(LoginPersona persona)
    {
        LoginPage loginPage = sendRegisterForm(persona, persona.getLoginData().getPassword());
        persona.setToDelete(true);
        return loginPage;
    }
}