public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Overloaded constructor for Cafe with default ingredients and cups
     * @param name of the cafe
     * @param address of the cafe
     * @param nFloors number of cafe
     */
    public Cafe(String name, String address, int nFloors) {
      this(name, address, nFloors, 100, 50, 50, 15);
    }

    /** 
     * Full constructor for Cafe
     * @param name of the cafe
     * @param address of the cafe
     * @param nFloors number of cafe
     * @param nCoffeeounces the number of ounces of coffee remaining in inventory
     * @param nSugarPackets the number of sugar packets remaining in inventory
     * @param nCreams the number of "splashes" of cream remaining in inventory
     * @param nCups the number of cups remaining in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      super(name, address, nFloors);
      this.nCoffeeOunces = nCoffeeOunces;
      this.nSugarPackets = nSugarPackets;
      this.nCreams = nCreams;
      this.nCups = nCups;
      System.out.println("You have built a cafe: ☕");
    }
    
    /*
     * Method for selling coffee
     * @param size needed
     * @param the number of sugar packets needed
     * @param the number of creams needed
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
      // restock if insufficient inventory
      if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
        System.out.println("Oops, not enough inventory at " + this.name + ".");
        restock(size, nSugarPackets, nCreams, 1);
      }
      // proceed to sell after restocking
      this.nCoffeeOunces -= size;
      this.nSugarPackets -= nSugarPackets;
      this.nCreams -= nCreams;
      this.nCups -= 1;
      System.out.println("Coffee has been sold. Remaining inventory: ");
      System.out.println("Coffee: " + this.nCoffeeOunces + " oz, Sugar: " + this.nSugarPackets + " packet(s), Cream: " + this.nCreams + ", Cup(s): " + this.nCups);
    }

    /*
     * Overloaded method for selling coffee with default values
     */
    public void sellCoffee() {
      // restock if insufficient inventory
      if (this.nCoffeeOunces < 50 || this.nSugarPackets < 25 || this.nCreams < 25 || this.nCups < 1) {
        System.out.println("Oops, not enough inventory at " + this.name + ".");
        restock(50, 25, 25, 1);
      }
      // proceed to sell after restocking
      this.nCoffeeOunces -= 50;
      this.nSugarPackets -= 25;
      this.nCreams -= 25;
      this.nCups -= 1;
      System.out.println("Coffee has been sold. Remaining inventory: ");
      System.out.println("Coffee: " + this.nCoffeeOunces + " oz, Sugar: " + this.nSugarPackets + " packet(s), Cream: " + this.nCreams + ", Cup(s): " + this.nCups);
    }

    /*
     * Method for restocking
     * @param the number of ounces of coffee for restocking
     * @param the number of sugar packets for restocking
     * @param the number of creas for restocking
     * @param the number of cups for restocking
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      this.nCoffeeOunces += nCoffeeOunces;
      this.nSugarPackets += nSugarPackets;
      this.nCreams += nCreams;
      this.nCups += nCups;
      System.out.println("Successfully restocked. Current inventory: ");
      System.out.println("Coffee: " + this.nCoffeeOunces + " oz, Sugar: " + this.nSugarPackets + " packet(s), Cream: " + this.nCreams + ", Cup(s): " + this.nCups);
    }

    /**
     * Method for moving between floors
     * @param floorNum to go
     */
    public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum != 1) {
      throw new RuntimeException("Invalid floor number. You are only allowed to go to the first floor ");
    }
    if (floorNum == activeFloor) {
      throw new RuntimeException("You are already on floor #" + floorNum + " of " + this.name);
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
    }

    /**
     * Method for printing out the options
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }  
  
    public static void main(String[] args) {
      Cafe SmithCafe = new Cafe("Compass", "7 Neilson Drive, MA 01063", 1);
      System.out.println(SmithCafe);
      SmithCafe.showOptions();
      SmithCafe.sellCoffee();
      SmithCafe.sellCoffee(50, 25, 25);
      SmithCafe.sellCoffee(50, 25, 25);
      SmithCafe.sellCoffee(200, 100, 100);
    }
  
  }