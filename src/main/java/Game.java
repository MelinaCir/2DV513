
/**
 * Class Game creates a instance of a game object.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class Game {
    private final String id;
    private final String name;
    private final String genreId;
    private final String releaseYear;
    private final String description;


    public Game(String id, String name, String genreId, String releaseYear, String description)
    {
        this.id = id;
        this.name = name;
        this.genreId = genreId;
        this.releaseYear = releaseYear;
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

    public String getGenreId()
    {
        return genreId;
    }

    public String getReleaseYear()
    {
        return releaseYear;
    }

    public String getDescription()
    {
        return description;
    }


    @Override
    public String toString()
    {
        return "Game{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genreId='" + genreId + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
