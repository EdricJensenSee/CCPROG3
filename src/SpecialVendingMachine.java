import java.util.ArrayList;

class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<ArrayList<String>> recipes;
    private ArrayList<String> Parts;
    public ArrayList<String> getParts() {
		return Parts;
	}

	public void setParts(ArrayList<String> parts) {
		Parts = parts;
	}

	private ArrayList<String> recipeNames;
    private ArrayList<Item> itemSellableSlots;
    private ArrayList<Item> itemCustomSlots;
    private ArrayList<String> firstPart;
    private ArrayList<String> secondPart;
    private ArrayList<String> thirdPart;
    private ArrayList<String> fourthPart;

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
    
    public String getFirstPartName(int index) {
        if (index >= 0 && index < firstPart.size()) {
            return firstPart.get(index);
        } else {
            return null;
        }
    }

    public String getItemSellableName(int index) {
        return itemSellableSlots.get(index).getItemName();
    }

    public String getSecondPartName(int index) {
        if (index >= 0 && index < secondPart.size()) {
            return secondPart.get(index);
        } else {
            return null;
        }
    }

    public String getThirdPartName(int index) {
        if (index >= 0 && index < thirdPart.size()) {
            return thirdPart.get(index);
        } else {
            return null;
        }
    }

    public String getFourthPartName(int index) {
        if (index >= 0 && index < fourthPart.size()) {
            return fourthPart.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<String> getFirstPart() {
		return firstPart;
	}

	public ArrayList<String> getSecondPart() {
		return secondPart;
	}


	public ArrayList<String> getThirdPart() {
		return thirdPart;
	}

	public ArrayList<String> getFourthPart() {
		return fourthPart;
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
        itemSlots.add(newItem);
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
            if (Main.specialVendingMachine.getItemCustomByName(itemName) != null) {
            	totalCalories += Main.specialVendingMachine.getItemCustomByName(itemName).getCalories();
            }
        }
        return totalCalories;
    }
    
    public double calculateTotalPrice(ArrayList<String> recipe) {
        double totalPrice = 0;
        for (String itemName : recipe) {
            if (Main.specialVendingMachine.getItemCustomByName(itemName) != null) {
                totalPrice += Main.specialVendingMachine.getItemCustomByName(itemName).getPrice();
            }
        }
        return totalPrice;
    }

    public ArrayList<Item> getItemSellableSlots() {
		return itemSellableSlots;
	}

	public void setItemSellableSlots(ArrayList<Item> itemSellableSlots) {
		this.itemSellableSlots = itemSellableSlots;
	}

	public ArrayList<Item> getItemCustomSlots() {
		return itemCustomSlots;
	}

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

    public Item getItemSellableByName(String itemName) {
        for (Item item : itemCustomSlots) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    public Item getItemCustomByName(String itemName) {
        for (Item item : itemCustomSlots) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    private boolean isProductIndexValid(int productIndex) {
        if (productIndex < 0 || productIndex >= recipes.size()) {
            return false;
        }
        return true;
    }

    public int itemUsedCount(ArrayList<String> recipe, String itemName) {
        int count = 0;
        for (String item : recipe) {
            if (item.equals(itemName))
                count++;
        }
        return count;
    }

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

    public void setRecipes(ArrayList<ArrayList<String>> recipes) {
        this.recipes = recipes;	
    }

    public ArrayList<String> getRecipeNames() {
		return recipeNames;
	}

	public void setRecipeNames(ArrayList<String> recipeNames) {
		this.recipeNames = recipeNames;
	}

	public ArrayList<ArrayList<String>> getRecipes() {
        return recipes;
    }

    public CashBox getCashBox() {
        return Main.specialCashBox;
    }
}