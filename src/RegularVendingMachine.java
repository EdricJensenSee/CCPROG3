import java.util.*;

/**
Represents a regular vending machine that stores and manages items.
*/
class RegularVendingMachine {
  protected ArrayList < Item > itemSlots;
  protected int totalItems;
  protected int totalUnique;

  
  /**
  Constructor of RegularVendingMachine
  */
  public RegularVendingMachine() {
    this.itemSlots = new ArrayList < > ();
    Main.regularCashBox = new CashBox();
  }
  
  /**
  Retrieves the item with the given name from the vending machine.
  @param itemName the name of the item to search for.
  @return the Item object representing the desired item or null if not found.
  */
  public Item getItemByName(String itemName) {
    for (Item item: itemSlots) {
      if (item.getItemName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }
  
  /**
  Returns the list of item slots in the vending machine.
  @return the ArrayList of Item objects representing the item slots.
  */
  public ArrayList < Item > getItemSlots() {
    return itemSlots;
  }
  
  /**
  Sets the item slots in the vending machine.
  @param itemSlots the ArrayList of Item objects representing the item slots.
  */
  public void setItemSlots(ArrayList < Item > itemSlots) {
    this.itemSlots = itemSlots;
  }
  
  /**
  Adds an item to the vending machine or updates its information if it already exists.
  @param itemName the name of the item.
  @param quantity the quantity of the item.
  @param price the price of the item.
  @param calories the calorie content of the item.
  @return true if the item was successfully added or updated, false otherwise.
  */
  public boolean addItem(String itemName, int quantity, double price, int calories) {
    if (quantity <= 0 || quantity > 10 || totalUnique >= 12) {
      return false;
    }
    for (Item item: itemSlots) {
      if (item.getItemName().equals(itemName)) {
        item.setQuantity(quantity);
        item.setPrice(price);
        item.setCalories(calories);
        totalItems += (quantity - item.getQuantity());
        return true;
      }
    }
    Item newItem = new Item(itemName, quantity, price, calories);
    itemSlots.add(newItem);
    totalItems += quantity;
    totalUnique++;
    return true;
  }
  
  /**
  Retrieves the item from the vending machine based on the slot number.
  @param slotNumber the slot number of the item.
  @return the Item object representing the desired item or null if not found.
  */
  public Item getItem(int slotNumber) {
    if (slotNumber >= 0 && slotNumber < itemSlots.size()) {
      return itemSlots.get(slotNumber);
    }
    return null;
  }
  
  /**
  Gets the cash box associated with this vending machine.
  @return the CashBox object representing the cash box of the vending machine.
  */
  public CashBox getCashBox() {
    return Main.regularCashBox;
  }
}