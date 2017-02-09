package net.tsamaya.basis;
//
// https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
//
public class Bicycle {

    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        this.gear = startGear;
        this.cadence = startCadence;
        this.speed = startSpeed;
    }

    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        this.cadence = newValue;
    }

    public void setGear(int newValue) {
        this.gear = newValue;
    }

    public void applyBrake(int decrement) {
        this.speed -= decrement;
    }

    public void speedUp(int increment) {
        this.speed += increment;
    }

    public void testOverridingMethod(String name) {
      System.out.println(String.format("this is the bake name %s", name));
    }

    // public String testOverridingReturn() {
    //   return String.format("%s",this.cadence);
    // }

}
