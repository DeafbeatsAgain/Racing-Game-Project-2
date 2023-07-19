public class RaceTrack {
    private final int laps;
    private final double difficulty;
    private final double danger;
    private final String trackName;

    public RaceTrack( int laps, double difficulty, double danger, String trackName)
    {
        this.laps = laps;
        this.difficulty = difficulty;
        this.danger = danger;
        this.trackName = trackName;
    }
    //Getters: these are used to access the data held in the RaceTrack objects
    public int getLaps() {return laps;}
    public double getDifficulty() {return difficulty;}
    public double getDanger() {return danger;}
    public String getTrackName() {return trackName;}
}
