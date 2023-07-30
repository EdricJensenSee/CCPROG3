import java.util.*;

/**
 * Represents the workings of the regular vending machine
 */
class RegularVendingMachine {
    private ArrayList<Item> itemSlots;
    public ArrayList<Item> getItemSlots() {
		return itemSlots;
	}

	public void setItemSlots(ArrayList<Item> itemSlots) {
		this.itemSlots = itemSlots;
	}

	protected int totalItems, totalUnique;
    protected int count;
    protected HashMap<Integer, String> itemNumbers;
    
    public Item getItembyName(String itemName) {
        for (Item item : itemSlots) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Constructs an instance of the RegularVendingMachine class.
     */
    public RegularVendingMachine() {
        this.itemSlots = new ArrayList<>();
        itemNumbers = new HashMap<>();
        Main.regularCashBox = new CashBox();
    }

    public HashMap<Integer, String> getItemNumbers() {
        return itemNumbers;
    }

    public void setItemNumbers(HashMap<Integer, String> itemNumbers) {
        this.itemNumbers = itemNumbers;
    }

    /**
     * Adds an item to the vending machine.
     *
     * @param itemName  the name of the item.
     * @param quantity  the quantity of the item.
     * @param price     the price of the item.
     * @param calories  the calorie content of the item.
     */
    public boolean addItem(String itemName, int quantity, double price, int calories) {
        if (quantity <= 0 || quantity > 10 || totalUnique >= 12) {
            return false;
        }
        for (Item item : itemSlots) {
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
     * Returns the item in the vending machine.
     *
     * @param slotNumber  the slot number of the item.
     * @return the item.
     */
    public Item getItem(int slotNumber) {
        if (slotNumber >= 0 && slotNumber < itemSlots.size()) {
            return itemSlots.get(slotNumber);
        }
        return null;
    }

    public CashBox getCashBox() {
        return Main.regularCashBox;
    }
    
    
}
