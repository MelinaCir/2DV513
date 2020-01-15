
/**
 * Class Soundtrack creates a instance of a soundtrack object.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class Soundtrack {

    private final String id;
    private final String link;
    private final String gameId;
    private final String composerId;


    public Soundtrack(String id, String link, String gameId, String composerId)
    {
        this.id = id;
        this.link = link;
        this.gameId = gameId;
        this.composerId = composerId;
    }

    public String getId()
    {
        return id;
    }

    public String getLink()
    {
        return link;
    }

    public String getGameId()
    {
        return gameId;
    }

    public String getComposerId()
    {
        return composerId;
    }

    @Override
    public String toString()
    {
        return "Soundtrack{" +
                "id='" + id + '\'' +
                ", link='" + link + '\'' +
                ", gameID=" + gameId + '\'' +
                ", composerId=" + composerId + '\'' +
                '}';
    }
}
