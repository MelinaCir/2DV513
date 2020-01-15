import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class JsonFileReader reads information from the given file and creates the objects for the database.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
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

    public List<Composer> createComposers()
    {
        final List<Composer> composers = new ArrayList<>();
        int iD = 3000;

        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(
                    "Gamesdata.json").getFile()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final Object parse = new JSONParser().parse(line);
                final JSONObject jsonObject = (JSONObject) parse;
                final String id = "Co" + iD;
                final String composerName = String.valueOf(jsonObject.get("composer"));
                final String description = "This composer is...";


                final Composer composer = new Composer(id, composerName, description);
                composers.add(composer);
                iD++;
            }
        }
        catch (final IOException | ParseException e)
        {
            e.printStackTrace();
        }

        return composers;
    }

    public List<Genre> createGenres()
    {
        final List<Genre> genres = new ArrayList<>();
        int iD = 4000;

        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(
                    "Genredata.json").getFile()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final Object parse = new JSONParser().parse(line);
                final JSONObject jsonObject = (JSONObject) parse;
                final String id = "Pl" + iD;
                final String genreName = String.valueOf(jsonObject.get("name"));
                final String info = String.valueOf(jsonObject.get("info"));


                final Genre genre = new Genre(id, genreName, info);
                genres.add(genre);
                iD++;
            }
        }
        catch (final IOException | ParseException e)
        {
            e.printStackTrace();
        }

        return genres;
    }

    public List<Soundtrack> createSoundtracks()
    {
        final List<Soundtrack> soundtracks = new ArrayList<>();
        int iD = 5000;

        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(
                    "Gamedata.json").getFile()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final Object parse = new JSONParser().parse(line);
                final JSONObject jsonObject = (JSONObject) parse;
                final String id = "Pl" + iD;
                final String link = String.valueOf(jsonObject.get("link"));
                final String gameId = String.valueOf(jsonObject.get("name"));
                final String composerId = String.valueOf(jsonObject.get("composer"));


                final Soundtrack soundtrack = new Soundtrack(id, link, gameId, composerId);
                soundtracks.add(soundtrack);
                iD++;
            }
        }
        catch (final IOException | ParseException e)
        {
            e.printStackTrace();
        }

        return soundtracks;
    }

}
