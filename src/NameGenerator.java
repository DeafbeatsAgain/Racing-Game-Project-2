import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
TODO: Not using this just yet, but it's fun and I will soon.
*/
public class NameGenerator
{
    private List<String> aiPlayerNames;

    public static void main(String[] args)
    {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.initializeAIPlayerNames(); // Initialize the aiPlayerNames list

// Generate and print 10 random names
        List<String> randomNames = nameGenerator.generateRandomNames(10);
        for (String name : randomNames) {
            System.out.println(name);
        }
    }

    // begin AI Name maker
    private String[] aiFirstNames =
            {
                    "Big-Al",
                    "Cal",
                    "Rip",
                    "Thomas",
                    "Jerf",
                    "Guy",
                    "Eduardo",
                    "Steven",
                    "Keith",
                    "Candle-Jack",
            };
    private String[] aiLastNames =
            {
                    "Leyva",
                    "Daytona",
                    "Davidson",
                    "Geraldo",
                    "Biggins",
                    "Havvereff",
                    "Goblin-Hands",
                    "Diagram",
                    "\"Shoulder-check\" Johnson",
                    "Joeharrisburgsen",
                    "Gorf"
            };

    public String getRandomName()
    {
        Random rand = new Random();
        String firstName = aiFirstNames[rand.nextInt(aiFirstNames.length)];
        String lastName = aiLastNames[rand.nextInt(aiLastNames.length)];
        return firstName + " " + lastName;
    }

    // Initializes and creates a list of names
    private void initializeAIPlayerNames()
    {
        aiPlayerNames = new ArrayList<>();

        for (String firstName : aiFirstNames) {
            for (String lastName : aiLastNames) {
                aiPlayerNames.add(firstName + " " + lastName);
            }
        }
    }

    // Generate n random names with no repeated last names
    public List<String> generateRandomNames(int n)
    {
        List<String> randomNames = new ArrayList<>();

// Create a copy of the aiLastNames list
        List<String> availableLastNames = new ArrayList<>(Arrays.asList(aiLastNames));

        Random rand = new Random();

// Generate n random names
        for (int i = 0; i < n; i++) {
            if (availableLastNames.isEmpty()) {
                // Break the loop if there are no more available last names
                break;
            }

            String firstName = aiFirstNames[rand.nextInt(aiFirstNames.length)];

            int randomIndex = rand.nextInt(availableLastNames.size());
            String lastName = availableLastNames.get(randomIndex);

            // Remove the selected last name from the available last names list
            availableLastNames.remove(randomIndex);

            // Add the random name to the result list
            randomNames.add(firstName + " " + lastName);
        }

        return randomNames;
    }
}