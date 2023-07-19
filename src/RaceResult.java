public class RaceResult {
    private RaceCar raceCar;
    private String raceTime;

    public RaceResult(RaceCar raceCar, String raceTime) {
        this.raceCar = raceCar;
        this.raceTime = raceTime;
    }

    public RaceCar getRaceCar() {
        return raceCar;
    }

    public String getRaceTime() {
        return raceTime;
    }
}
