public class RaceCar {
    private String name;
    private int topSpeed;
    private int driverSkill;
    private int handling;

    public RaceCar(String name, int topSpeed, int driverSkill, int handling)
    {
        this.name = name;
        this.topSpeed = topSpeed;
        this.driverSkill = driverSkill;
        this.handling = handling;
    }

    /*
    Getter Methods:
    example use
    double lapTime = calcLapTime(Labergenie.getHandling());
    this will assign the lapTime variable to the result of calcLapTime
    which takes the Labergenie's handling into account
     */
    public String getName() {return name;}
    public int getTopSpeed() {
        return topSpeed;
    }
    public int getDriverSkill() {
        return driverSkill;
    }
    public int getHandling() {
        return handling;
    }

    // Setter methods
    public void setName(String name) {this.name = name;}
    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setDriverSkill(int driverSkill) {
        this.driverSkill = driverSkill;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }
}