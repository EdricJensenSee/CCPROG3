import java.util.*;


 /**
 * The Driver class
 */ 
public class Main {
    public static SpecialVendingMachine specialVendingMachine;
    public static RegularVendingMachine regularVendingMachine = new RegularVendingMachine();
    public static Item itemRegular;
    public static Item itemSpecial; 
    public static Item itemCustom; 
    public static CashBox regularCashBox;
    public static CashBox specialCashBox;
/** 
 * The Driver class
 * @param args the args. 
 */
    public static void main(String[] args) { 
    	//Test Values  
    	try {
    	    regularVendingMachine.addItem("Chocolate Chip Cookie", 1, 80, 180);
    	    regularVendingMachine.addItem("Chocolate Bar", 2, 40, 160);
    	    regularVendingMachine.addItem("Cream Cookie", 9, 20, 200);
    	    regularVendingMachine.addItem("Chocolate Muffin", 3, 30, 220);
    	    regularVendingMachine.addItem("Fresh Berry", 7, 70, 250);
    	    regularVendingMachine.addItem("Walnut Brownie", 6, 40, 230);
    	    regularVendingMachine.addItem("Blueberry Muffin", 10, 30, 190);
    	    regularVendingMachine.addItem("Banana Muffin", 4, 30, 210);

         	regularVendingMachine.getCashBox().getMoney()[0].replenish(1);   
         	regularVendingMachine.getCashBox().getMoney()[1].replenish(1);   
         	regularVendingMachine.getCashBox().getMoney()[2].replenish(1);   
         	regularVendingMachine.getCashBox().getMoney()[3].replenish(1);  
         	regularVendingMachine.getCashBox().getMoney()[4].replenish(1);   
    	} catch (NullPointerException e) {
    		System.out.println("No regular machine test values added");
    	}
    	
    	try {
        	specialVendingMachine.addSellableItem("Kitkats", 3, 35, 100);
    	    specialVendingMachine.addSellableItem("Cookies", 4, 20, 200);
    	    specialVendingMachine.addSellableItem("Cupcake", 2, 50, 180);
    	    specialVendingMachine.addSellableItem("Muffin", 5, 45, 200);
    	    specialVendingMachine.addFirstPart("Chocolate Cake", 8, 400, 450);
    	    specialVendingMachine.addFirstPart("Vanilla Cake", 8, 350, 600);
    	    specialVendingMachine.addFirstPart("Strawberry Cake", 8, 500, 400);
    	    specialVendingMachine.addSecondPart("Cream Filling", 1, 150, 180);
    	    specialVendingMachine.addSecondPart("Cream Cheese Filling", 10, 125, 220);
    	    specialVendingMachine.addSecondPart("Chocolate Filling", 10, 135, 140);
    	    specialVendingMachine.addThirdPart("Cream Frosting", 10, 120, 60);
    	    specialVendingMachine.addThirdPart("Chocolate Frosting", 10, 125, 80);
    	    specialVendingMachine.addFourthPart("Strawberry", 8, 20, 30);
    	    specialVendingMachine.addFourthPart("Kitkat", 8, 30, 100);
    	    specialVendingMachine.addFourthPart("Cookie", 8, 20, 70);
    	    
            ArrayList<String> recipe = new ArrayList<>();
            recipe.add("Chocolate Cake");
            recipe.add("Chocolate Filling");
            recipe.add("Chocolate Frosting");
            recipe.add("Kitkat");
            specialVendingMachine.addRecipe(recipe, "Supreme Choco");
            recipe = new ArrayList<>();
            recipe.add("Vanilla Cake");
            recipe.add("Cream Filling");
            recipe.add("Cream Frosting");
            recipe.add("Strawberry");
            
            specialVendingMachine.addRecipe(recipe, "Creamy Goodness");
            specialVendingMachine.getParts().add("Cake Base");
            specialVendingMachine.getParts().add("Fillings");
            specialVendingMachine.getParts().add("Frostings");
            specialVendingMachine.getParts().add("Toppings");
            specialVendingMachine.getCashBox().getMoney()[0].replenish(100); 
            specialVendingMachine.getCashBox().getMoney()[1].replenish(1);   
            specialVendingMachine.getCashBox().getMoney()[2].replenish(1);   
        	specialVendingMachine.getCashBox().getMoney()[3].replenish(1);  
         	specialVendingMachine.getCashBox().getMoney()[4].replenish(1);
    	} catch (NullPointerException e) {
    		System.out.println("No special machine test values added");
    	}
    	MainPageView mainPageView = new MainPageView();
    	new Controller(mainPageView);
    	mainPageView.setVisible(true);   
    }
}
	
