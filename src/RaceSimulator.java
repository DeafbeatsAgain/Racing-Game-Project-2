import java.util.Random;
import java.util.List;

public class RaceSimulator {

    public static RaceResult simulateRace(RaceTrack selectedRaceTrack, RaceCar selectedCar) {
        double totalRaceTime = 0.0;
        Random rand = new Random();

        for (int i = 0; i < selectedRaceTrack.getLaps(); i++) {
            double baseLapTime = selectedRaceTrack.getDifficulty() / selectedCar.getHandling();
            double variance = 0.02 * rand.nextDouble() - 0.01; // generate a variance between -1% and 1%
            double adjustedLapTime = baseLapTime * (1 + variance); // apply variance
            totalRaceTime += adjustedLapTime;
        }

        double difficultyModifier = selectedRaceTrack.getDanger() / selectedCar.getDriverSkill();
        double performanceScore = (selectedCar.getTopSpeed() + selectedCar.getHandling() + selectedCar.getDriverSkill()) / 3.0;

        if (difficultyModifier > performanceScore) {
            return new RaceResult(selectedCar, "DNF");  // Car did not finish the race
        } else {
            return new RaceResult(selectedCar, String.format("%.3f", totalRaceTime));
        }
    }
    public static void displayRaceResults(RaceTrack selectedRace, List<RaceResult> raceResults) {
        System.out.println("Track: " + selectedRace.getTrackName());
        System.out.println("Laps: " + selectedRace.getLaps());

        for (int i = 0; i < raceResults.size(); i++) {
            RaceResult result = raceResults.get(i);
            int position = i + 1;

            // this line prints results
            System.out.printf("%d. %s - Race Time: %s\n", position, result.getRaceCar().getName(), result.getRaceTime());
        }
    }
}
