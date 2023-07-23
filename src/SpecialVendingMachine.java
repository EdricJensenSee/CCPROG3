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

	public String getFirstPart(int index) {
        if (index >= 0 && index < firstPart.size()) {
            return firstPart.get(index);
        } else {
            return null; 
        }
    }
    
    public String getItemSellableName(int index) {  
    	return Main.itemSpecial.getItemNumbers().get(index);
    }


	public String getSecondPart(int index) {
        if (index >= 0 && index < secondPart.size()) {
            return secondPart.get(index);
        } else {
            return null; 
        }
    }
    
    public String getThirdPart(int index) {
        if (index >= 0 && index < thirdPart.size()) {
            return thirdPart.get(index);
        } else {
            return null; 
        }
    }
    
    public String getFourthPart(int index) {
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
    
    public void addFirstPart(String baseName, int quantity, double price, int calories) {
        firstPart.add(baseName);
        Main.itemCustom.getItemQuantity().put(baseName, quantity);
        Main.itemCustom.getItemPrice().put(baseName, price);
        Main.itemCustom.getItemCalories().put(baseName, calories);
    }
    
    public void addSecondPart(String fillingName, int quantity, double price, int calories) {
        secondPart.add(fillingName);
        Main.itemCustom.getItemQuantity().put(fillingName, quantity);
        Main.itemCustom.getItemPrice().put(fillingName, price);
        Main.itemCustom.getItemCalories().put(fillingName, calories);
    }

    public void addThirdPart(String frostingName, int quantity, double price, int calories) {
        thirdPart.add(frostingName);
        Main.itemCustom.getItemQuantity().put(frostingName, quantity);
        Main.itemCustom.getItemPrice().put(frostingName, price);
        Main.itemCustom.getItemCalories().put(frostingName, calories);
    }
    
    public void addFourthPart(String toppingName, int quantity, double price, int calories) {
        fourthPart.add(toppingName);
        Main.itemCustom.getItemQuantity().put(toppingName, quantity);
        Main.itemCustom.getItemPrice().put(toppingName, price);
        Main.itemCustom.getItemCalories().put(toppingName, calories);
    }    
    
    public int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (String itemName : recipe) {
            totalCalories += getItem().getItemCalories().get(itemName);
        }
        return totalCalories;
    }
    
    public double calculateTotalPrice(ArrayList<String> recipe) {
        double totalPrice = 0.0;
        for (String itemName : recipe) {
            if ( Main.itemCustom.getItemPrice().containsKey(itemName)) {
                totalPrice +=  Main.itemCustom.getItemPrice().get(itemName);
            } else {
                System.out.println("Item " + itemName + " not found in stock.");
                return 0.0;
            }
        }
        return totalPrice;
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
                    return;
                }

                totalPrice +=  Main.itemCustom.getItemPrice().get(itemName);
            } else {
                return;
            }
        }
        if (amountPaid < totalPrice) {
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
    }

    private boolean isProductIndexValid(int productIndex) {
        if (productIndex < 0 || productIndex >= recipes.size()) {
            return false;
        }
        return true;
    }
       
    public int itemUsedCount(ArrayList<String> recipe, String itemName) {
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
