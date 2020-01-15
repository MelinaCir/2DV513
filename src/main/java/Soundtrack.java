
/**
 * Class Soundtrack creates a instance of a soundtrack object.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class Soundtrack {

    private final String id;
    private final String name;
    private final String link;
    private final String gameId;


    public Soundtrack(String id, String name, String link, String gameId)
    {
        this.id = id;
        this.name = name;
        this.link = link;
        this.gameId = gameId;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLink()
    {
        return link;
    }

    public String getGameId()
    {
        return gameId;
    }

    @Override
    public String toString()
    {
        return "Soundtrack{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", gameID=" + gameId + '\'' +
                '}';
    }
}
