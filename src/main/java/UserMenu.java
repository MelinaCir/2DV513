import java.util.Scanner;

/**
 * Class UserMenu creates the menu that the user can interact with.
 *
 * @author Melina Cirverius & Liejsa Ericsson
 */
public class UserMenu {

    private final Repository repository;

    public UserMenu(Repository repository)
    {
        this.repository = repository;
    }

    public void createMenu()
    {
        System.out.println("Welcome to the Game Music Database 1.0");
        System.out.println("--------------------------------------");
        System.out.println("What do you want to do? (Choose a number)" +
                " \n 1. Find soundtracks by composer" +
                "\n 2. Find soundtracks by platform" +
                "\n 3. Find composer by game" +
                "\n 4. List all soundtracks" +
                "\n 5. Sort soundtracks by release year");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        if (choice == 1)
        {
            findSoundtrackByComposer(scanner);
        }
        else if (choice == 2)
        {
            System.out.println("You picked two");
        }

        scanner.close();
    }

    public void findSoundtrackByComposer(Scanner scanner)
    {
        System.out.println("Which composer are you looking for? (Type in last name)");

        String composerName = scanner.next();

        System.out.println("You typed: " + composerName);

        repository.findComposers();

    }
}
