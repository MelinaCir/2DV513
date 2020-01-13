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
        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(
                    "GamesInfo.json").getFile()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final Object parse = new JSONParser().parse(line);
                final JSONObject jsonObject = (JSONObject) parse;
                final String id = String.valueOf(jsonObject.get("game_id"));
                final String name = String.valueOf(jsonObject.get("name"));
                final String genreId = String.valueOf(jsonObject.get("genreid"));
                final String releaseYear = String.valueOf(jsonObject.get("releaseYear"));
                final String description = String.valueOf(jsonObject.get("description"));

                final Game game = new Game(id, name, genreId, releaseYear,
                        description);
                games.add(game);
            }
        }
        catch (final IOException | ParseException e)
        {
            e.printStackTrace();
        }

        return games;
    }
}
