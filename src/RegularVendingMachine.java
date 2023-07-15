import java.util.*;

/**
* Represents the workings of the regular vending machine
*/ 
class RegularVendingMachine {
    private Item item;
    public int totalItems, totalUnique;
    private int count;
    public HashMap<Integer, String> itemNumbers;
    private HashMap<Double, Integer> denominations;

    /**
     * Constructs an instance of the RegularVendingMachine class.
     */
    public RegularVendingMachine() {
        item = new Item();
        itemNumbers = new HashMap<>();
        item.setItemQuantity(new HashMap<>());
        item.setItemPrice(new HashMap<>());
        item.setItemCalories(new HashMap<>());
        item.setItemSold(new HashMap<>());
        item.setTotalSales(0);
        denominations = new HashMap<>();
    }

    /**
     * Replenishes the change of the vending machine.
     *
     * @param denomination the denomination of the change.
     * @param quantity the quantity of the change.
     */
    public void replenishChange(double denomination, int quantity) {
        int currentQuantity;
        if (denominations.containsKey(denomination)) {
            currentQuantity = denominations.get(denomination);
            denominations.put(denomination, currentQuantity + quantity);
        } else {
            denominations.put(denomination, quantity);
        }
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
     * Displays the available denominations of change in the vending machine.
     */
    public void displayDenominations() {
        double denomination;
        int quantity;
        for (HashMap.Entry<Double, Integer> denom : denominations.entrySet()) {
            denomination = denom.getKey();
            quantity = denom.getValue();
            System.out.println("₱" + denomination + " - Quantity: " + quantity);
        }
    }

    /**
     * Receives payment for an item.
     *
     * @param itemName   the name of the item.
     * @param amountPaid the amount paid by the customer.
     * @return true if to signify a transaction stop, false when additional input is required.
     */
    public boolean receivePayment(String itemName, double amountPaid) {
        int quantity, calories;
        double[] available = {1000.0, 500.0, 200.0, 100.0, 50.0, 20.0, 10.0, 5.0};
        int[] quantityOfDenom = new int[available.length];
        double price, denomination, change;

        if (!item.getItemQuantity().containsKey(itemName)) {
            System.out.println("Item not found in stock.");
            return true;
        }

        quantity = item.getItemQuantity().get(itemName);
        price = item.getItemPrice().get(itemName);
        calories = item.getItemCalories().get(itemName);

        if (amountPaid < price) {
            System.out.println("Insufficient payment. Please insert ₱" + (price - amountPaid) + " more.");
            return false;
        } else if (amountPaid - price > 0) {
            change = amountPaid - price;
            System.out.println("Providing change: ");

            for (int i = 0; i < available.length; i++) {
                denomination = available[i];
                int num = (int) (change / denomination);
                if (num > 0) {
                    int numDispensed = Math.min(num, denominations.getOrDefault(denomination, 0));
                    if (numDispensed > 0) {
                        System.out.println(numDispensed + " ₱" + denomination + " coins/bills");
                        change -= numDispensed * denomination;
                        quantityOfDenom[i] = numDispensed;
                    }
                }
                if (change == 0) {
                    break;
                }
            }

            if (change == 0) {
                for (int i = 0; i < available.length; i++) {
                    denomination = available[i];
                    if (quantityOfDenom[i] > 0) {
                        denominations.put(denomination, denominations.getOrDefault(denomination, 0) - quantityOfDenom[i]);
                    }
                }

                item.getItemQuantity().put(itemName, quantity - 1);
                item.getItemSold().put(itemName, item.getItemSold().getOrDefault(itemName, 0) + 1);
                item.setTotalSales(item.getTotalSales() + price);

                System.out.println("Dispensing " + itemName);
                System.out.println("Change: ₱" + (amountPaid - price));
                return true;
            } else {
                System.out.println("Sorry, the vending machine doesn't have enough change. Change returned.");
                return true;
            }
        } else {
            if (quantity > 0) {
                item.getItemQuantity().put(itemName, quantity - 1);
                item.getItemSold().put(itemName, item.getItemSold().getOrDefault(itemName, 0) + 1);
                item.setTotalSales(item.getTotalSales() + price);

                System.out.println("Dispensing " + itemName + " - Calories: " + calories);
                return true;
            } else {
                System.out.println("Item out of stock.");
                return true;
            }
        }
    }

    /**
     * Prints the receipt showing the items sold and the total sales amount.
     */
    public void printReceipt() {
        int quantitySold;
        System.out.println("Receipt:");
        for (String key : item.getItemSold().keySet()) {
            quantitySold = item.getItemSold().get(key);
            System.out.println(key + " - Quantity Sold: " + quantitySold);
        }
        System.out.println("Total Sales: ₱" + item.getTotalSales());
    }

    /**
     * Returns the item in the vending machine.
     *
     * @return the item.
     */
    public Item getItem() {
        return item;
    }
}
