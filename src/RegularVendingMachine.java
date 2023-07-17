import java.util.*;

/**
* Represents the workings of the regular vending machine
*/ 
class RegularVendingMachine {
    protected Item item;
    protected CashBox cashbox;
    protected int totalItems, totalUnique;
    protected int count;
    protected HashMap<Integer, String> itemNumbers;

    public HashMap<Integer, String> getItemNumbers() {
		return itemNumbers;
	}

	public void setItemNumbers(HashMap<Integer, String> itemNumbers) {
		this.itemNumbers = itemNumbers;
	}

	/**
     * Constructs an instance of the RegularVendingMachine class.
     */
    public RegularVendingMachine() {
        item = new Item();
        cashbox = new CashBox();
        itemNumbers = new HashMap<>();
        item.setItemQuantity(new HashMap<>());
        item.setItemPrice(new HashMap<>());
        item.setItemCalories(new HashMap<>());
        item.setItemSold(new HashMap<>());
        item.setTotalSales(0);
    }

    /**
     * Displays the stock of items in the vending machine.
     */
    public void displayStock() {
        int quantity, calories;
        double price;
        int number = 1;
        count = 0;
        totalUnique = 0;
        for (String key : item.getItemQuantity().keySet()) {
            quantity = item.getItemQuantity().get(key);
            price = item.getItemPrice().get(key);
            calories = item.getItemCalories().get(key);

            itemNumbers.put(number, key);
            
            System.out.println(number + ". " + key + " - Quantity: " + quantity + " - Price: ₱" + price + " - Calories: " + calories);

            count += quantity;
            totalUnique++;
            number++;
        }
        totalItems = count;
        System.out.println("Current Total Items: " + totalItems);
    }


    /**
     * Returns the item in the vending machine.
     *
     * @return the item.
     */
    public Item getItem() {
        return item;
    }
    
    public CashBox getCashBox() {
    	return cashbox;
    }
}
