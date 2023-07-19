import java.util.*;


 /**
 * The Main class
 */ 
public class Main {
    public static int CAPACITY_PER_SLOT = 10;
    public static int SLOT = 9;
    private static Scanner scan = new Scanner(System.in);
    public static SpecialVendingMachine specialVendingMachine ;
    public static RegularVendingMachine regularVendingMachine ;
    private static int nChoice, number, quantity, calories;
    private static double payment;
    private static float price;
    private static String item;

/** 
 *
 * The main class
 *
 * @param args the args. 
 */
    public static void main(String[] args) { 
    	//Test Values
        /*regularVendingMachine.getItem().addItem("Chocolate Chip Cookie", 1, 80, 180);
        regularVendingMachine.getItem().addItem("Chocolate Bar", 5, 40, 160);
        regularVendingMachine.getItem().addItem("Cream Cookie", 9, 20, 200);
        regularVendingMachine.getItem().addItem("Chocolate Muffin", 3, 30, 220);
        regularVendingMachine.getItem().addItem("Fresh Berry", 7, 70, 250);
        regularVendingMachine.getItem().addItem("Walnut Brownie", 6, 40, 230);
        regularVendingMachine.getItem().addItem("Blueberry Muffin", 10, 30, 190);
        regularVendingMachine.getItem().addItem("Banana Muffin", 4, 30, 210);
        
        specialVendingMachine.getItem().addItem("Chocolate Chip Cookies", 10, 80, 180);
        specialVendingMachine.getItem().addItem("Cream Filling", 6, 10, 200);
        specialVendingMachine.getItem().addItem("Frosting", 8, 10, 150);
        specialVendingMachine.getItem().addItem("Cake", 5, 200, 250);
        specialVendingMachine.getItem().addItem("Chocolate", 10, 50, 220);
        specialVendingMachine.getItem().addItem("Vanilla", 8, 20, 210);
        specialVendingMachine.getItem().addItem("Cream Puffs", 6, 30, 180);
        specialVendingMachine.getItem().addItem("Strawberry", 10, 120	, 190);
        
    	regularVendingMachine.getCashBox().replenishChange(1.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(10.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(20.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(50.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(100.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(200.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(500.0, 1);
    	regularVendingMachine.getCashBox().replenishChange(1000.0, 1);*/
    	MAINPAGE open = new MAINPAGE();
    	open.setVisible(true);
    	while (true) {
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("\t BAKERY VENDING MACHINES MAIN MENU \t\n" +
                "\n[1] Create a Vending Machine" +
                "\n[2] Test a Vending Machine" +
                "\n[3] Exit\n");
            System.out.println("------------------------------------------------");
            nChoice = 0;
            while (nChoice < 1 || nChoice > 3) {
                System.out.print("\nEnter Choice: ");
                nChoice = scan.nextInt();
            }
            System.out.println();

            switch (nChoice) {
            case 1:
                createVendingMachine();
                break;
            case 2:
                System.out.print("Which machine do you want to test?" +
                        "\n[1] Regular Vending Machine" +
                        "\n[2] Special Vending Machine" +
                        "\n[3] Return to Main Menu\n");
                nChoice = 0;
                while (nChoice < 1 || nChoice > 3) {
                    System.out.print("\nEnter Choice: ");
                    nChoice = scan.nextInt();
                }
                switch (nChoice) {
                    case 1:
                        System.out.println("[1] Vending Features\n[2] Maintenance\n[3] Return");
                        nChoice = 0;
                        while (nChoice < 1 || nChoice > 3) {
                            System.out.print("\nEnter Choice: ");
                            nChoice = scan.nextInt();
                        }
                        boolean continuePurchase = true;
                        switch (nChoice) {
                            case 1:
                                while (continuePurchase) {
                                    System.out.println("Stock of Regular Vending Machine: ");
                                    regularVendingMachine.displayStock();
                                    do {
                                        System.out.print("Insert Payment (20, 50, 100, 200, 500, 1000): ₱");
                                        payment = scan.nextDouble();
                                    } while (payment != 20 && payment != 50 && payment != 100 && payment != 200 && payment != 500 && payment != 1000);

                                    System.out.print("Enter the number of the stock to purchase: ");
                                    number = scan.nextInt();
                                    while (!regularVendingMachine.getCashBox().receivePayment(regularVendingMachine.getItem(),regularVendingMachine.itemNumbers.get(number), payment)) {
                                        System.out.print("Insert More (20, 50, 100, 200, 500, 1000): ₱");
                                        payment += scan.nextDouble();
                                    }

                                    System.out.print("\nDo you wish to purchase another product?\n[1]Yes\n[2]No\n\n");
                                    nChoice = 0;
                                    while (nChoice < 1 || nChoice > 2) {
                                        System.out.print("Enter Choice: ");
                                        nChoice = scan.nextInt();
                                    }
                                    if (nChoice == 1)
                                        continuePurchase = true;
                                    else if (nChoice == 2)
                                        continuePurchase = false;
                                }
                                break;
                            case 2:
                                System.out.println("--------------------------\n");
                                System.out.print("[1] Restock items\n[2] Replenish Denominations\n[3] Add items\n[4] Change item prices\n[5] Transactions Summary\n[6] Return to Main Menu");
                                System.out.println("\n\n--------------------------");
                                nChoice = 0;
                                while (nChoice < 1 || nChoice > 6) {
                                    System.out.print("Enter Choice: ");
                                    nChoice = scan.nextInt();
                                }
                                switch (nChoice) {
                                    case 1:
                                        System.out.println("Stock of Regular Vending Machine: ");
                                        regularVendingMachine.displayStock();
                                        System.out.print("Item number: ");
                                        number = scan.nextInt();
                                        System.out.print("How much will you restock?: ");
                                        quantity = scan.nextInt();
                                        if ((regularVendingMachine.getItem().getItemQuantity().get(regularVendingMachine.itemNumbers.get(number)) + quantity) <= CAPACITY_PER_SLOT) {
                                            regularVendingMachine.getItem().getItemQuantity().put(regularVendingMachine.itemNumbers.get(number), (regularVendingMachine.getItem().getItemQuantity().get(regularVendingMachine.itemNumbers.get(number)) + quantity));
                                            System.out.println("Restocking successful!");
                                        } else {
                                            System.out.println("Quantity exceeds the stock limit");
                                        }
                                        break;
                                    case 2: 
                                    	System.out.print("10 Peso coins: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(10.0, quantity);
                                    	System.out.print("20 Peso coins: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(20.0, quantity);
                                    	System.out.print("50 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(50.0, quantity);
                                    	System.out.print("100 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(100.0, quantity);
                                    	System.out.print("200 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(200.0, quantity);
                                    	System.out.print("500 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(500.0, quantity);
                                    	System.out.print("1000 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	regularVendingMachine.getCashBox().replenishChange(1000.0, quantity);
                                    	break;
                                    case 3:
                                        if (regularVendingMachine.getItem().getTotalUnique() < SLOT) {
                                            System.out.print("Input Item: ");
                                            item = scan.nextLine();
                                            item = scan.nextLine();
                                            System.out.print("Input Quantity: ");
                                            quantity = scan.nextInt();
                                            System.out.print("Input Price: ");
                                            price = scan.nextFloat();
                                            System.out.print("Input Calories: ");
                                            calories = scan.nextInt();
                                            regularVendingMachine.getItem().addItem(item, quantity, price, calories);
                                            regularVendingMachine.displayStock();
                                        } else {
                                            System.out.println("This vending machine is full!");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Stock of Regular Vending Machine: ");
                                        regularVendingMachine.displayStock();
                                        System.out.print("Which item do you want to change the price of?: ");
                                        number = scan.nextInt();
                                        System.out.print("What will be its new price?: ");
                                        price = scan.nextFloat();
                                        regularVendingMachine.getItem().setItemPrice(regularVendingMachine.itemNumbers.get(number), price);
                                        break;
                                    case 5:
                                    	System.out.println("Remaining denominations:");
                                        regularVendingMachine.getCashBox().displayDenominations();
                                        System.lineSeparator();
                                        regularVendingMachine.getCashBox().printReceipt(regularVendingMachine.getItem());
                                        break;
                                    case 6:
                                        break;
                                }
                                break;
                            case 3:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("[1] Vending Features\n[2] Maintenance\n[3] Return");;
                        nChoice = 0;
                        while (nChoice < 1 || nChoice > 3) {
                            System.out.print("\nEnter Choice: ");
                            nChoice = scan.nextInt();
                        }
                        continuePurchase = true;
                        switch (nChoice) {
                            case 1:
                                while (continuePurchase) {
                                    System.out.println("Stock of Special Vending Machine: ");
                                    specialVendingMachine.displayStock();
                                    do {
                                        System.out.print("Insert Payment (20, 50, 100, 200, 500, 1000): ₱");
                                        payment = scan.nextDouble();
                                    } while (payment != 20 && payment != 50 && payment != 100 && payment != 200 && payment != 500 && payment != 1000);

                                    System.out.print("Enter the number of the stock to purchase: ");
                                    number = scan.nextInt();
                                    while (!specialVendingMachine.getCashBox().receivePayment(specialVendingMachine.getItem(),specialVendingMachine.itemNumbers.get(number), payment)) {
                                        System.out.print("Insert More (20, 50, 100, 200, 500, 1000): ₱");
                                        payment += scan.nextDouble();
                                    }

                                    System.out.print("Do you wish to purchase another product?\n[1]Yes\n[2]No\n\n");
                                    nChoice = 0;
                                    while (nChoice < 1 || nChoice > 2) {
                                        System.out.print("Enter Choice: ");
                                        nChoice = scan.nextInt();
                                    }
                                    if (nChoice == 1)
                                        continuePurchase = true;
                                    else if (nChoice == 2)
                                        continuePurchase = false;
                                }
                                break;
                            case 2:
                                System.out.println("--------------------------\n");
                                System.out.print("[1] Restock items\n[2] Replenish Denominations\n[3] Add items\n[4] Change item prices\n[5] Transactions Summary\n[6] Return to Main Menu");
                                System.out.println("\n\n--------------------------");
                                nChoice = 0;
                                while (nChoice < 1 || nChoice > 6) {
                                    System.out.print("Enter Choice: ");
                                    nChoice = scan.nextInt();
                                }
                                switch (nChoice) {
                                    case 1:
                                        System.out.println("Stock of Regular Vending Machine: ");
                                        specialVendingMachine.displayStock();
                                        System.out.print("Item number: ");
                                        number = scan.nextInt();
                                        System.out.print("How much will you restock?: ");
                                        quantity = scan.nextInt();
                                        if ((specialVendingMachine.getItem().getItemQuantity().get(specialVendingMachine.itemNumbers.get(number)) + quantity) <= CAPACITY_PER_SLOT) {
                                            specialVendingMachine.getItem().getItemQuantity().put(specialVendingMachine.itemNumbers.get(number), (specialVendingMachine.getItem().getItemQuantity().get(specialVendingMachine.itemNumbers.get(number)) + quantity));
                                            System.out.println("Restocking successful!");
                                        } else {
                                            System.out.print("Quantity exceeds the stock limit");
                                        }
                                        break;
                                    case 2:
                                    	System.out.print("10 Peso coins: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(10.0, quantity);
                                    	System.out.print("20 Peso coins: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(20.0, quantity);
                                    	System.out.print("50 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(50.0, quantity);
                                    	System.out.print("100 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(100.0, quantity);
                                    	System.out.print("200 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(200.0, quantity);
                                    	System.out.print("500 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(500.0, quantity);
                                    	System.out.print("1000 Peso bills: ");
                                    	quantity = scan.nextInt();
                                    	specialVendingMachine.getCashBox().replenishChange(1000.0, quantity);
                                    	break;
                                    case 3:
                                        if (specialVendingMachine.getItem().getTotalUnique() < SLOT) {
                                            System.out.print("Input Item: ");
                                            item = scan.nextLine();
                                            item = scan.nextLine();
                                            System.out.print("Input Quantity: ");
                                            quantity = scan.nextInt();
                                            System.out.print("Input Price: ");
                                            price = scan.nextFloat();
                                            System.out.print("Input Calories: ");
                                            calories = scan.nextInt();
                                            specialVendingMachine.getItem().addItem(item, quantity, price, calories);
                                            specialVendingMachine.displayStock();
                                        } else {
                                            System.out.print("This vending machine is full!");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Stock of Special Vending Machine: ");
                                        specialVendingMachine.displayStock();
                                        System.out.print("Which item do you want to change the price of?: ");
                                        number = scan.nextInt();
                                        System.out.print("What will be its new price?: ");
                                        price = scan.nextFloat();
                                        specialVendingMachine.getItem().setItemPrice(specialVendingMachine.itemNumbers.get(number), price);
                                        break;
                                    case 5:
                                    	System.out.println("Remaining denominations:");
                                        specialVendingMachine.getCashBox().displayDenominations();
                                        System.lineSeparator();System.lineSeparator();
                                        specialVendingMachine.getCashBox().printReceipt(specialVendingMachine.getItem());
                                        break;
                                    case 6:
                                    	break;
                                }
                                break;
                            case 3:
                                break;
                        }
                        break;
                }
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("!!! INVALID INPUT !!!\n\n");
                break;
        }
        }
    }


/** 
 *
 * The method that contains the process of creating a vending machine or resetting one
 *
 */
    private static void createVendingMachine() { 

        System.lineSeparator();
        System.out.println("--------------------------");
        System.out.println("  CREATE A VENDING MACHINE \n" +
            "\n[1] Regular Vending Machine" +
            "\n[2] Special Vending Machine" +
            "\n[3] Return to Main Menu\n");
        System.out.println("--------------------------");
        System.out.print("Enter Choice: ");
        nChoice = 0;
        while (nChoice < 1 || nChoice > 3) {
            nChoice = scan.nextInt();
        }
        System.out.println();

        switch (nChoice) {
            case 1:
                System.out.println("--------------------------\n");
                System.out.print("[1] Reset and Create Machine\n[2] Add Items \n[3] Return to Main Menu");
                System.out.println("\n\n--------------------------");
                nChoice = 0;
                while (nChoice < 1 || nChoice > 3) {
                    System.out.print("Enter Choice: ");
                    nChoice = scan.nextInt();
                }
                switch (nChoice) {
                    case 1:
                    	System.out.print("Input slots\n");
                    	SLOT = 0;
                    	while (SLOT < 8) {
                    		System.out.print("\nChoice:");
                        	SLOT = scan.nextInt();	
                    	}
                    	regularVendingMachine = new RegularVendingMachine();
                        break;
                    case 2:
                    	boolean continueAdd= true;
                    	regularVendingMachine.displayStock();
                    	while(continueAdd) {
                            if (regularVendingMachine.getItem().getTotalUnique() < SLOT) {
                                System.out.print("Input Item: ");
                                item = scan.nextLine();
                                item = scan.nextLine();
                                System.out.print("Input Quantity: ");
                                quantity = scan.nextInt();
                                System.out.print("Input Price: ");
                                price = scan.nextFloat();
                                System.out.print("Input Calories: ");
                                calories = scan.nextInt();
                                regularVendingMachine.getItem().addItem(item, quantity, price, calories);
                                regularVendingMachine.displayStock();
                                System.out.print("Do you wish to add another product?\n[1]Yes\n[2]No\n\nAnswer: ");
                                nChoice = 0;
                                while (nChoice < 1 || nChoice > 2) {
                                    System.out.print("Enter Choice: ");
                                    nChoice = scan.nextInt();
                                }
                                if (nChoice == 1)
                                    continueAdd= true;
                                else if (nChoice == 2)
                                    continueAdd = false;
                            } else {
                            	System.out.print("This vending machine is full!");
                            	continueAdd = false;
                            }
                    	}
                        break;  
                	}
                break;
            case 2:
                System.out.println("--------------------------\n");
                System.out.print("[1] Reset and Create Machine\n[2] Add items\n[3] Return to Main Menu");
                System.out.println("\n\n--------------------------");
                nChoice = 0;
                while (nChoice < 1 || nChoice > 3) {
                    System.out.print("Enter Choice: ");
                    nChoice = scan.nextInt();
                }
                switch (nChoice) {
                    case 1:
                    	System.out.print("Input slots\n");
                    	SLOT = 0;
                    	while (SLOT < 8) {
                    		System.out.print("\nChoice:");
                        	SLOT = scan.nextInt();  	
                    	}
                    	specialVendingMachine = new SpecialVendingMachine();   
                        break;
                    case 2:
                    	boolean continueAdd= true;
                    	specialVendingMachine.displayStock();
                    	continueAdd= true;
                    	while(continueAdd) {
                            if (specialVendingMachine.getItem().getTotalUnique() < SLOT) {
                                System.out.print("Input Item: ");
                                item = scan.nextLine();
                                item = scan.nextLine();
                                System.out.print("Input Quantity: ");
                                quantity = scan.nextInt();
                                System.out.print("Input Price: ");
                                price = scan.nextFloat();
                                System.out.print("Input Calories: ");
                                calories = scan.nextInt();
                                specialVendingMachine.getItem().addItem(item, quantity, price, calories);
                                specialVendingMachine.displayStock();
                                System.out.print("Do you wish to add another product?\n[1]Yes\n[2]No\n\nAnswer: ");
                                nChoice = 0;
                                while (nChoice < 1 || nChoice > 2) {
                                    System.out.print("Enter Choice: ");
                                    nChoice = scan.nextInt();
                                }
                                if (nChoice == 1)
                                    continueAdd= true;
                                else if (nChoice == 2)
                                    continueAdd = false;
                            } else {
                            	System.out.print("This vending machine is full!");
                                continueAdd = false;
                            }
                    	}
                }
                break;
        }
    }
}

