import java.util.ArrayList;

class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<ArrayList<String>> recipes;
    private ArrayList<String> recipeNames;
    private ArrayList<Item> itemCustomSlots;

    public SpecialVendingMachine() {
        super();
        Main.specialCashBox = new CashBox();
        recipes = new ArrayList<>();
        recipeNames = new ArrayList<>();
        itemCustomSlots = new ArrayList<>();
    }

    public boolean addCustomItem(String itemName, int quantity, double price, int calories) {
        if (quantity <= 0 || quantity > 10 || totalUnique >= 12) {
            return false;
        }
        for (Item item : itemCustomSlots) {
            if (item.getItemName().equals(itemName)) {
                item.setQuantity(quantity);
                item.setPrice(price);
                item.setCalories(calories);
                totalItems += (quantity - item.getQuantity()); 
                return true;
            }
        }
        Item newItem = new Item(itemName, quantity, price, calories);
        itemCustomSlots.add(newItem);
        totalItems += quantity;
        totalUnique++;
        return true;
    }

    public void addRecipe(ArrayList<String> recipe, String recipeName) {
        recipes.add(recipe);
        recipeNames.add(recipeName);
    }

    public void addPart(ArrayList<String> partList, String partName, int quantity, double price, int calories) {
        for (String existingPart : partList) {
            if (existingPart.equals(partName)) {
                Item existingItem = getItemCustomByName(partName);
                if (existingItem != null) {
                    existingItem.setQuantity(quantity);
                    existingItem.setPrice(price);
                    existingItem.setCalories(calories);
                    return;
                }
            }
        }

        partList.add(partName);
        Item newItem = new Item(partName, quantity, price, calories);
        itemCustomSlots.add(newItem);
    }

    public void addFirstPart(String baseName, int quantity, double price, int calories) {
        addPart(firstPart, baseName, quantity, price, calories);
    }

    public void addSecondPart(String fillingName, int quantity, double price, int calories) {
        addPart(secondPart, fillingName, quantity, price, calories);
    }

    public void addThirdPart(String frostingName, int quantity, double price, int calories) {
        addPart(thirdPart, frostingName, quantity, price, calories);
    }

    public void addFourthPart(String toppingName, int quantity, double price, int calories) {
        addPart(fourthPart, toppingName, quantity, price, calories);
    }

    public int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (String itemName : recipe) {
            Item item = getItemCustomByName(itemName);
            if (item != null) {
                totalCalories += item.getCalories();
            }
        }
        return totalCalories;
    }

    public double calculateTotalPrice(ArrayList<String> recipe) {
        double totalPrice = 0;
        for (String itemName : recipe) {
            Item item = getItemCustomByName(itemName);
            if (item != null) {
                totalPrice += item.getPrice();
            }
        }
        return totalPrice;
    }

    public boolean prepareProduct(int productIndex, double amountPaid) {
        double totalPrice = 0;
        int requiredQuantity;

        if (!isProductIndexValid(productIndex)) {
            return false;
        }

        ArrayList<String> recipe = recipes.get(productIndex);

        for (String itemName : recipe) {
            Item item = getItemCustomByName(itemName);
            if (item != null) {
                requiredQuantity = itemUsedCount(recipe, itemName);
                if (item.getQuantity() < requiredQuantity) {
                    return false;
                }
                totalPrice += item.getPrice();
            } else {
                return false;
            }
        }

        if (amountPaid < totalPrice) {
            return false;
        } else if (amountPaid > totalPrice) {
            double change = amountPaid - totalPrice;
            change = Math.round(change * 100.0) / 100.0;
            getCashBox().dispenseChange(change);
            System.out.println("Success. " + getCashBox().getDenominationsSpent());
        }

        for (String itemName : recipe) {
            requiredQuantity = itemUsedCount(recipe, itemName);
            getItemCustomByName(itemName).setQuantity(getItemCustomByName(itemName).getQuantity() - requiredQuantity);
            getItemCustomByName(itemName).setSold(getItemCustomByName(itemName).getSold() + requiredQuantity);
        }
        getCashBox().setTotalSales(getCashBox().getTotalSales() + totalPrice);
        return true;
    }

    private Item getItemCustomByName(String itemName) {
        for (Item item : itemCustomSlots) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    private int itemUsedCount(ArrayList<String> recipe, String itemName) {
        int count = 0;
        for (String item : recipe) {
            if (item.equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    private boolean isProductIndexValid(int productIndex) {
        if (productIndex < 0 || productIndex >= recipes.size()) {
            return false;
        }
        return true;
    }
}
