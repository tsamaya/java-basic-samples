package net.tsamaya.basis;
//
// https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
//
public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        this.seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        this.seatHeight = newValue;
    }

    public void testOverridingMethod(Integer value) {
      System.out.println(String.format("this is the bike price %s", value));
    }

    //cannot override 
    // public Integer testOverridingReturn() {
    //   return new Integer(this.cadence);
    // }

}
