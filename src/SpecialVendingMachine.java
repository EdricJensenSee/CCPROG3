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

    public void prepareProduct(int productIndex) {
        if (productIndex >= 0 && productIndex < recipes.size()) {
            ArrayList<String> recipe = recipes.get(productIndex);
            HashMap<String, Integer> itemStock = getItem().getItemQuantity();

            for (String itemName : recipe) {
                if (itemStock.containsKey(itemName)) {
                    int stockQuantity = itemStock.get(itemName);
                    if (stockQuantity > 0) {
                        itemStock.put(itemName, stockQuantity - 1);
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
            for (String itemName : recipe) {
                System.out.print("- " + itemName + "\n");
            }
            ;
            System.out.println("\nPreparing Product " + recipeNames.get(productIndex) + " - Total Calories: " + calculateTotalCalories(recipe));
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void setRecipes(ArrayList<ArrayList<String>> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<ArrayList<String>> getRecipes() {
        return recipes;
    }
}
