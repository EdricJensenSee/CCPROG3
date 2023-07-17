import java.util.HashMap;

public class CashBox {
    private static HashMap<Double, Integer> denominations;
    private double amountPaid = 0.0;
    
    public CashBox() {
        denominations = new HashMap<>();
    }

    public void displayDenominations() {
        for (HashMap.Entry<Double, Integer> denom : denominations.entrySet()) {
            double denomination = denom.getKey();
            int quantity = denom.getValue();
            System.out.println("₱" + denomination + " - Quantity: " + quantity);
        }
    }

    public void replenishChange(double denomination, int quantity) {
        int currentQuantity = denominations.getOrDefault(denomination, 0);
        denominations.put(denomination, currentQuantity + quantity);
    }

    private boolean isItemAvailable(Item item, String itemName) {
        if (item.getItemQuantity().getOrDefault(itemName, 0) <= 0) {
            System.out.println("Item not found in stock.");
            return false;
        }
        return true;
    }
    
    public void addTotalAmount(int amount) {
    	amountPaid+=amount;
    }
    
    public void deductTotalAmount(int amount) {
    	amountPaid-=amount;
    }
    
    public void resetAmountPaid() {
    	amountPaid = 0;
    }
    
    public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public static void dispenseChange(double change) {
        System.out.println("Providing change:");

        double[] availableDenominations = {1000.0, 500.0, 200.0, 100.0, 50.0, 20.0, 10.0, 5.0};
        int[] quantityOfDenom = new int[availableDenominations.length];

        for (int i = 0; i < availableDenominations.length; i++) {
            double denomination = availableDenominations[i];
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
            for (int i = 0; i < availableDenominations.length; i++) {
                double denomination = availableDenominations[i];
                if (quantityOfDenom[i] > 0) {
                    denominations.put(denomination, denominations.getOrDefault(denomination, 0) - quantityOfDenom[i]);
                }
            }
        } else {
            System.out.println("Sorry, the vending machine doesn't have enough change. Change returned.");
        }
    }
    
    public boolean receivePayment(Item item, String itemName, double amountPaid) {
        if (!isItemAvailable(item, itemName)) {
            return false;
        }

        double price = item.getItemPrice().getOrDefault(itemName, 0.0);

        if (amountPaid < price) {
            System.out.println("Insufficient payment. Please insert ₱" + (price - amountPaid) + " more.");
            return false;
        } else if (amountPaid > price) {
            double change = amountPaid - price;
            dispenseChange(change);
            item.getItemQuantity().put(itemName, item.getItemQuantity().get(itemName) - 1);
            item.getItemSold().put(itemName, item.getItemSold().getOrDefault(itemName, 0) + 1);
            item.setTotalSales(item.getTotalSales() + price);

            System.out.println("Dispensing " + itemName);
            System.out.println("Change: ₱" + (amountPaid - price));
            return true;
        } else {
            int calories = item.getItemCalories().getOrDefault(itemName, 0);
            item.getItemQuantity().put(itemName, item.getItemQuantity().get(itemName) - 1);
            item.getItemSold().put(itemName, item.getItemSold().getOrDefault(itemName, 0) + 1);
            item.setTotalSales(item.getTotalSales() + price);

            System.out.println("Dispensing " + itemName + " - Calories: " + calories);
            return true;
        }
    }	

    public void printReceipt(Item item) {
        System.out.println("Receipt:");
        for (String itemName : item.getItemSold().keySet()) {
            int quantitySold = item.getItemSold().get(itemName);
            System.out.println(itemName + " - Quantity Sold: " + quantitySold);
        }
        System.out.println("Total Sales: ₱" + item.getTotalSales());
    }
}
