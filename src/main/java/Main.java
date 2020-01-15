/**
 * This is the starting point of the application.
 *
 * @author Melina Cirverius, Liejsa Ericsson
 */
public class Main {

    public static void main(String[] args)
    {
        Repository repository = new Repository();

//        try
//        {
//            repository.fillDatabase();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

        final UserMenu menu = new UserMenu(repository);
        menu.createMenu();
    }
}
