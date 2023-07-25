/**
 * Represents an individual item in the vending machine.
 */
class Item {
    private String itemName;
    private int quantity;
    private double price;
    private int calories;
    private int sold;

    /**
     * Constructs an instance of the Item class.
     *
     * @param itemName  the name of the item.
     * @param quantity  the quantity of the item.
     * @param price     the price of the item.
     * @param calories  the calorie content of the item.
     */
    public Item(String itemName, int quantity, double price, int calories) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.calories = calories;
        this.sold = 0;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
