import java.util.List;
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
            findSoundtrackByPlatform(scanner);
        }
        else if (choice == 3)
        {
            findComposerByGame(scanner);
        }
        else if (choice == 4)
        {
            listSoundtracks();
        }
        else if (choice == 5)
        {
            sortSoundtracks();
        }
        else
        {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public void findSoundtrackByComposer(Scanner scanner)
    {
        System.out.println("Which composer are you looking for? (Type in last name)");

        String composerName = scanner.next();

        List<Composer> composerList = repository.findComposers();
        List<Soundtrack> soundtrackList = repository.findSoundtracks();


        for (Composer comp : composerList)
        {
            if (comp.getName().contains(composerName))
            {
                System.out.format("%-25s %-25s\n", "Composer", "Description");
                System.out.format("%-25s %-25s\n", comp.getName(), comp.getDescription());
                System.out.println("\nSoundtracks composed");

                for (Soundtrack sound : soundtrackList)
                {
                    if (sound.getComposerId().contains(comp.getName()))
                    {
                        System.out.format("%-25s %-25s\n", sound.getGameId(), sound.getLink());
                    }
                }
            }
        }
    }

    public void findSoundtrackByPlatform(Scanner scanner)
    {
        System.out.println("Which platform are you looking for? (Type your answer)");

        String platformName = scanner.next();

        List<Platform> platformList = repository.findPlatforms();
        List<Soundtrack> soundtrackList = repository.findSoundtracks();
        System.out.println("Soundtracks on platform: ");

        for (Platform platform : platformList)
        {
            if (platform.getPlatform().contains(platformName))
            {
                for (Soundtrack sound : soundtrackList)
                {
                    if (sound.getGameId().equals(platform.getGameId()))
                    {
                        System.out.format("%-25s %-25s\n", sound.getGameId(), sound.getLink());

                    }
                }
            }
        }
    }

    public void findComposerByGame(Scanner scanner)
    {
        System.out.println("Which game are you looking for? (Type your answer)");

        String game = scanner.next();

        repository.findComposerByGame(game);
    }

    public void listSoundtracks()
    {
        System.out.println("Number of soundtracks currently in database:");
        repository.listSoundtracks();

        System.out.println("--------------------------------------------");
        System.out.println("List of soundtracks:");

        List<Soundtrack> soundtrackList = repository.findSoundtracks();

        for (Soundtrack soundtrack : soundtrackList)
        {
            System.out.format("%-25s %25s\n", soundtrack.getGameId(), soundtrack.getLink());
        }
    }

    public void sortSoundtracks()
    {

    }
}
