import java.util.*;


 /**
 * The Main class
 */ 
public class Main {
    public static SpecialVendingMachine specialVendingMachine;
    public static RegularVendingMachine regularVendingMachine;
    public static Item itemRegular;
    public static Item itemSpecial; 
    public static Item itemCustom; 
    public static CashBox regularCashBox;
    public static CashBox specialCashBox;
/** 
 *
 * The main class
 *
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
    		
    	}
    	
    	try {
        	specialVendingMachine.addSellableItem("Kitkats", 1, 80, 180);
    	    specialVendingMachine.addSellableItem("Cookies", 1, 10, 200);
    	    specialVendingMachine.addSellableItem("Cupcake", 1, 80, 180);
    	    specialVendingMachine.addSellableItem("Muffin", 1, 10, 200);
    	    specialVendingMachine.addFirstPart("Chocolate Cake", 8, 10, 150);
    	    specialVendingMachine.addFirstPart("Vanilla Cake", 8, 20, 150);
    	    specialVendingMachine.addFirstPart("Strawberry Cake", 8, 30, 150);
    	    specialVendingMachine.addSecondPart("Cream Filling", 1, 200, 250);
    	    specialVendingMachine.addSecondPart("Cream Cheese Filling", 10, 50, 220);
    	    specialVendingMachine.addSecondPart("Chocolate Filling", 10, 50, 220);
    	    specialVendingMachine.addThirdPart("Cream Frosting", 10, 50, 220);
    	    specialVendingMachine.addThirdPart("Chocolate Frosting", 10, 50, 220);
    	    specialVendingMachine.addFourthPart("Strawberry", 8, 20, 210);
    	    specialVendingMachine.addFourthPart("Kitkat", 8, 20, 210);
    	    specialVendingMachine.addFourthPart("Cookie", 8, 20, 210);
            ArrayList<String> recipe = new ArrayList<>();
            recipe.add("Chocolate Cake");
            recipe.add("Chocolate Filling");
            recipe.add("Chocolate Frosting");
            recipe.add("Kitkat");
            specialVendingMachine.addRecipe(recipe, "Supreme Choco");
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
    		
    	}
    	MainPageView mainPageView = new MainPageView();
    	new Controller(mainPageView);
    	mainPageView.setVisible(true);   
    }
}
	
