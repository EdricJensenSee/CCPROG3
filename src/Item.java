import java.util.HashMap;

/**
 * Represents an item in a vending machine.
 */
class Item {
    private HashMap<String, Integer> itemQuantity;
    private HashMap<String, Double> itemPrice;
    private HashMap<String, Integer> itemCalories;
    private HashMap<String, Integer> itemSold;
    private double totalSales;
    private int totalItems;
    private int totalUnique;

    /**
     * Constructs an instance of the Item class.
     */
    public Item() {
        itemQuantity = new HashMap<>();
        itemPrice = new HashMap<>();
        itemCalories = new HashMap<>();
        itemSold = new HashMap<>();
        totalSales = 0.0;
        totalItems = 0;
        totalUnique = 0;
    }

    /**
     * Adds an item to the vending machine.
     *
     * @param itemName  the name of the item.
     * @param quantity  the quantity of the item.
     * @param price     the price of the item.
     * @param calories  the calorie content of the item.
     */
    public void addItem(String itemName, int quantity, double price, int calories) {
        if (quantity <= 0 || quantity > Main.CAPACITY_PER_SLOT) {
            System.out.println("Invalid quantity. Please stock between 1 and " + Main.CAPACITY_PER_SLOT + " items.");
            return;
        }
        itemQuantity.put(itemName, quantity);
        itemPrice.put(itemName, price);
        itemCalories.put(itemName, calories);
        itemSold.put(itemName, 0);
        totalItems += quantity;
        totalUnique++;
    }

    /**
     * Sets the price of an item.
     *
     * @param itemName  the name of the item.
     * @param price     the new price of the item.
     */
    public void setItemPrice(String itemName, double price) {
        if (itemPrice.containsKey(itemName)) {
            itemPrice.put(itemName, price);
        } else {
            System.out.println("Item not found in stock.");
        }
    }

    /**
     * Resets the count of items sold for each item.
     */
    public void resetItemSold() {
        for (String itemName : itemSold.keySet()) {
            itemSold.put(itemName, 0);
        }
    }

    /**
     * Resets the total sales amount.
     */
    public void resetTotalSales() {
        totalSales = 0.0;
    }

    /**
     * Returns the item quantity <itemName, quantity> HashMap.
     *
     * @return the item quantity <itemName, quantity> HashMap.
     */
    public HashMap<String, Integer> getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Sets the item quantity <itemName, quantity> HashMap.
     *
     * @param itemQuantity the new item quantity <itemName, quantity> HashMap to set.
     */
    public void setItemQuantity(HashMap<String, Integer> itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * Returns the item price <itemName, price> HashMap.
     *
     * @return the item price <itemName, price> HashMap.
     */
    public HashMap<String, Double> getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the item price <itemName, price> HashMap.
     *
     * @param itemPrice the new item price <itemName, price> HashMap to set.
     */
    public void setItemPrice(HashMap<String, Double> itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Returns the item calories <itemName, calories> HashMap.
     *
     * @return the item calories <itemName, calories> HashMap.
     */
    public HashMap<String, Integer> getItemCalories() {
        return itemCalories;
    }

    /**
     * Sets the item calories <itemName, calories> HashMap.
     *
     * @param itemCalories  the new item calories <itemName, calories> to set.
    

 */
    public void setItemCalories(HashMap<String, Integer> itemCalories) {
        this.itemCalories = itemCalories;
    }

    /**
     * Returns the item sold <itemName, quantity sold> HashMap.
     *
     * @return the item sold <itemName, quantity sold> HashMap.
     */
    public HashMap<String, Integer> getItemSold() {
        return itemSold;
    }

    /**
     * Sets the item sold <itemName, quantity sold> HashMap.
     *
     * @param itemSold  the new item sold <itemName, quantity sold> HashMap to set.
     */
    public void setItemSold(HashMap<String, Integer> itemSold) {
        this.itemSold = itemSold;
    }

    /**
     * Returns the total sales.
     *
     * @return the total sales.
     */
    public double getTotalSales() {
        return totalSales;
    }

    /**
     * Sets the total sales amount.
     *
     * @param totalSales  the new total sales amount to set.
     */
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * Returns the total number of items in the vending machine.
     *
     * @return the total number of items.
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Sets the total number of items in the vending machine.
     *
     * @param totalItems  the new total number of items to set.
     */
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Returns the total number of unique items in the vending machine.
     *
     * @return the total number of unique items.
     */
    public int getTotalUnique() {
        return totalUnique;
    }

    /**
     * Sets the total number of unique items in the vending machine.
     *
     * @param totalUnique  the new total number of unique items to set.
     */
    public void setTotalUnique(int totalUnique) {
        this.totalUnique = totalUnique;
    }
}
