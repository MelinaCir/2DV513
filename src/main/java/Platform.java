/**
 * Class Platform creates a instance of a platform object.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 *
 */
public class Platform {

    private final String id;
    private final String platform;
    private final String gameId;


    public Platform(String id, String platform, String gameId)
    {
        this.id = id;
        this.platform = platform;
        this.gameId = gameId;

    }

    public String getId()
    {
        return id;
    }

    public String getPlatform()
    {
        return platform;
    }

    public String getGameId()
    {
        return gameId;
    }


    @Override
    public String toString()
    {
        return "Platform{" +
                "id='" + id + '\'' +
                ", platform='" + platform + '\'' +
                ", gameId='" + gameId + '\'' +
                '}';
    }
}
