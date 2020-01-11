import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Class Repository creates the connection to the database and fills it with the given information.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 *
 */
public class Repository {

    private Connection connection;

    public Repository()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            final String URL = "jdbc:mysql://127.0.0.1:3306/GameMusic?useSSL=false";
            connection = DriverManager.getConnection(URL, "root", "Dharkan1429z!");

            System.out.println("hej");
        }
        catch (final ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void fillDatabase() throws SQLException
    {

        final String query = "Insert into Games (ID, Name, Genre, Link, ComposerID, Description)"
                + "values (?,?,?,?,?,?)";

        System.out.println(query);

        final PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "2318");
        preparedStatement.setString(2, "Zelda");
        preparedStatement.setString(3, "Adventure");
        preparedStatement.setString(4, "thislink");
        preparedStatement.setString(5, "334513");
        preparedStatement.setString(6, "This game is the best");

        preparedStatement.execute();

        connection.close();

}
}