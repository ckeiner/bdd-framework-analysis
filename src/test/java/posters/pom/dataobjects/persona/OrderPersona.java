package posters.pom.dataobjects.persona;

import java.util.ArrayList;
import java.util.List;

import posters.pom.dataobjects.Address;
import posters.pom.dataobjects.CreditCard;
import posters.pom.dataobjects.LoginData;

public class OrderPersona extends LoginPersona
{
    public static List<OrderPersona> personas = new ArrayList<>();

    private CreditCard creditcard;

    public OrderPersona(String firstName, String lastName, String email, String password, String company,
            String addressLine, String city, String state, String zip, String country, String cardNumber,
            String crypticCardNumber, String expDateMonth, String expDateYear)
    {
        super(firstName, lastName, email, password, company, addressLine, city, state, zip, country);
        this.creditcard = new CreditCard(country, cardNumber, crypticCardNumber, expDateMonth, expDateYear);
    }

    public OrderPersona(String firstName, String lastName, LoginData loginData, Address address, CreditCard creditcard)
    {
        super(firstName, lastName, loginData, address);
        this.creditcard = creditcard;
    }

    public CreditCard getCreditcard()
    {
        return creditcard;
    }

    public static OrderPersona named(String name)
    {
        for (OrderPersona persona : personas)
        {
            if (persona.getFirstName().equals(name))
                return persona;
        }
        throw new IllegalArgumentException("No user found with the name " + name);
    }
}
