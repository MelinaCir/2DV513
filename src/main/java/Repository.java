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
            final String URL = "jdbc:mysql://127.0.0.1:3306/GameMusic?useSSL=false";
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

        for (final Game game : games)
        {
            final String query = "Insert into Games (ID, Name, GenreID, ReleaseYear, Description)"
                    + "values (?,?,?,?,?)";

            System.out.println(query);

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
                    + "values (?,?,?,?,?)";

            System.out.println(query);

            final PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, platform.getId());
            preparedStatement.setString(2, platform.getPlatform());
            preparedStatement.setString(3, platform.getGameId());

            preparedStatement.execute();
        }

        connection.close();

    }
}