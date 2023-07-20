import java.util.ArrayList;
import java.util.HashMap;

class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<ArrayList<String>> recipes;
    private ArrayList<String> recipeNames;
    private Item itemSellable;
    private Item itemCustom;
    private HashMap<Integer, String> itemSellableNumbers;
    private ArrayList<String> cakeBases;
    private ArrayList<String> fillings;
    private ArrayList<String> frostings;
    private ArrayList<String> toppings;


    public SpecialVendingMachine() {
        super();
        itemSellable = new Item();
        itemCustom = new Item();
        itemSellableNumbers = new HashMap<>();
        recipes = new ArrayList<>();
        recipeNames = new ArrayList<>();
        cakeBases = new ArrayList<>();
        fillings = new ArrayList<>();
        frostings = new ArrayList<>();
        toppings = new ArrayList<>();
    }

    public ArrayList<String> getCakeBases() {
        return cakeBases;
    }

    public ArrayList<String> getFillings() {
        return fillings;
    }

    public ArrayList<String> getFrostings() {
        return frostings;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }
    
    public HashMap<Integer, String> getItemSellableNumbers() {
		return itemSellableNumbers;
	}

	public void setItemSellableNumbers(HashMap<Integer, String> itemSellableNumbers) {
		this.itemSellableNumbers = itemSellableNumbers;
	}

	public Item getItemCustom() {
		return itemCustom;
	}

	public Item getItemSellable() {
		return itemSellable;
	}

	public void setItemSellable(Item itemSellable) {
		this.itemSellable = itemSellable;
	}

	public void setItemCustom(Item itemCustom) {
		this.itemCustom = itemCustom;
	}

	public void addCakeBase(String baseName) {
        cakeBases.add(baseName);
    }

    public void addFilling(String fillingName) {
        fillings.add(fillingName);
    }

    public void addFrosting(String frostingName) {
        frostings.add(frostingName);
    }

    public void addTopping(String toppingName) {
        toppings.add(toppingName);
    }
    
    public void addRecipe(ArrayList<String> recipe, String recipeName) {
        recipes.add(recipe);
        recipeNames.add(recipeName);
        }
    
    public void addCakeBase(String baseName, int quantity, double price, int calories) {
        cakeBases.add(baseName);
        itemCustom.getItemQuantity().put(baseName, quantity);
        itemCustom.getItemPrice().put(baseName, price);
        itemCustom.getItemCalories().put(baseName, calories);
    }
    
    public void addFilling(String fillingName, int quantity, double price, int calories) {
        fillings.add(fillingName);
        itemCustom.getItemQuantity().put(fillingName, quantity);
        itemCustom.getItemPrice().put(fillingName, price);
        itemCustom.getItemCalories().put(fillingName, calories);
    }

    public void addFrosting(String frostingName, int quantity, double price, int calories) {
        frostings.add(frostingName);
        itemCustom.getItemQuantity().put(frostingName, quantity);
        itemCustom.getItemPrice().put(frostingName, price);
        itemCustom.getItemCalories().put(frostingName, calories);
    }
    
    public void addTopping(String toppingName, int quantity, double price, int calories) {
        toppings.add(toppingName);
        itemCustom.getItemQuantity().put(toppingName, quantity);
        itemCustom.getItemPrice().put(toppingName, price);
        itemCustom.getItemCalories().put(toppingName, calories);
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
        for (String key : itemCustom.getItemQuantity().keySet()) {
            int quantity = itemCustom.getItemQuantity().get(key);
            double price = itemCustom.getItemPrice().get(key);
            int calories = itemCustom.getItemCalories().get(key);

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

        if (!isProductIndexValid(productIndex)) {
            return;
        }

        for (String itemName : recipes.get(productIndex)) {
            if (itemCustom.getItemQuantity().containsKey(itemName)) {
            	requiredQuantity = itemUsedCount(recipes.get(productIndex), itemName);

                if (itemCustom.getItemQuantity().get(itemName) < requiredQuantity) {
                    System.out.println("Insufficient quantity of " + itemName + " in stock.");
                    return;
                }

                totalPrice += itemCustom.getItemPrice().get(itemName);
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
            getCashBox().dispenseChange(change);
        }

        for (String itemName : recipes.get(productIndex)) {

        	itemCustom.getItemQuantity().put(itemName, itemCustom.getItemQuantity().get(itemName) - requiredQuantity);
        	itemCustom.getItemSold().put(itemName, itemCustom.getItemSold().getOrDefault(itemName, 0) + requiredQuantity);
        }

        itemCustom.setTotalSales(itemCustom.getTotalSales() + totalPrice);

        displayUsedItems(productIndex);
    }

    private boolean isProductIndexValid(int productIndex) {
        if (productIndex < 0 || productIndex >= recipes.size()) {
            System.out.print("Invalid Product");
            return false;
        }
        return true;
    }
    
    private void displayUsedItems(int productIndex) {
        System.out.print("Used: \n");
        for (String itemName : recipes.get(productIndex)) {
            System.out.print("- " + itemName + "\n");
        }
        
        
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
