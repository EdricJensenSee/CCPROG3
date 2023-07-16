import java.util.ArrayList;
import java.util.HashMap;

class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<ArrayList<String>> recipes;
    private ArrayList<String> recipeNames;

    public SpecialVendingMachine() {
        super();
        recipes = new ArrayList<>();
        recipeNames = new ArrayList<>();
    }

    public void addRecipe(ArrayList<String> recipe, String recipeName) {
        recipes.add(recipe);
        recipeNames.add(recipeName);
        }

    private int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (String itemName : recipe) {
            totalCalories += getItem().getItemCalories().get(itemName);
        }
        return totalCalories;
    }
    
    public void displayStock() {
        int number = 1;
        count = 0;
        totalUnique = 0;
        System.out.println("Items: ");
        for (String key : item.getItemQuantity().keySet()) {
            int quantity = item.getItemQuantity().get(key);
            double price = item.getItemPrice().get(key);
            int calories = item.getItemCalories().get(key);

            itemNumbers.put(number, key);

            System.out.println(number + ". " + key + " - Quantity: " + quantity + " - Price: ₱" + price + " - Calories: " + calories);
            count += quantity;
            totalUnique++;
            number++;
        }
        System.out.println("Recipes: ");
        for (int recipeCount = 0; recipeCount<recipeNames.size	(); recipeCount++) {
        	System.out.println(recipeNames.get(recipeCount));
            for (String itemName : recipes.get(recipeCount)) {
                System.out.print("- " + itemName + "\n");
            }
        }
        System.out.println("Current Total Items: " + count + " - Total Recipes: " + recipes.size());
    }
    
    public void prepareProduct(int productIndex, double amountPaid) {
        double totalPrice = 0;
        int requiredQuantity = 0;

        if (productIndex < 0 || productIndex >= recipes.size()) {
            System.out.print("Invalid Product");
            return;
        }

        for (String itemName : recipes.get(productIndex)) {
            if (item.getItemQuantity().containsKey(itemName)) {
            	requiredQuantity = itemUsedCount(recipes.get(productIndex), itemName);
                int stockQuantity = item.getItemQuantity().get(itemName);
                double itemPrice = item.getItemPrice().get(itemName);

                if (stockQuantity < requiredQuantity) {
                    System.out.println("Insufficient quantity of " + itemName + " in stock.");
                    return;
                }

                totalPrice += item.getItemPrice().get(itemName);
            } else {
                System.out.println("Item " + itemName + " not found in stock.");
                return;
            }
        }

        if (amountPaid < totalPrice) {
            System.out.println("Insufficient payment. Please insert ₱" + (totalPrice - amountPaid) + " more.");
            return;
        } else if (amountPaid > totalPrice) {
            double change = amountPaid - totalPrice;
            CashBox.dispenseChange(change);
        }

        for (String itemName : recipes.get(productIndex)) {
            int stockQuantity = item.getItemQuantity().get(itemName);

            item.getItemQuantity().put(itemName, stockQuantity - requiredQuantity);
            item.getItemSold().put(itemName, item.getItemSold().getOrDefault(itemName, 0) + requiredQuantity);
        }

        item.setTotalSales(item.getTotalSales() + totalPrice);

        System.out.print("Used: \n");
        for (String itemName : recipes.get(productIndex)) {
            System.out.print("- " + itemName + "\n");
        }
        System.out.println("\nPreparing Product " + recipeNames.get(productIndex) + " - Total Calories: " + calculateTotalCalories(recipes.get(productIndex)));
    }

    private int itemUsedCount(ArrayList<String> recipe, String itemName) {
        int count = 0;
        for (int i = 0; i< recipe.size();i++) {
        	if (recipe.get(i) == itemName)
        		count++;
        }
        return count;
    }


    public void setRecipes(ArrayList<ArrayList<String>> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<ArrayList<String>> getRecipes() {
        return recipes;
    }
}
