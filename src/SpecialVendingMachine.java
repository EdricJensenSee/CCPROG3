import java.util.ArrayList;
import java.util.HashMap;

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
        Item newItem = new Item(itemName, quantity, price, calories);

        itemSellableSlots.add(newItem);
        totalItems += quantity;
        totalUnique++;
        itemNumbers.put(count, itemName);
        return true;
    }
        
    public boolean addCustomItem(String itemName, int quantity, double price, int calories) {
        if (quantity <= 0 || quantity > 10 || totalUnique >= 12) {
            return false;
        }
        Item newItem = new Item(itemName, quantity, price, calories);

        itemCustomSlots.add(newItem);
        totalItems += quantity;
        totalUnique++;
        itemNumbers.put(count, itemName);
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

	public ArrayList<Item> getItemCustom() {
        return itemCustomSlots;
    }

    public ArrayList<Item> getItemSellable() {
        return itemSellableSlots;
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
        Item item = new Item(baseName, quantity, price, calories);
        itemCustomSlots.add(item);
    }

    public void addSecondPart(String fillingName, int quantity, double price, int calories) {
        secondPart.add(fillingName);
        Item item = new Item(fillingName, quantity, price, calories);
        itemCustomSlots.add(item);
    }

    public void addThirdPart(String frostingName, int quantity, double price, int calories) {
        thirdPart.add(frostingName);
        Item item = new Item(frostingName, quantity, price, calories);
        itemCustomSlots.add(item);
    }

    public void addFourthPart(String toppingName, int quantity, double price, int calories) {
        fourthPart.add(toppingName);
        Item item = new Item(toppingName, quantity, price, calories);
        itemCustomSlots.add(item);
    }

    public int calculateTotalCalories(ArrayList<String> recipe) {
        int totalCalories = 0;
        for (int index = 0; index < recipe.size(); index++) {
            totalCalories += itemCustomSlots.get(index).getCalories();
        }
        return totalCalories;
    }
    
    public double calculateTotalPrice(ArrayList<String> recipe) {
        double totalPrice = 0;
        for (int index = 0; index < recipe.size(); index++) {
            totalPrice += itemCustomSlots.get(index).getPrice();
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

    public void setRecipes(ArrayList<ArrayList<String>> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<ArrayList<String>> getRecipes() {
        return recipes;
    }

    public CashBox getCashBox() {
        return Main.regularCashBox;
    }
}