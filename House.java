import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /** 
   * Overloaded constructor for House with default dining room and elevator status
   * @param name of the house
   * @param address of the house
   * @param nFloors number of floors
  */
  public House(String name, String address, int nFloors) {
    this(name, address, nFloors, false, false);
  }

  /** 
   * Full constructor for House
   * @param name of the house
   * @param address of the house
   * @param nFloors number of floors
   * @param hasDiningRoom or not
   * @param hasElevator or not
  */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Getter for hasDiningRoom
   * @return whether the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
  
  /**
   * Getter for hasElevator
   * @return whether the house has an elevator
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }

  /*
   * Getter for nResidents
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Method for house residents move-in
   * @param name of the residents to move in the house
   */
  public void moveIn(String name) {
    // check if already a resident
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.name + ".");
    }
    // proceed if not a resident
    this.residents.add(name);
    System.out.println(name + " has moved into house " + this.name + ".");
    System.out.println(this.name + " has " + this.nResidents() + " resident(s).");
  }

  /**
   * Overloaded method for a list of house residents move-in
   * @param list of the residents to move in the house
   */
    public void moveIn(ArrayList<String> list) {
      // loop through names on the list
      for (String name : list) {
        // check if already residents
        if (this.residents.contains(name)) {
          throw new RuntimeException(name + " is already a resident of " + this.name + ".");
        }
        // proceed if not residents
        this.residents.add(name);
        System.out.println(name + " has moved into house " + this.name + ".");
      System.out.println(this.name + " has " + this.nResidents() + " resident(s).");
    }
  }


  /**
   * Method for house residents move-out
   * @param name of the residents in the house
   * @return name of the resident who moved out
   */
  public String moveOut(String name) {
    // check if not in the house
    if (!this.residents.contains(name)){
      throw new RuntimeException(name + " is not in the house " + this.name + ".");
    }
    // proceed if in the house
    this.residents.remove(name);
    System.out.println(name + " has moved out house " + this.name + ".");
    System.out.println(this.name + " has " + this.nResidents() + " resident(s).");
    return name;
  }

  /**
   * Method for checking if the person is a resident
   * @param person to check
   * @return if the person is a resident
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  /**
   * Method for moving between floors
   * @param floorNum to go
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!hasElevator && Math.abs(floorNum - activeFloor) != 1) {
      throw new RuntimeException("No elevator in this house. You can only move between adjacent floors.");
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
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + hasElevator()\n + nResidents()\n + moveIn(name)\n + moveOut(name)\n + isResident(person)");
  }

  public static void main(String[] args) {
    House myHouse = new House("Ziskind", "1 Henshaw Ave, MA 01063", 3, true, true);
    System.out.println(myHouse);
    myHouse.showOptions();
    myHouse.moveIn("Nora");
    try {
      myHouse.moveIn("Nora");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    } 
    myHouse.moveOut("Nora");
    try {
      myHouse.moveOut("Alyssa");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
    ArrayList<String> newResidents = new ArrayList<>();
    newResidents.add("Susan");
    newResidents.add("Sarah");
    newResidents.add("Charlie");
    myHouse.moveIn(newResidents);
  }

}