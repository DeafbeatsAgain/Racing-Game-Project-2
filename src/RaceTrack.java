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

    public int getLaps() {return laps;}

    public double getDifficulty() {return difficulty;}

    public double getDanger() {return danger;}
    // one of these two below gotta go
    public String getTrackName() {
        return trackName;
    }
}
