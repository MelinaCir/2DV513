import java.sql.SQLException;

/**
 * This is the starting point of the application.
 *
 * @author Melina Cirverius, Liejsa Ericsson
 *
 */
public class Main {

    public static void main(String[] args)
    {
        try
        {
            new Repository().fillDatabase();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
