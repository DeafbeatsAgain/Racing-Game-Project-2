import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*


Core loop of the game
1. start game
    2. display menu
        3. start new-game
            4. choose car
            5. choose track
            TODO: 6. set # of AI racers
            TODO: 7. set # of laps (option for default)
        8. simulate race
            9. display results

 */

public class RaceGame
    {
    public enum MainMenuInputResult
        /*
        Learning note to self:
        enum allows me to create my own definition for a variable. for example:
        a char is a single character, a char cannot hold the value of a number.
        My enum below creates a variable called `MainMenuInputResult`, and it
        can have one of 3 states (at the moment), NewGame, Continue, and Exit.

        Although this adds a layer of abstraction, it gives me the ability to
        customize my code.
         */
        {
            NewGame,
            Continue,
            Exit
        }
    public List<RaceTrack> raceSchedule; //collects the racetracks into a list to display
    public List<RaceCar> raceCarList; //collects the race cars into a list to display
    public List<RaceResult> raceResultList = new ArrayList<>(); //a list that is used for displayRaceResults
    private final Scanner scanner = new Scanner(System.in);

    public void start() //starts the game
    {
    GameMenu menu = new GameMenu(this.scanner);
    menu.displayMainMenu();
    MainMenuInputResult userChoice = menu.acceptMainMenuInput();
    switch (userChoice) //based on user choice this enum switch will take us down a different path below
    {
        case NewGame -> {
            startNewGame();
        }
        case Continue -> {
            //TODO: set a way to continue game later
        }
        case Exit -> {
            scanner.close();
            stop();
        }
    }
    }
    public void stop()
        {
        System.exit(0); //zero here states a normal exit
        }
    public void restart()
        {
        //TODO: set restart functionality (not sure if needed, but it could be after results post.
        }
    static class GameMenu
        /*
        This holds the instructions to open the menuInput, display the menu,
         */
        {
        private final Scanner menuInput;
        public GameMenu(Scanner menuInput) //constructor
        {
        this.menuInput = menuInput;
        }
        public void displayMainMenu()
            {
            System.out.println("\nMain Menu:");
            System.out.println("1. New Game");
            System.out.println("2. Continue");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            }
        public MainMenuInputResult acceptMainMenuInput()
            {
            int choice = this.menuInput.nextInt();
            switch (choice) {
                case 1 -> {
                    return MainMenuInputResult.NewGame;
                }
                case 2 -> {
                    System.out.println("Continue game selected.");
                    return MainMenuInputResult.Continue;
                }
                case 3 -> {
                    System.out.println("Exiting the game...");
                    return MainMenuInputResult.Exit;
                }
                default -> {
                    System.out.flush(); //clears terminal screen for error handling
                    System.out.println("Invalid choice. Please try again.");
                    return acceptMainMenuInput(); //this should let us loop back to the top of this switch case
                }
            }
            }
        }
    private void displayCars()
        {
        System.out.println("\nAvailable Cars:");
        for (int i = 0; i < raceCarList.size(); i++) {
            RaceCar displayCarsCars = raceCarList.get(i);
            System.out.println((i + 1) + ". " + displayCarsCars.getName());
        }
        System.out.println("----------------------");
        }

    private void displayRaceSchedule()
        {
        for (int i = 0; i < raceSchedule.size(); i++) {
            RaceTrack race = raceSchedule.get(i);
            System.out.println((i + 1) + ". " + race.getTrackName() + " - Laps: " + race.getLaps());
        }
        }

    public void initializeRaceSchedule() //I can manually add racetracks to this array
    {
    raceSchedule = new ArrayList<>();
    raceSchedule.add(new RaceTrack(10, 5, 0.2, "Test Track Speedway"));
    raceSchedule.add(new RaceTrack(50, 5, 0.7, "Flatlands Trackway"));
    raceSchedule.add(new RaceTrack(75, 3, 0.5, "Gulf of New-Mexico beach sprint"));
    // Add more racetracks to the schedule as needed
    }
    public void initializeRaceCarList() //I can manually add race cars to this array
    {
    raceCarList = new ArrayList<>();
    raceCarList.add(new RaceCar("Average Car", 5, 5, 5));
    raceCarList.add(new RaceCar("The Pink One", 7, 6, 4));
    raceCarList.add(new RaceCar("Reginald P. Reginald", 5, 5, 5));
    raceCarList.add(new RaceCar("Venn \"Long-Hands\" McKenzie", 5, 5, 5));

    //enter new race cars here^ during testing most cars will be set to default values 5/5/5 until I figure out the math.
    }

    private void startNewGame()
        {
        initializeRaceCarList();
        System.out.print("Select your car (enter the number): ");
        displayCars();
        int carIndex = this.scanner.nextInt();
        // Ensure carIndex is within valid bounds
        RaceCar selectedCar = null;
        if (carIndex >= 1 && carIndex <= raceCarList.size()) {
            selectedCar = raceCarList.get(carIndex - 1);
            System.out.println("Selected Car: " + selectedCar);
        } else {
            System.out.println("Invalid car selection.");
        }

        initializeRaceSchedule();
        System.out.println("\nRace Schedule:");
        displayRaceSchedule();
        System.out.print("Select a race (enter the number): ");
        int raceIndex = this.scanner.nextInt();
        RaceTrack selectedRaceTrack = raceSchedule.get(raceIndex - 1);

        System.out.println("\nStarting a new game...");
        System.out.println("Selected Car: " + selectedCar.getName());
        System.out.println("Selected Race: " + selectedRaceTrack.getTrackName());
        System.out.println("Track: " + selectedRaceTrack.getTrackName());
        System.out.println("Laps: " + selectedRaceTrack.getLaps());
        System.out.println();

        RaceResult result = RaceSimulator.simulateRace(selectedRaceTrack, selectedCar); // Update the parameters
        this.raceResultList.add(result);
        RaceSimulator.displayRaceResults(selectedRaceTrack, this.raceResultList);

        }


    }
