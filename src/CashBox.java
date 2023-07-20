import java.util.ArrayList;
import java.util.HashMap;

public class CashBox {
    private HashMap<Double, Integer> denominations;
    private ArrayList<Double> denominationsSpent;
    private double amountPaid = 0.0;
    
    
    public CashBox() {
        denominations = new HashMap<>();
        denominationsSpent = new ArrayList<>();
        initializeDenominations();
    }

    private void initializeDenominations() {
        denominations.put(5.0, 0);  
        denominations.put(10.0, 0);  
        denominations.put(20.0, 0);  
        denominations.put(50.0, 0);  
        denominations.put(100.0, 0); 
    }
    
    public void displayDenominations() {
        for (HashMap.Entry<Double, Integer> denom : denominations.entrySet()) {
            double denomination = denom.getKey();
            int quantity = denom.getValue();
            System.out.println("₱" + denomination + " - Quantity: " + quantity);
        }
    }

    public void replenishChange(double denomination, int quantity) {
        denominations.put(denomination, denominations.getOrDefault(denomination, 0) + quantity);
    }

    public boolean isItemAvailable(Item item, String itemName) {
        if (item.getItemQuantity().getOrDefault(itemName, 0) <= 0) {
            System.out.println("Item not found in stock.");
            return false;
        }
        return true;
    }
    
    public HashMap<Double, Integer> getDenominations() {
		return denominations;
	}

	public void setDenominations(HashMap<Double, Integer> denominations) {
		this.denominations = denominations;
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

	public boolean dispenseChange(double change) {
	    double[] availableDenominations = {1000.0, 500.0, 200.0, 100.0, 50.0, 20.0, 10.0, 5.0};
	    int[] quantityOfDenom = new int[availableDenominations.length];

	    for (int i = 0; i < availableDenominations.length; i++) {
	        double denomination = availableDenominations[i];
	        int num = (int) (change / denomination);
	        if (num > 0) {
	            int numDispensed = Math.min(num, denominations.getOrDefault(denomination, 0));
	            for (int j = 0; j < numDispensed; j++) {
	                change -= denomination;
	                quantityOfDenom[i]++;
	                denominationsSpent.add(denomination);
	            }
	        }
	        if (change == 0) {
	            break;
	        }
	    }
	    System.out.print(denominationsSpent);
	    if (change == 0) {
	        for (int i = 0; i < availableDenominations.length; i++) {
	            double denomination = availableDenominations[i];
	            if (quantityOfDenom[i] > 0) {
	                denominations.put(denomination, denominations.getOrDefault(denomination, 0) - quantityOfDenom[i]);
	            }
	        }
	       return true;
	    } else {
	        denominationsSpent.clear();
	        return false;
	    }
	}
    
    public boolean receivePayment(Item item, String itemName, double amountPaid) {
        if (!isItemAvailable(item, itemName)) {
            return false;
        }

        double price = item.getItemPrice().getOrDefault(itemName, 0.0);

        if (amountPaid < price) {
            return false;
        } else if (amountPaid > price) {
            double change = amountPaid - price;
            if(!dispenseChange(change))
            	return false;
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

    public ArrayList<Double> getDenominationsSpent() {
		return denominationsSpent;
	}

	public void setDenominationsSpent(ArrayList<Double> denominationsSpent) {
		this.denominationsSpent = denominationsSpent;
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
