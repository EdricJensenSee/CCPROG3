import java.util.ArrayList;

public class tester {

    public static void main(String[] args) {
    	
        SpecialVendingMachine vendingMachine = new SpecialVendingMachine();
        vendingMachine.addCustomItem("Noodles", 1, 10, 2);
        vendingMachine.addCustomItem("Chashu Pork", 2, 10, 2);
        vendingMachine.addCustomItem("Chashu Pork", 2, 10, 2);
        vendingMachine.addCustomItem("Tonkotsu Broth", 1, 10, 2);
        ArrayList<String> customRamenRecipe = new ArrayList<>();
        customRamenRecipe.add("Noodles");
        customRamenRecipe.add("Chashu Pork");
        customRamenRecipe.add("Chashu Pork");
        customRamenRecipe.add("Tonkotsu Broth");

        String productName = "Custom Ramen";
        vendingMachine.addRecipe(customRamenRecipe, productName);

        System.out.println(productName + " Recipe:");
        ArrayList<String> recipe = vendingMachine.getRecipeByName(productName);
        vendingMachine.prepareProduct(0, 40);
        
        if (recipe != null) {
            for (String itemName : recipe) {
                Item item = vendingMachine.getItemCustomByName(itemName);
                if (item != null) {
                    System.out.println("- " + item.getItemName());
                } else {
                    System.out.println("- Item not found: " + itemName);
                }
            }
        } else {
            System.out.println("Recipe not found: " + productName);
        }
    }
}
