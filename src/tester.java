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
        vendingMachine.addRecipe(recipe1, "Hotdog");

        ArrayList<String> recipe2 = new ArrayList<>();
        recipe2.add("Cake");
        recipe2.add("Frosting");
        recipe2.add("Cream Filling");
        vendingMachine.addRecipe(recipe2, "Chicken");

        ArrayList<String> recipe3 = new ArrayList<>();
        recipe3.add("Chocolate Chip Cookies");
        recipe3.add("Cream Filling");
        vendingMachine.addRecipe(recipe3, "Sausage");

        vendingMachine.prepareProduct(2); 
        vendingMachine.prepareProduct(1); 
        vendingMachine.prepareProduct(41);
        //vendingMachine.displayStock();
    }
}