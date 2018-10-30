package posters.pom.dataobjects.persona;

import java.util.ArrayList;
import java.util.List;

public class Persona
{
    public static List<Persona> personas = new ArrayList<>();

    private String firstName;

    private String lastName;

    private String fullName;

    public Persona(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public static Persona named(String name)
    {
        for (Persona persona : personas)
        {
            if (persona.getFirstName().equals(name))
                return persona;
        }
        throw new IllegalArgumentException("No user found with the name " + name);
    }
}
