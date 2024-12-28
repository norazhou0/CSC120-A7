import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection; 
  private boolean hasElevator;


  /** 
   * Overloaded constructor for Library with default elevator status
   * @param name of the library
   * @param address of the library
   * @param nFloors number of floors
  */
  public Library(String name, String address, int nFloors) {
    this(name, address, nFloors, true);
  }

  /** 
   * Full constructor for Library
   * @param name of the library
   * @param address of the library
   * @param nFloors number of floors
   * @param hasElevator or not
  */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Getter for hasElevator
   * @return whether the library has an elevator
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }

  /**
   * Method to add books to the collection
   * @param title of the book
   */
  public void addTitle(String title) {
    // check if the book exists
    if (this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " already exists in " + this.name + ".");
    }
    // proceed if doesn't exist
    this.collection.put(title, true);
    System.out.println("The book " + title + " has been added to " + this.name + ".");
  }

  /**
   * Overloaded method to add a list of books to the collection
   * @param list of books
   */
  public void addTitle(ArrayList<String> list) {
    // loop through titles on the list
    for (String title : list) {
      if (this.collection.containsKey(title)) {
        throw new RuntimeException("The book " + title + " already exists in " + this.name + ".");
      }
      // check if the book exists
      if (this.collection.containsKey(title)) {
        throw new RuntimeException("The book " + title + " already exists in " + this.name + ".");
      }
      // proceed if doesn't exist
      this.collection.put(title, true);
    System.out.println("The book " + title + " has been added to " + this.name + ".");
    }
  }

  /**
   * Method to remove books from the collection
   * @param title of the book
   * @return the book got removed
   */
  public String removeTitle(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
    }
    // proceed if exists
    this.collection.remove(title);
    System.out.println("The book " + title + " has been removed from " + this.name + ".");
    return title;
  }

  /**
   * Method to check out books
   * @param title of the book
   */
  public void checkOut(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
    }
    // check if the book has been checked out
    if (!this.collection.get(title)) {
      throw new RuntimeException("The book " + title + " has already been checked out from " + this.name + ".");
    }
    // proceed if still available
    this.collection.put(title, false);
    System.out.println("The book " + title + " has been successfully checked out from " + this.name + ".");
  }

  /**
   * Overloaded method to check out a list of books
   * @param list of books
   */
  public void checkOut(ArrayList<String> list) {
    // loop through titles on the list 
    for (String title : list) {
      // check if the book doesn't exist
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
      }
      // check if the book has been checked out
      if (!this.collection.get(title)) {
        throw new RuntimeException("The book " + title + " has already been checked out from " + this.name + ".");
      }
      // proceed if still available
      this.collection.put(title, false);
    System.out.println("The book " + title + " has been successfully checked out from " + this.name + ".");
    }
  }

  /**
   * Method to return books
   * @param title of the book
   */
  public void returnBook(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
    }
    // check if the book is available
    if (this.collection.get(title)) {
      throw new RuntimeException("The book " + title + " has not been checked out yet from" + this.name + ".");
    }
    // proceed if not available
    this.collection.put(title, true);
    System.out.println("The book " + title + " has been successfully returned to " + this.name + ".");
  }

  /**
   * Method to check if the collection contains the book
   * @param title of the book
   * @return if the collection contains the book
   */
  public boolean containsTitle(String title) {
    // returns true if the title appears as a key in the Libary's collection, false otherwise
    return this.collection.containsKey(title);
  }

  /**
   * Method to check if the book is available 
   * @param title of the book
   * @return if the book is abailable
   */
  public boolean isAvailable(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " does not exist in " + this.name + ".");
    }
    // returns true if the title is currently available, false otherwise
    return this.collection.get(title);
  }

  /**
   * Method for printing out the collection
   */
  public void printCollection() {
    // prints out the entire collection in an easy-to-read way (including checkout status)
    System.out.println("The collection in " + this.name + ":");
    for (String title : this.collection.keySet()) {
      boolean isAvailable = this.collection.get(title);
      System.out.println("-" + title + "; " + "Available: " + isAvailable);
    }
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
      throw new RuntimeException("No elevator in this library. You can only move between adjacent floors.");
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
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasElevator()\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(titile)\n + printCollection()");
  }

  public static void main(String[] args) {
    Library smithLibrary = new Library("Neilson", "7 Neilson Drive, MA 01063", 5, true);
    System.out.println(smithLibrary);
    smithLibrary.showOptions();
    smithLibrary.addTitle("Computer Science by Dr. A");
    smithLibrary.addTitle("Economics by Dr. B");
    smithLibrary.addTitle("Psychology by Dr. C");
    smithLibrary.printCollection();
    smithLibrary.removeTitle("Psychology by Dr. C");
    try {
      smithLibrary.returnBook("Psychology by Dr. C");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    } 
    smithLibrary.checkOut("Economics by Dr. B");
    try {
      smithLibrary.checkOut("Economics by Dr. B");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
    ArrayList<String> newBooks = new ArrayList<>();
    newBooks.add("Stitch by Yumi Tsukurino");
    newBooks.add("Frozen by Daytona Danielsen");
    newBooks.add("Princess by Holly Rice");
    smithLibrary.addTitle(newBooks);
    smithLibrary.checkOut(newBooks);
  }

}

