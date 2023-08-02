/**
Represents an item.
*/
class Item {
  private String itemName;
  private int quantity;
  private double price;
  private int calories;
  private int sold;

  /**
  Constructs an instance of the Item class with the specified details.
  @param itemName the name of the item.
  @param quantity the quantity of the item.
  @param price the price of the item.
  @param calories the calorie content of the item.
  */
  public Item(String itemName, int quantity, double price, int calories) {
    this.itemName = itemName;
    this.quantity = quantity;
    this.price = price;
    this.calories = calories;
    this.sold = 0;
  }
  
  /**
  Gets the name of the item.
  @return the name of the item as a String.
  */
  public String getItemName() {
    return itemName;
  }
  
  /**
  Gets the quantity of the item in stock.
  @return the quantity of the item as an integer.
  */
  public int getQuantity() {
    return quantity;
  }
  
  /**
  Sets the quantity of the item in stock.
  The quantity must be between 0 and 10 (inclusive).
  @param quantity the new quantity of the item as an integer.
  */
  public void setQuantity(int quantity) {
    if (quantity >= 0 && quantity <= 10) {
      this.quantity = quantity;
    }
  }
  
  /**
  Gets the price of the item.
  @return the price of the item as a double.
  */
  public double getPrice() {
    return price;
  }
  
  /**
  Sets the price of the item.
  @param price the new price of the item as a double.
  */
  public void setPrice(double price) {
    this.price = price;
  }
  
  /**
  Gets the calorie content of the item.
  @return the calorie content of the item as an integer.
  */
  public int getCalories() {
    return calories;
  }
  
  /**
  Sets the calorie content of the item.
  @param calories the new calorie content of the item as an integer.
  */
  public void setCalories(int calories) {
    this.calories = calories;
  }
  
  /**
  Gets the number of units of this item sold.
  @return the number of units sold as an integer.
  */
  public int getSold() {
    return sold;
  }
  
  /**
  Sets the number of units of this item sold.
  @param sold the new number of units sold as an integer.
  */
  public void setSold(int sold) {
    this.sold = sold;
  }
}