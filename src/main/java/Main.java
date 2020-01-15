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

        System.out.println("Welcome to the Game Music Database 1.0");
        System.out.println("--------------------------------------");
        System.out.println("What do you want to do? (Choose a number)");
    }
}
