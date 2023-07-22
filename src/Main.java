import java.util.*;


 /**
 * The Main class
 */ 
public class Main {
    public static SpecialVendingMachine specialVendingMachine = new SpecialVendingMachine();
    public static RegularVendingMachine regularVendingMachine = new RegularVendingMachine();
    public static Item itemRegular;
    public static Item itemSpecial; 
    public static Item itemCustom;
    
/** 
 *
 * The main class
 *
 * @param args the args. 
 */
    public static void main(String[] args) { 
    	//Test Values
        regularVendingMachine.getItem().addItem("Chocolate Chip Cookie", 1, 80, 180);
        regularVendingMachine.getItem().addItem("Chocolate Bar", 5, 40, 160);
        regularVendingMachine.getItem().addItem("Cream Cookie", 9, 20, 200);
        regularVendingMachine.getItem().addItem("Chocolate Muffin", 3, 30, 220);
        regularVendingMachine.getItem().addItem("Fresh Berry", 7, 70, 250);
        regularVendingMachine.getItem().addItem("Walnut Brownie", 6, 40, 230);
        regularVendingMachine.getItem().addItem("Blueberry Muffin", 10, 30, 190);
        regularVendingMachine.getItem().addItem("Banana Muffin", 4, 30, 210);
        
        specialVendingMachine.getItemSellable().addItem("Chocolate Chip Cookies", 10, 80, 180);
        specialVendingMachine.getItemCustom().addItem("Cream Filling", 6, 10, 200);
        specialVendingMachine.addCakeBase("Cake Base1", 8, 10, 150);
        specialVendingMachine.addCakeBase("Cake Base2", 8, 20, 150);
        specialVendingMachine.addCakeBase("Cake Base3", 8, 30, 150);
        specialVendingMachine.addTopping("Topping", 5, 200, 250);
        specialVendingMachine.addFilling("FIlling", 10, 50, 220);
        specialVendingMachine.addFrosting("fROSTING", 8, 20, 210);
        specialVendingMachine.getItemSellable().addItem("Cream Puffs", 6, 30, 180);
        specialVendingMachine.getItemSellable().addItem("Strawberry", 10, 120	, 190);

    	regularVendingMachine.getCashBox().replenishChange(10.0, 1);
    	/*regularVendingMachine.getCashBox().replenishChange(20.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(50.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(100.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(200.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(500.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(1000.0, 1);*/
    	MAINPAGE open = new MAINPAGE();
    	open.setVisible(true);
    }
}

