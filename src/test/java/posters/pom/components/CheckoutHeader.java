/**
 * 
 */
package posters.pom.components;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author pfotenhauer
 */
public class CheckoutHeader extends AbstractComponent
{
    public void isComponentAvailable()
    {
        $("#headerCheckout").should(exist);
    }
}
