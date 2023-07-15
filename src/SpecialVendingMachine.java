import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the workings of the special vending machine
 */
class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<String> recipes;

    public SpecialVendingMachine() {
        super();
        recipes = new ArrayList<>();
    }

    private int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (String itemName : recipe) {
            totalCalories += getItem().getItemCalories().get(itemName);
        }
        return totalCalories;
    }

    public void setRecipes(ArrayList<String> recipe) {
        recipes = recipe;
    }

    public ArrayList<String> getRecipes() {
        return recipes;
    }
}
