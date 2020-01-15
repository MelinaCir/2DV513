
/**
 * Class Genre creates a instance of a genre object.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class Genre {

    private final String id;
    private final String name;
    private final String info;


    public Genre(String id, String name, String info)
    {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getInfo()
    {
        return info;
    }


    @Override
    public String toString()
    {
        return "Genre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
