import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Class Repository creates the connection to the database and fills it with the given information.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class Repository {

    private final JsonFileReader fileReader;
    private Connection connection;

    public Repository()
    {
        this.fileReader = new JsonFileReader();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            //Replace with address to database
            final String URL = "jdbc:mysql://127.0.0.1:3306/GameMusic?useSSL=false";

            //Add username and password for current MySQL client
            connection = DriverManager.getConnection(URL, "root", "Dharkan1429z!");
        }
        catch (final ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void fillDatabase() throws SQLException
    {
        final List<Game> games = fileReader.createGames();
        final List<Platform> platforms = fileReader.createPlatforms();
        final List<Genre> genres = fileReader.createGenres();
        final List<Soundtrack> soundtracks = fileReader.createSoundtracks();
        final List<Composer> composers = fileReader.createComposers();

        for (final Game game : games)
        {
            final String query = "Insert into Games (ID, Name, GenreID, ReleaseYear, Description)"
                    + "values (?,?,?,?,?)";

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, game.getId());
            preparedStatement.setString(2, game.getName());
            preparedStatement.setString(3, game.getGenreId());
            preparedStatement.setString(4, game.getReleaseYear());
            preparedStatement.setString(5, game.getDescription());

            preparedStatement.execute();
        }

        for (final Platform platform : platforms)
        {
            final String query = "Insert into Platforms (ID, Platform, GameID)"
                    + "values (?,?,?)";

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, platform.getId());
            preparedStatement.setString(2, platform.getPlatform());
            preparedStatement.setString(3, platform.getGameId());

            preparedStatement.execute();
        }

        for (final Genre genre : genres)
        {
            final String query = "Insert into Genres (ID, Name, Info)"
                    + "values (?,?,?)";

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, genre.getId());
            preparedStatement.setString(2, genre.getName());
            preparedStatement.setString(3, genre.getInfo());

            preparedStatement.execute();
        }

        for (final Soundtrack soundtrack : soundtracks)
        {
            final String query = "Insert into Soundtracks (ID, Link, GameID, ComposerID)"
                    + "values (?,?,?,?)";

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, soundtrack.getId());
            preparedStatement.setString(2, soundtrack.getLink());
            preparedStatement.setString(3, soundtrack.getGameId());
            preparedStatement.setString(4, soundtrack.getComposerId());


            preparedStatement.execute();
        }

        for (final Composer composer : composers)
        {
            final String query = "Insert into Composers (ID, Name, Description)"
                    + "values (?,?,?)";

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, composer.getId());
            preparedStatement.setString(2, composer.getName());
            preparedStatement.setString(3, composer.getDescription());

            preparedStatement.execute();
        }

        connection.close();

    }
}