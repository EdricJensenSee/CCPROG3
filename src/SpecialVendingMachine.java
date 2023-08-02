import java.util.ArrayList;

/**
Represents a special vending machine that extends the functionality of the regular vending machine.
*/
class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<ArrayList<String>> recipes;
    private ArrayList<String> Parts;
	private ArrayList<String> recipeNames;
    private ArrayList<Item> itemSellableSlots;
    private ArrayList<Item> itemCustomSlots;
    private ArrayList<String> firstPart;
    private ArrayList<String> secondPart;
    private ArrayList<String> thirdPart;
    private ArrayList<String> fourthPart;

    /**
    Constructs an instance of the SpecialVendingMachine class.
    */
    public SpecialVendingMachine() {
        super();
        Main.specialCashBox = new CashBox();
        itemSellableSlots = new ArrayList<>();
        itemCustomSlots = new ArrayList<>();
        recipes = new ArrayList<>();
        recipeNames = new ArrayList<>();
        Parts = new ArrayList<>();
        firstPart = new ArrayList<>();
        secondPart = new ArrayList<>();
        thirdPart = new ArrayList<>();
        fourthPart = new ArrayList<>(); 
    }

    /**
     * Adds a sellable item to the vending machine.
     * @param itemName  the name of the item.
     * @param quantity  the quantity of the item.
     * @param price     the price of the item.
     * @param calories  the calorie content of the item.
     * @return true if the item is added successfully, false otherwise.
     */
    public boolean addSellableItem(String itemName, int quantity, double price, int calories) {
        if (quantity <= 0 || quantity > 10 || totalUnique >= 12) {
            return false;
        }
        for (Item item : itemSellableSlots) {
            if (item.getItemName().equals(itemName)) {
                item.setQuantity(quantity);
                item.setPrice(price);
                item.setCalories(calories);
                totalItems += (quantity - item.getQuantity()); 
                return true;
            }
        }
        Item newItem = new Item(itemName, quantity, price, calories);
        itemSellableSlots.add(newItem);
        itemSlots.add(newItem);
        totalItems += quantity;
        totalUnique++;
        return true;
    }

    /**
     * Adds a custom item to the vending machine.
     * @param itemName  the name of the item.
     * @param quantity  the quantity of the item.
     * @param price     the price of the item.
     * @param calories  the calorie content of the item.
     * @return true if the item is added successfully, false otherwise.
     */
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
        itemSlots.add(newItem);
        totalItems += quantity;
        totalUnique++;
        return true;
    }
    
    /**
     * Gets the list of parts in the vending machine.
     * @return the list of parts.
     */
    public ArrayList<String> getParts() {
		return Parts;
	}

    /**
     * Sets the list of parts in the vending machine.
     * @param parts the list of parts to set.
     */
	public void setParts(ArrayList<String> parts) {
		Parts = parts;
	}
	
	/**
	 * Gets the name of the first part at the specified index.
	 * @param index the index of the part.
	 * @return the name of the first part at the specified index.
	 */
    public String getFirstPartName(int index) {
        if (index >= 0 && index < firstPart.size()) {
            return firstPart.get(index);
        } else {
            return null;
        }
    }

    /**
     * Gets the name of the sellable item at the specified index.
     * @param index the index of the sellable item.
     * @return the name of the sellable item at the specified index.
     */
    public String getItemSellableName(int index) {
        return itemSellableSlots.get(index).getItemName();
    }

    /**
     * Gets the name of the second part at the specified index.
     * @param index the index of the part.
     * @return the name of the second part at the specified index.
     */
    public String getSecondPartName(int index) {
        if (index >= 0 && index < secondPart.size()) {
            return secondPart.get(index);
        } else {
            return null;
        }
    }

    /**
     * Gets the name of the third part at the specified index.
     * @param index the index of the part.
     * @return the name of the third part at the specified index.
     */
    public String getThirdPartName(int index) {
        if (index >= 0 && index < thirdPart.size()) {
            return thirdPart.get(index);
        } else {
            return null;
        }
    }

    /**
     * Gets the name of the fourth part at the specified index.
     * @param index the index of the part.
     * @return the name of the fourth part at the specified index.
     */
    public String getFourthPartName(int index) {
        if (index >= 0 && index < fourthPart.size()) {
            return fourthPart.get(index);
        } else {
            return null;
        }
    }

    /**
     * Gets the list of the first part in the vending machine.
     * @return the list of the first part.
     */
    public ArrayList<String> getFirstPart() {
		return firstPart;
	}

    /**
     * Gets the list of the second part in the vending machine.
     * @return the list of the second part.
     */
    public ArrayList<String> getSecondPart() {
        return secondPart;
    }

    /**
     * Gets the list of the third part in the vending machine.
     * @return the list of the third part.
     */
    public ArrayList<String> getThirdPart() {
        return thirdPart;
    }

    /**
     * Gets the list of the fourth part in the vending machine.
     * @return the list of the fourth part.
     */
    public ArrayList<String> getFourthPart() {
        return fourthPart;
    }
    
    /**
     * Adds a recipe to the vending machine.
     * @param recipe     the list of items in the recipe.
     * @param recipeName the name of the recipe.
     */
    public void addRecipe(ArrayList<String> recipe, String recipeName) {
        recipes.add(recipe);
        recipeNames.add(recipeName);
    }

    /**
     * Adds a part to the vending machine.
     * @param partList   the list of parts to add the new part.
     * @param partName   the name of the part.
     * @param quantity   the quantity of the part.
     * @param price      the price of the part.
     * @param calories   the calorie content of the part.
     */
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
        itemSlots.add(newItem);
    }

    /**
     * Adds the first part to the vending machine.
     * @param baseName  the name of the base part.
     * @param quantity  the quantity of the part.
     * @param price     the price of the part.
     * @param calories  the calorie content of the part.
     */
    public void addFirstPart(String baseName, int quantity, double price, int calories) {
        addPart(firstPart, baseName, quantity, price, calories);
    }

    /**
     * Adds the second part to the vending machine.
     * @param fillingName  the name of the filling part.
     * @param quantity     the quantity of the part.
     * @param price        the price of the part.
     * @param calories     the calorie content of the part.
     */
    public void addSecondPart(String fillingName, int quantity, double price, int calories) {
        addPart(secondPart, fillingName, quantity, price, calories);
    }

    /**
     * Adds the third part to the vending machine.
     * @param frostingName  the name of the frosting part.
     * @param quantity      the quantity of the part.
     * @param price         the price of the part.
     * @param calories      the calorie content of the part.
     */
    public void addThirdPart(String frostingName, int quantity, double price, int calories) {
        addPart(thirdPart, frostingName, quantity, price, calories);
    }

    /**
     * Adds the fourth part to the vending machine.
     * @param toppingName  the name of the topping part.
     * @param quantity     the quantity of the part.
     * @param price        the price of the part.
     * @param calories     the calorie content of the part.
     */
    public void addFourthPart(String toppingName, int quantity, double price, int calories) {
        addPart(fourthPart, toppingName, quantity, price, calories);
    }

    /**
     * Calculates the total calories of a recipe.
     * @param recipe the list of items in the recipe.
     * @return the total calories of the recipe.
     */
    public int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (String itemName : recipe) {
            if (Main.specialVendingMachine.getItemCustomByName(itemName) != null) {
            	totalCalories += Main.specialVendingMachine.getItemCustomByName(itemName).getCalories();
            }
        }
        return totalCalories;
    }
    
    /**
     * Calculates the total price of a recipe.
     * @param recipe the list of items in the recipe.
     * @return the total price of the recipe.
     */
    public double calculateTotalPrice(ArrayList<String> recipe) {
        double totalPrice = 0;
        for (String itemName : recipe) {
            if (Main.specialVendingMachine.getItemCustomByName(itemName) != null) {
                totalPrice += Main.specialVendingMachine.getItemCustomByName(itemName).getPrice();
            }
        }
        return totalPrice;
    }

    /**
     * Gets the list of sellable item slots.
     *
     * @return The list of sellable item slots as an ArrayList of Item objects.
     */
    public ArrayList<Item> getItemSellableSlots() {
		return itemSellableSlots;
	}

    /**
     * Sets the list of sellable item slots.
     *
     * @param itemSellableSlots The list of sellable item slots as an ArrayList of Item objects.
     */
	public void setItemSellableSlots(ArrayList<Item> itemSellableSlots) {
		this.itemSellableSlots = itemSellableSlots;
	}

    /**
     * Gets the list of custom item slots.
     *
     * @return The list of custom item slots as an ArrayList of Item objects.
     */
	public ArrayList<Item> getItemCustomSlots() {
		return itemCustomSlots;
	}

    /**
     * Sets the list of custom item slots.
     *
     * @param itemCustomSlots The list of custom item slots as an ArrayList of Item objects.
     */
	public void setItemCustomSlots(ArrayList<Item> itemCustomSlots) {
		this.itemCustomSlots = itemCustomSlots;
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
	    }

	    for (String itemName : recipe) {
	        requiredQuantity = itemUsedCount(recipe, itemName);
	        Item item = getItemCustomByName(itemName);
	        if (item != null) {
	            item.setQuantity(item.getQuantity() - requiredQuantity);
	            item.setSold(item.getSold() + requiredQuantity);

	            if (item.getQuantity() == 0) {
	            	itemCustomSlots.remove(item);
	                getCashBox().getDeletedItems().add(item);
	            }
	        }
	    }

	    getCashBox().setTotalSales(getCashBox().getTotalSales() + totalPrice);
	    return true;
	}


    /**
     * Finds an item in the sellable slots by its name.
     *
     * @param itemName The name of the item to find.
     * @return The found item as an Item object, or null if not found.
     */
    public Item getItemSellableByName(String itemName) {
        for (Item item : itemCustomSlots) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Finds an item in the custom slots by its name.
     *
     * @param itemName The name of the item to find.
     * @return The found item as an Item object, or null if not found.
     */
    public Item getItemCustomByName(String itemName) {
        for (Item item : itemCustomSlots) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if the given product index is valid.
     *
     * @param productIndex The index of the product to check.
     * @return True if the index is valid, false otherwise.
     */
    private boolean isProductIndexValid(int productIndex) {
        if (productIndex < 0 || productIndex >= recipes.size()) {
            return false;
        }
        return true;
    }

    /**
     * Counts the occurrences of a specific item in a recipe.
     *
     * @param recipe   The recipe as an ArrayList of String objects.
     * @param itemName The name of the item to count.
     * @return The number of occurrences of the item in the recipe.
     */
    public int itemUsedCount(ArrayList<String> recipe, String itemName) {
        int count = 0;
        for (String item : recipe) {
            if (item.equals(itemName))
                count++;
        }
        return count;
    }

    /**
     * Finds the name of a recipe based on its ingredients.
     *
     * @param ingredients The list of ingredients as an ArrayList of String objects.
     * @return The name of the recipe that matches the ingredients, or "Custom Cake" if no match is found.
     */
    public String findRecipeNameByIngredients(ArrayList<String> ingredients) {
        for (int i = 0; i < Main.specialVendingMachine.getRecipes().size(); i++) {
            String recipeName = Main.specialVendingMachine.getRecipeNames().get(i);
            if (!recipeName.equals("Custom Cake")) { 
                ArrayList<String> recipe = Main.specialVendingMachine.getRecipes().get(i);
                if (recipe.containsAll(ingredients)) {
                    return recipeName;
                }
            }
        }
        return "Custom Cake"; 
    }

    /**
     * Sets the list of recipes for the special vending machine.
     *
     * @param recipes The list of recipes as an ArrayList of ArrayList of String objects.
     */
    public void setRecipes(ArrayList<ArrayList<String>> recipes) {
        this.recipes = recipes;	
    }

    /**
     * Gets the list of recipe names for the special vending machine.
     *
     * @return The list of recipe names as an ArrayList of String objects.
     */
    public ArrayList<String> getRecipeNames() {
        return recipeNames;
    }

    /**
     * Sets the list of recipe names for the special vending machine.
     *
     * @param recipeNames The list of recipe names as an ArrayList of String objects.
     */
    public void setRecipeNames(ArrayList<String> recipeNames) {
        this.recipeNames = recipeNames;
    }

    /**
     * Gets the list of recipes for the special vending machine.
     *
     * @return The list of recipes as an ArrayList of ArrayList of String objects.
     */
    public ArrayList<ArrayList<String>> getRecipes() {
        return recipes;
    }

    /**
     * Gets the cash box associated with the special vending machine.
     *
     * @return The CashBox object for the special vending machine.
     */
    public CashBox getCashBox() {
        return Main.specialCashBox;
    }
}