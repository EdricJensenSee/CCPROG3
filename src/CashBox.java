import java.util.HashMap;

class CashBox {
    private HashMap<Double, Integer> denominations;

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

    public boolean receivePayment(Item item, String itemName, double amountPaid) {
        int quantity = item.getItemQuantity().getOrDefault(itemName, 0);
        double price = item.getItemPrice().getOrDefault(itemName, 0.0);
        int calories = item.getItemCalories().getOrDefault(itemName, 0);

        if (quantity <= 0) {
            System.out.println("Item not found in stock.");
            return true;
        }

        if (amountPaid < price) {
            System.out.println("Insufficient payment. Please insert ₱" + (price - amountPaid) + " more.");
            return false;
        } else if (amountPaid > price) {
            double change = amountPaid - price;
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
            item.getItemQuantity().put(itemName, quantity - 1);
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
