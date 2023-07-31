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

        vendingMachine.prepareProduct(0, 40);
        
        for (int i = 0; i < vendingMachine.getRecipeNames().size(); i++) {
            String recipeName =  vendingMachine.getRecipeNames().get(i);
            ArrayList<String> recipe =  vendingMachine.getRecipes().get(i);

            System.out.println("Recipe Name: " + recipeName);
            System.out.println("Ingredients: " + recipe);
            System.out.println();
        }
    }
}
