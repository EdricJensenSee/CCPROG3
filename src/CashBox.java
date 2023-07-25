import java.util.ArrayList;
import java.util.HashMap;

public class CashBox {
    private HashMap<Double, Integer> denominations;
    private ArrayList<Double> denominationsSpent;
    private double amountPaid = 0.0;
    private double totalSales;
    
    
    public CashBox() {
        denominations = new HashMap<>();
        denominationsSpent = new ArrayList<>();
        initializeDenominations();
        totalSales = 0.0;
    }

    private void initializeDenominations() {
        denominations.put(5.0, 0);  
        denominations.put(10.0, 0);  
        denominations.put(20.0, 0);  
        denominations.put(50.0, 0);  
        denominations.put(100.0, 0); 
    }
    

    public void replenishChange(double denomination, int quantity) {
        denominations.put(denomination, denominations.getOrDefault(denomination, 0) + quantity);
    }

    public boolean isItemAvailable(Item item) {
        if (item.getQuantity() <= 0) {
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
     * Resets the total sales amount.
     */
    public void resetTotalSales() {
        totalSales = 0.0;
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
    
	public boolean receivePayment(ArrayList<Item> items, String itemName, double amountPaid) {
	    Item item = getItemByName(items, itemName);
	    if (item == null) {
	        return false; 
	    }
	    
	    if (item.getQuantity() <= 0)
	    	return false;
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
	        System.out.println("Dispensing " + itemName);
	        System.out.println("Change: ₱" + (amountPaid - price));
	        setTotalSales(getTotalSales() + price);
	        return true;
	    } else {
	        int calories = item.getCalories();
	        item.setQuantity(item.getQuantity() - 1);
	        item.setSold(item.getSold() + 1);
	        System.out.println("Dispensing " + itemName + " - Calories: " + calories);
	        setTotalSales(getTotalSales() + price);
	        return true;
	    }
	}

	private Item getItemByName(ArrayList<Item> items, String itemName) {
	    for (Item item : items) {
	        if (item.getItemName().equals(itemName)) {
	            return item;
	        }
	    }
	    return null; 
	}


    public ArrayList<Double> getDenominationsSpent() {
		return denominationsSpent;
	}

	public void setDenominationsSpent(ArrayList<Double> denominationsSpent) {
		this.denominationsSpent = denominationsSpent;
	}
}
