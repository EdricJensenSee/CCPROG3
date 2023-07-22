import java.util.ArrayList;
import java.util.HashMap;

class SpecialVendingMachine extends RegularVendingMachine {
    private ArrayList<ArrayList<String>> recipes;
    private ArrayList<String> recipeNames;
    private ArrayList<String> parts;
    private ArrayList<String> firstPart;
    private ArrayList<String> secondPart;
    private ArrayList<String> thirdPart;
    private ArrayList<String> fourthPart;


	public ArrayList<String> getParts() {
		return parts;
	}

	public void setParts(ArrayList<String> parts) {
		this.parts = parts;
	}

	public SpecialVendingMachine() {
        super();
        Main.itemSpecial = new Item();
        Main.itemCustom = new Item();
        parts = new ArrayList<>();
        recipes = new ArrayList<>();
        recipeNames = new ArrayList<>();
        firstPart = new ArrayList<>();
        secondPart = new ArrayList<>();
        thirdPart = new ArrayList<>();
        fourthPart = new ArrayList<>();
    }

    public ArrayList<String> getFirstPart() {
		return firstPart;
	}

	public void setFirstPart(ArrayList<String> firstPart) {
		this.firstPart = firstPart;
	}

	public ArrayList<String> getSecondPart() {
		return secondPart;
	}

	public void setSecondPart(ArrayList<String> secondPart) {
		this.secondPart = secondPart;
	}

	public ArrayList<String> getThirdPart() {
		return thirdPart;
	}

	public void setThirdPart(ArrayList<String> thirdPart) {
		this.thirdPart = thirdPart;
	}

	public ArrayList<String> getFourthPart() {
		return fourthPart;
	}

	public void setFourthPart(ArrayList<String> fourthPart) {
		this.fourthPart = fourthPart;
	}

	public String getCakeBaseName(int index) {
        if (index >= 0 && index < firstPart.size()) {
            return firstPart.get(index);
        } else {
            return null; 
        }
    }
    
    public String getItemSellableName(int index) {  
    	return Main.itemSpecial.getItemNumbers().get(index);
    }


	public String getFillingName(int index) {
        if (index >= 0 && index < secondPart.size()) {
            return secondPart.get(index);
        } else {
            return null; 
        }
    }
    
    public String getFrostingName(int index) {
        if (index >= 0 && index < thirdPart.size()) {
            return thirdPart.get(index);
        } else {
            return null; 
        }
    }
    
    public String getToppingName(int index) {
        if (index >= 0 && index < fourthPart.size()) {
            return fourthPart.get(index);
        } else {
            return null; 
        }
    }
    
	public Item getItemCustom() {
		return Main.itemCustom;
	}

	public Item getItemSellable() {
		return Main.itemSpecial;
	}

	public void setItemSellable(Item itemSellable) {
		 Main.itemSpecial = itemSellable;
	}

	public void setItemCustom(Item itemCustom) {
		 Main.itemCustom = itemCustom;
	}

    
    public void addRecipe(ArrayList<String> recipe, String recipeName) {
        recipes.add(recipe);
        recipeNames.add(recipeName);
        }
    
    public void addCakeBase(String baseName, int quantity, double price, int calories) {
        firstPart.add(baseName);
        Main.itemCustom.getItemQuantity().put(baseName, quantity);
        Main.itemCustom.getItemPrice().put(baseName, price);
        Main.itemCustom.getItemCalories().put(baseName, calories);
    }
    
    public void addFilling(String fillingName, int quantity, double price, int calories) {
        secondPart.add(fillingName);
        Main.itemCustom.getItemQuantity().put(fillingName, quantity);
        Main.itemCustom.getItemPrice().put(fillingName, price);
        Main.itemCustom.getItemCalories().put(fillingName, calories);
    }

    public void addFrosting(String frostingName, int quantity, double price, int calories) {
        thirdPart.add(frostingName);
        Main.itemCustom.getItemQuantity().put(frostingName, quantity);
        Main.itemCustom.getItemPrice().put(frostingName, price);
        Main.itemCustom.getItemCalories().put(frostingName, calories);
    }
    
    public void addTopping(String toppingName, int quantity, double price, int calories) {
        fourthPart.add(toppingName);
        Main.itemCustom.getItemQuantity().put(toppingName, quantity);
        Main.itemCustom.getItemPrice().put(toppingName, price);
        Main.itemCustom.getItemCalories().put(toppingName, calories);
    }    
    
    private int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (String itemName : recipe) {
            totalCalories += getItem().getItemCalories().get(itemName);
        }
        return totalCalories;
    }
    
    private double calculateTotalPrice(ArrayList<String> recipe) {
        double totalPrice = 0.0;
        for (String itemName : recipe) {
            if ( Main.itemCustom.getItemPrice().containsKey(itemName)) {
                totalPrice +=  Main.itemCustom.getItemPrice().get(itemName);
            } else {
                // Handle the case when an item is not found in itemCustom
                System.out.println("Item " + itemName + " not found in stock.");
                return 0.0;
            }
        }
        return totalPrice;
    }

    
    public void displayStock() {
        int number = 1;
        count = 0;
        totalUnique = 0;
        System.out.println("Items: ");
        for (String key :  Main.itemCustom.getItemQuantity().keySet()) {
            int quantity =  Main.itemCustom.getItemQuantity().get(key);
            double price =  Main.itemCustom.getItemPrice().get(key);
            int calories =  Main.itemCustom.getItemCalories().get(key);

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
            if ( Main.itemCustom.getItemQuantity().containsKey(itemName)) {
            	requiredQuantity = itemUsedCount(recipes.get(productIndex), itemName);

                if ( Main.itemCustom.getItemQuantity().get(itemName) < requiredQuantity) {
                    System.out.println("Insufficient quantity of " + itemName + " in stock.");
                    return;
                }

                totalPrice +=  Main.itemCustom.getItemPrice().get(itemName);
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

        	 Main.itemCustom.getItemQuantity().put(itemName,  Main.itemCustom.getItemQuantity().get(itemName) - requiredQuantity);
        	 Main.itemCustom.getItemSold().put(itemName,  Main.itemCustom.getItemSold().getOrDefault(itemName, 0) + requiredQuantity);
        }

        Main.itemCustom.setTotalSales( Main.itemCustom.getTotalSales() + totalPrice);

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
