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

        final String query = "Insert into Games (ID, Name, GenreID, ReleaseYear, Description)"
                + "values (?,?,?,?,?)";

        System.out.println(query);

        final PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "10010");
        preparedStatement.setString(2, "Unravel");
        preparedStatement.setString(3, "20010");
        preparedStatement.setString(4, "2016");
        preparedStatement.setString(5, "Unravel is a puzzle platform video game developed by the Swedish company Coldwood Interactive and published by Electronic Arts.");

        preparedStatement.execute();

        connection.close();

}
}