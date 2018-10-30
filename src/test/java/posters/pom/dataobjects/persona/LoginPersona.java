package posters.pom.dataobjects.persona;

import java.util.ArrayList;
import java.util.List;

import posters.pom.dataobjects.Address;
import posters.pom.dataobjects.LoginData;

public class LoginPersona extends Persona
{
    public static List<LoginPersona> personas = new ArrayList<>();

    public LoginData loginData;

    private Address address;

    private boolean toDelete;

    public LoginPersona(String firstName, String lastName, String email, String password, String company,
            String addressLine, String city, String state, String zip, String country)
    {
        super(firstName, lastName);
        this.address = new Address(getFullName(), company, addressLine, city, state, zip, country);
        this.loginData = new LoginData(email, password);
    }

    public LoginPersona(String firstName, String lastName, LoginData loginData, Address address)
    {
        super(firstName, lastName);
        this.loginData = loginData;
        this.address = address;
    }

    public LoginData getLoginData()
    {
        return loginData;
    }

    public Address getAddress()
    {
        return address;
    }

    public boolean isToDelete()
    {
        return toDelete;
    }

    public void setToDelete(boolean toDelete)
    {
        this.toDelete = toDelete;
    }

    public static LoginPersona named(String name)
    {
        for (LoginPersona persona : personas)
        {
            if (persona.getFirstName().equals(name))
                return persona;
        }
        throw new IllegalArgumentException("No user found with the name " + name);
    }

}
