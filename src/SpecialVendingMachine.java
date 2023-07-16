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
        for (int recipeCount = 0; recipeCount<recipeNames.size(); recipeCount++) {
        	System.out.println(recipeNames.get(recipeCount));
            for (String itemName : recipes.get(recipeCount)) {
                System.out.print("- " + itemName + "\n");
            }
        }
        System.out.println("Current Total Items: " + count + " - Total Recipes: " + recipes.size());
    }
    
    public void prepareProduct(int productIndex) {
    		if (productIndex < 0 || productIndex >= recipes.size()) {
    			System.out.print("Invalid Product");
    			return;
    		}
    			
            for (String itemName : recipes.get(productIndex)) {
                if (item.getItemQuantity().containsKey(itemName)) {
                    int stockQuantity = item.getItemQuantity().get(itemName);
                    if (stockQuantity > 0) {
                        item.getItemQuantity().put(itemName, stockQuantity - 1);
                    } else {
                        System.out.println("Insufficient quantity of " + itemName + " in stock.");
                        return;
                    }
                } else {
                    System.out.println("Item " + itemName + " not found in stock.");
                    return;
                }
            }
            System.out.print("Used: \n");
            for (String itemName :  recipes.get(productIndex)) {
                System.out.print("- " + itemName + "\n");
            }
            System.out.println("\nPreparing Product " + recipeNames.get(productIndex) + " - Total Calories: " + calculateTotalCalories(recipes.get(productIndex)));
    }


    public void setRecipes(ArrayList<ArrayList<String>> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<ArrayList<String>> getRecipes() {
        return recipes;
    }
}
