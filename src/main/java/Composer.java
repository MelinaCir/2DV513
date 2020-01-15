
/**
 * Class Composer creates a instance of a composer object.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class Composer {

    private final String id;
    private final String name;
    private final String description;


    public Composer(String id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }


    @Override
    public String toString()
    {
        return "Composer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
