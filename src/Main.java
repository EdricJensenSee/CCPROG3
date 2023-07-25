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
        regularVendingMachine.addItem("Chocolate Chip Cookie", 2, 80, 180);
        regularVendingMachine.addItem("Chocolate Bar", 5, 40, 160);
        regularVendingMachine.addItem("Cream Cookie", 9, 20, 200);
        regularVendingMachine.addItem("Chocolate Muffin", 3, 30, 220);
        regularVendingMachine.addItem("Fresh Berry", 7, 70, 250);
        regularVendingMachine.addItem("Walnut Brownie", 6, 40, 230);
        regularVendingMachine.addItem("Blueberry Muffin", 10, 30, 190);
        regularVendingMachine.addItem("Banana Muffin", 4, 30, 210);

        System.out.println(regularVendingMachine.getItem(0).getQuantity());

        System.out.println(regularVendingMachine.getItem(0).getSold());
        System.out.println(regularVendingMachine.getCashBox().receivePayment(regularVendingMachine.getItemSlots(), regularVendingMachine.getItem(0).getItemName(), 80));
        System.out.println(regularVendingMachine.getCashBox().receivePayment(regularVendingMachine.getItemSlots(), regularVendingMachine.getItem(0).getItemName(), 80));
        System.out.println(regularVendingMachine.getItem(0).getQuantity());
        System.out.println(regularVendingMachine.getCashBox().getTotalSales());
        System.out.println(regularVendingMachine.getItem(0).getQuantity());
        System.out.println(regularVendingMachine.getItem(0).getSold());
        regularVendingMachine.getCashBox().resetTotalSales();
        System.out.println(regularVendingMachine.getCashBox().getTotalSales());
        specialVendingMachine.addSellableItem("Chocolate Chip Cookies", 10, 80, 180);
       specialVendingMachine.addSellableItem("Cream Filling", 6, 10, 200);
        /*specialVendingMachine.addFirstPart("Cake Base1", 8, 10, 150);
        specialVendingMachine.addFirstPart("Cake Base2", 8, 20, 150);
        specialVendingMachine.addFirstPart("Cake Base3", 8, 30, 150);
        specialVendingMachine.addSecondPart("Topping", 5, 200, 250);
        specialVendingMachine.addThirdPart("FIlling", 10, 50, 220);
        specialVendingMachine.addFourthPart("fROSTING", 8, 20, 210);
       // specialVendingMachine.getItemSellable().addItem("Cream Puffs", 6, 30, 180);
       // specialVendingMachine.getItemSellable().addItem("Strawberry", 10, 120	, 190);
        specialVendingMachine.getParts().add("Cake Base");
        specialVendingMachine.getParts().add("Fillings");
        specialVendingMachine.getParts().add("Frostings");
        specialVendingMachine.getParts().add("Toppings");
        //Main.specialVendingMachine.getCashBox().addTotalAmount(100);
        //Main.specialVendingMachine.getCashBox().resetAmountPaid();

  
        
        specialVendingMachine.getCashBox().replenishChange(5.0, 100);*/
    	/*regularVendingMachine.getCashBox().replenishChange(20.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(50.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(100.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(200.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(500.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(1000.0, 1);*/
    	AddItem open = new AddItem("Special");
    open.setVisible(true);
    }
}

