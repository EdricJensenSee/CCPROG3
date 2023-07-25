import java.util.ArrayList;

public class CashBox {
    private Money[] money;
    private ArrayList<Double> denominationsSpent;
    private double amountPaid = 0.0;
    private double totalSales;

    public CashBox() {
        money = new Money[]{new Money(5, 0), new Money(10, 0), new Money(20, 0), new Money(50, 0), new Money(100, 0)};
        denominationsSpent = new ArrayList<>();
        totalSales = 0.0;
    }

    public boolean isItemAvailable(Item item) {
        return item.getQuantity() > 0;
    }

    public void addTotalAmount(double amount) {
        amountPaid += amount;
    }

    public void deductTotalAmount(double amount) {
        amountPaid -= amount;
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

    public Money[] getMoney() {
        return money;
    }

    public void setMoney(Money[] money) {
        this.money = money;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public void resetTotalSales() {
        totalSales = 0.0;
    }

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


    public boolean receivePayment(ArrayList<Item> items, String itemName, double amountPaid) {
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
        } else {
            item.setQuantity(item.getQuantity() - 1);
            item.setSold(item.getSold() + 1);
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
