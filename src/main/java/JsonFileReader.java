import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {

    public List<Game> createGames()
    {
        final List<Game> games = new ArrayList<>();
        int gameID = 1000;

        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(
                    "Gamesdata.json").getFile()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final Object parse = new JSONParser().parse(line);
                final JSONObject jsonObject = (JSONObject) parse;
                final String id = "GD" + gameID;
                final String name = String.valueOf(jsonObject.get("name"));
                final String genre = String.valueOf(jsonObject.get("genre"));
                final String releaseYear = String.valueOf(jsonObject.get("release"));
                final String description = String.valueOf(jsonObject.get("description"));

                final Game game = new Game(id, name, genre, releaseYear,
                        description);
                games.add(game);
                gameID++;
            }
        }
        catch (final IOException | ParseException e)
        {
            e.printStackTrace();
        }

        return games;
    }

    public List<Platform> createPlatforms()
    {
        final List<Platform> platforms = new ArrayList<>();
        int iD = 2000;

        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(
                    "Gamesdata.json").getFile()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final Object parse = new JSONParser().parse(line);
                final JSONObject jsonObject = (JSONObject) parse;
                final String id = "Pl" + iD;
                final String platformName = String.valueOf(jsonObject.get("platform"));
                final String gameID = String.valueOf(jsonObject.get("name"));


                final Platform platform = new Platform(id, platformName, gameID);
                platforms.add(platform);
                iD++;
            }
        }
        catch (final IOException | ParseException e)
        {
            e.printStackTrace();
        }

        return platforms;
    }
}
