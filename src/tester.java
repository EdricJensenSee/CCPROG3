import java.util.ArrayList;

public class tester {

	public static void main(String[] args) {
	    SpecialVendingMachine vendingMachine = new SpecialVendingMachine();
	    vendingMachine.getItem().addItem("Chocolate Chip Cookies", 10, 80, 180);
	    vendingMachine.getItem().addItem("Cream Filling", 6, 10, 200);
	    vendingMachine.getItem().addItem("Frosting", 8, 10, 150);
	    vendingMachine.getItem().addItem("Cake", 5, 200, 250);
	    vendingMachine.getItem().addItem("Chocolate", 10, 50, 220);
	    vendingMachine.getItem().addItem("Vanilla", 8, 20, 210);
	    vendingMachine.getItem().addItem("Cream Puffs", 6, 30, 180);
	    vendingMachine.getItem().addItem("Strawberry", 10, 120, 190);
	    
	    ArrayList<String> recipe1 = new ArrayList<>();
	    recipe1.add("Chocolate Chip Cookies");
	    recipe1.add("Chocolate");
	    vendingMachine.setRecipes(recipe1);

	    vendingMachine.prepareProduct("Cookies");

	    ArrayList<String> recipe2 = new ArrayList<>();
	    recipe2.add("Cream Filling");
	    recipe2.add("Cream Puffs");
	    vendingMachine.setRecipes(recipe2);

	    vendingMachine.prepareProduct("Cake");
	    
	    vendingMachine.prepareProduct("Cookies");
	}


}


