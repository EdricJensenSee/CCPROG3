import java.util.ArrayList;

/**
Represents a cash box used in a vending machine to handle payments and change.
*/
public class CashBox {
  private Money[] money;
  private ArrayList < Double > denominationsSpent;
  private double amountPaid = 0.0;
  private double totalSales;
  private ArrayList < Item > deletedItems;

  /**
  Constructor of the CashBox.
  */
  public CashBox() {
    money = new Money[] {
      new Money(5, 0), new Money(10, 0), new Money(20, 0), new Money(50, 0), new Money(100, 0)
    };
    denominationsSpent = new ArrayList < > ();
    totalSales = 0.0;
    deletedItems = new ArrayList < > ();
  }
  
  /**
  Checks if an item is available in the cash box (i.e., quantity > 0).
  @param item the Item object representing the item to check.
  @return true if the item is available, false otherwise.
  */
  public boolean isItemAvailable(Item item) {
    return item.getQuantity() > 0;
  }
  
  /**
  Adds an amount to the total amount paid for a transaction.
  @param amount the amount to add as a double value.
  */
  public void addTotalAmount(double amount) {
    amountPaid += amount;
  }
  
  /**
  Deducts an amount from the total amount paid for a transaction.
  @param amount the amount to deduct as a double value.
  */
  public void deductTotalAmount(double amount) {
    amountPaid -= amount;
  }
  
  /**
  Resets the total amount paid for a transaction to zero.
  */
  public void resetAmountPaid() {
    amountPaid = 0;
  }
  
  /**
  Gets the total amount paid for a transaction.
  @return the total amount paid as a double value.
  */
  public double getAmountPaid() {
    return amountPaid;
  }
  
  /**
  Sets the total amount paid for a transaction.
  @param amountPaid the total amount paid as a double value.
  */
  public void setAmountPaid(double amountPaid) {
    this.amountPaid = amountPaid;
  }
  
  /**
  Gets the array of Money objects representing different denominations of currency.
  @return the array of Money objects.
  */
  public Money[] getMoney() {
    return money;
  }
  
  /**
  Sets the array of Money objects representing different denominations of currency.
  @param money the new array of Money objects.
  */
  public void setMoney(Money[] money) {
    this.money = money;
  }
  
  /**
  Gets the total sales amount from all successful transactions.
  @return the total sales amount as a double value.
  */
  public double getTotalSales() {
    return totalSales;
  }
  
  /**
  Sets the total sales amount from all successful transactions.
  @param totalSales the total sales amount as a double value.
  */
  public void setTotalSales(double totalSales) {
    this.totalSales = totalSales;
  }
  
  /**
  Resets the total sales amount to zero.
  */
  public void resetTotalSales() {
    totalSales = 0.0;
  }
  
  /**
  Gets the list of items that have been deleted (quantity = 0) from the cash box.
  @return the ArrayList of Item objects representing the deleted items.
  */
  public ArrayList < Item > getDeletedItems() {
    return deletedItems;
  }
  
  /**
  Sets the list of items that have been deleted (quantity = 0) from the cash box.
  @param deletedItems the ArrayList of Item objects representing the deleted items.
  */
  public void setDeletedItems(ArrayList < Item > deletedItems) {
    this.deletedItems = deletedItems;
  }
  
  /**
  Dispenses change for a transaction by updating the quantity of money denominations used.
  Returns true if change can be dispensed successfully, false otherwise.
  @param change the change amount to dispense as a double value.
  @return true if change is successfully dispensed, false otherwise.
  */
  public boolean dispenseChange(double change) {
	  int changeAmount = (int) change;
      int remainingChange = changeAmount;

      for (int i = money.length - 1; i >= 0; i--) {
          int denomination = money[i].getType();
          int availableQuantity = money[i].getQuantity();
          int numToDispense = Math.min(availableQuantity, remainingChange / denomination);
          
          if (numToDispense > 0) {
              remainingChange -= numToDispense * denomination;
              money[i].setQuantity(availableQuantity - numToDispense);
              
              for (int j = 0; j < numToDispense; j++) {
                  denominationsSpent.add((double) denomination);
              }
          }
      }

      if (remainingChange == 0) {
          return true;
      } else {
          for (int i = 0; i < denominationsSpent.size(); i++) {
              money[i].setQuantity(money[i].getQuantity() + 1);
          }
          denominationsSpent.clear();
          return false;
      }
  }
  
  /**
  Handles the payment received for an item and updates the cash box accordingly.
  Returns true if the payment is successful, false otherwise.
  @param items the ArrayList of Item objects representing the items available in the vending machine.
  @param itemName the name of the item to be purchased.
  @param amountPaid the amount paid by the customer as a double value.
  @return true if the payment is successful, false otherwise.
  */
  public boolean receivePayment(ArrayList < Item > items, String itemName, double amountPaid) {
	  Item item = getItemByName(items, itemName);
      if (item == null || item.getQuantity() <= 0) {
          return false;
      }

      double price = item.getPrice();

      if (amountPaid < price) {
          return false;
      } else if (amountPaid > price) {
          double change = amountPaid - price;
          if (!dispenseChange(change)) {
              return false;
          }
          item.setQuantity(item.getQuantity() - 1);
          item.setSold(item.getSold() + 1);
          setTotalSales(getTotalSales() + price);
          return true;
      } else if (amountPaid == price){
          item.setQuantity(item.getQuantity() - 1);
          item.setSold(item.getSold() + 1);
          setTotalSales(getTotalSales() + price);
          return true;
      }
      return false;
  }
  
  /**
  Checks if an item is empty (quantity = 0) and adds it to the deletedItems list if so.
  @param items the ArrayList of Item objects representing the items available in the vending machine.
  @param itemName the name of the item to check.
  */
  public void isEmpty(ArrayList < Item > items, String itemName) {
      Item item = getItemByName(items, itemName);
      if (item.getQuantity() == 0) {
          deletedItems.add(item);
          items.remove(item);
      }
  }
  
  /**
  Retrieves an Item object from the ArrayList of items based on the item name.
  @param items the ArrayList of Item objects representing the items available in the vending machine.
  @param itemName the name of the item to retrieve.
  @return the Item object representing the desired item or null if not found.
  */
  public Item getItemByName(ArrayList < Item > items, String itemName) {
      for (Item item : items) {
          if (item.getItemName().equals(itemName)) {
              return item;
          }	
      }
      return null;
  }
  
  /**
  Gets the list of money denominations spent for dispensing change during a transaction.
  @return the ArrayList of Double values representing the money denominations spent.
  */
  public ArrayList < Double > getDenominationsSpent() {
    return denominationsSpent;
  }
  
  /**
  Sets the list of money denominations spent for dispensing change during a transaction.
  @param denominationsSpent the ArrayList of Double values representing the money denominations spent.
  */
  public void setDenominationsSpent(ArrayList < Double > denominationsSpent) {
    this.denominationsSpent = denominationsSpent;
  }
}