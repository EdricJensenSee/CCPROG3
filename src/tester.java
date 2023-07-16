import java.util.ArrayList;

public class tester {
    public static void main(String[] args) {
        SpecialVendingMachine vendingMachine = new SpecialVendingMachine();
        vendingMachine.getItem().addItem("Chocolate Chip Cookies", 2, 80, 180);
        vendingMachine.getItem().addItem("Cream Filling", 6, 10, 200);
        vendingMachine.getItem().addItem("Frosting", 8, 10, 150);
        vendingMachine.getItem().addItem("Cake", 5, 200, 250);
        vendingMachine.getItem().addItem("Chocolate", 10, 50, 220);
        vendingMachine.getItem().addItem("Vanilla", 8, 20, 210);
        vendingMachine.getItem().addItem("Cream Puffs", 6, 30, 180);
        vendingMachine.getItem().addItem("Strawberry", 10, 120, 190);
        
        vendingMachine.getCashBox().replenishChange(1.0, 1);
        vendingMachine.getCashBox().replenishChange(5.0, 1);
        vendingMachine.getCashBox().replenishChange(10.0, 1);
        vendingMachine.getCashBox().replenishChange(20.0, 1);
        vendingMachine.getCashBox().replenishChange(50.0, 1);
        vendingMachine.getCashBox().replenishChange(100.0, 1);
        vendingMachine.getCashBox().replenishChange(200.0, 1);
        vendingMachine.getCashBox().replenishChange(500.0, 1);
        vendingMachine.getCashBox().replenishChange(1000.0, 1);

        /*ArrayList<String> recipe1 = new ArrayList<>();
        recipe1.add("Chocolate Chip Cookies");
        recipe1.add("Chocolate");
        vendingMachine.addRecipe(recipe1, "Hotdog");

        ArrayList<String> recipe2 = new ArrayList<>();
        recipe2.add("Cake");
        recipe2.add("Frosting");
        recipe2.add("Cream Filling");
        vendingMachine.addRecipe(recipe2, "Chicken");*/

        ArrayList<String> recipe3 = new ArrayList<>();
        recipe3.add("Chocolate Chip Cookies");
        recipe3.add("Chocolate Chip Cookies");
        recipe3.add("Cream Filling");
        vendingMachine.addRecipe(recipe3, "Sausage");

        //vendingMachine.prepareProduct(2, 100); 
        //vendingMachine.prepareProduct(1, 300); 
        vendingMachine.prepareProduct(0,200);
        vendingMachine.getCashBox().printReceipt(vendingMachine.getItem());
        //vendingMachine.displayStock();
    }
}