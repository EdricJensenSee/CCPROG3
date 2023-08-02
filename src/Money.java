/**
Represents the money of the machine.
*/
public class Money {
  private int type;
  private int quantity;

  /**
  Constructs a Money object with the specified type and quantity.
  @param type the type of currency.
  @param quantity the quantity of this type of currency.
  */
  public Money(int type, int quantity) {
    this.type = type;
    this.quantity = quantity;
  }
  
  /**
  Gets the type of currency.
  @return the type of currency as an integer.
  */
  public int getType() {
    return type;
  }
  
  /**
  Gets the quantity of this type of currency.
  @return the quantity of the currency as an integer.
  */
  public int getQuantity() {
    return quantity;
  }
  
  /**
  Sets the quantity of this type of currency.
  @param quantity the new quantity of the currency as an integer.
  */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  /**
  Replenishes the quantity of this type of currency by adding the given amount.
  @param quantity the quantity to be added to the current amount as an integer.
  */
  public void replenish(int quantity) {
    this.quantity += quantity;
  }
}