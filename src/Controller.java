import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {
    private MainPageView mainPageView;
    private CreatePageView createPageView;
    private CreateVendingMachineView createVendingMachineView;
    private CustomizeItemView customizeItemView;
    private MaintenancePageView maintenancePageView;
    private TestPageView testPageView;
    private TestVendingMachinePageView testVendingMachinePageView;
    private VendingMachineView vendingMachineView;
    private AddItemView addItemView;
    private String machineType;

    public Controller(MainPageView mainPageView) {
    	this.mainPageView = mainPageView;
        this.mainPageView.setCreateBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateVendingMachineView createVendingMachine = new CreateVendingMachineView();
                createVendingMachine.setVisible(true);
                mainPageView.dispose();
                new Controller(createVendingMachine);
            }
        });

        this.mainPageView.setTestBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TestPageView testPageView = new TestPageView();
                testPageView.setVisible(true);
                mainPageView.dispose();
                new Controller(testPageView);
            }
        });

        this.mainPageView.setExitBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPageView.dispose();
            }
        });
           
    }
    public Controller(TestPageView testPageView) {
        this.testPageView = testPageView;
        this.testPageView.setTestRegularBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.print("A");
                if (Main.regularVendingMachine == null) {
                    String message = "The vending machine hasn't been created!";
                    JOptionPane.showMessageDialog(null, message, "Machine Has Not Been Created", JOptionPane.WARNING_MESSAGE);
                } else {
                    testPageView.dispose();
                    TestVendingMachinePageView open = new TestVendingMachinePageView("Regular");
                    open.setVisible(true);
                    new Controller(open);
                }
            }
        });
    	
        this.testPageView.setTestSpecialBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (Main.specialVendingMachine == null) {
                    String message = "The vending machine hasn't been created!";
                    JOptionPane.showMessageDialog(null, message, "Machine Has Not Been Created", JOptionPane.WARNING_MESSAGE);
                } else {
                	testPageView.dispose();
                	TestVendingMachinePageView open= new TestVendingMachinePageView("Special");
                	open.setVisible(true);
                	new Controller(open);
                }
            }
        });
        
        this.testPageView.setTestReturnBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		testPageView.dispose();
    				MainPageView open = new MainPageView();
    				open.setVisible(true);
    				new Controller(open);
            }
        });
        

    }
    
    public Controller (TestVendingMachinePageView testVendingMachinePageView) {
    	this.testVendingMachinePageView = testVendingMachinePageView;
    	
        this.testVendingMachinePageView.setReturnfromTest(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testVendingMachinePageView.dispose();
                TestPageView open = new TestPageView();
                open.setVisible(true);
                new Controller(open);
            }
        });
        this.testVendingMachinePageView.btnFeatureTest(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testVendingMachinePageView.dispose();
                VendingMachineView open = new VendingMachineView(String.valueOf(e.getActionCommand()));
                open.setVisible(true);
                new Controller(open);
            }
        });

        this.testVendingMachinePageView.setbtnMaintance(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testVendingMachinePageView.dispose();
                MaintenancePageView open = new MaintenancePageView(String.valueOf(e.getActionCommand()));
                open.setVisible(true);
                new Controller(open);
            }
        });  
    }
    
    public Controller(CreateVendingMachineView createVendingMachineView) {
    	this.createVendingMachineView = createVendingMachineView;
        this.createVendingMachineView.setAddBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	createVendingMachineView.dispose();
				CreatePageView open= new CreatePageView("Regular");
				open.setVisible(true);
				new Controller(open, "Regular");
            }
        });  
        
        this.createVendingMachineView.setViewBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	createVendingMachineView.dispose();
				CreatePageView open= new CreatePageView("Special");
				open.setVisible(true);
				new Controller(open, "Special");
            }
        });
    	
        this.createVendingMachineView.btnReturner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	createVendingMachineView.dispose();
				MainPageView open = new MainPageView();
				open.setVisible(true);
            }
        });
    }
    

    public Controller(CreatePageView createPageView, String machineType) {
        this.createPageView = createPageView;
        this.machineType = machineType;

        this.createPageView.setCreateMachineBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (machineType.equals("Regular")) {
                    Main.regularVendingMachine = new RegularVendingMachine();
                    String message = machineType + " Vending machine created successfully!";
                    JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (machineType.equals("Special")) {
                    createPageView.showCustomizationFields();
                }
            }
        });

        this.createPageView.setAddItemsBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (machineType != null) {
                    if ((machineType.equals("Regular") && Main.regularVendingMachine != null) ||
                            (machineType.equals("Special") && Main.specialVendingMachine != null)) {
                    	createPageView.dispose();
                        AddItemView open = new AddItemView(machineType);
                        open.setVisible(true);
                        new Controller(open, machineType);
                    } else {
                        JOptionPane.showMessageDialog(null, machineType + " Vending Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.createPageView.setResetMachineBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((machineType.equals("Regular") && Main.regularVendingMachine != null) ||
                        (machineType.equals("Special") && Main.specialVendingMachine != null)) {
                    if (machineType.equals("Regular")) {
                        Main.regularVendingMachine = new RegularVendingMachine();
                    } else if (machineType.equals("Special")) {
                        Main.specialVendingMachine = new SpecialVendingMachine();
                    }
                    JOptionPane.showMessageDialog(null, machineType + " Vending Machine reset", "Reset Confirmation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.createPageView.setReturnBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPageView.dispose();
                CreateVendingMachineView open = new CreateVendingMachineView();
                open.setVisible(true);
                new Controller(open);
            }
        });

        this.createPageView.setCreateCustomMachineBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String part1 = createPageView.getPart1();
                String part2 = createPageView.getPart2();
                String part3 = createPageView.getPart3();
                String part4 = createPageView.getPart4();

                if (part1.isEmpty() || part2.isEmpty() || part3.isEmpty() || part4.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the parts", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                	Main.specialVendingMachine = new SpecialVendingMachine();
                    Main.specialVendingMachine.getParts().clear();
                    Main.specialVendingMachine.getParts().add(part1);
                    Main.specialVendingMachine.getParts().add(part2);
                    Main.specialVendingMachine.getParts().add(part3);
                    Main.specialVendingMachine.getParts().add(part4);
                    String message = machineType + " Vending machine created successfully!";
                    JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public Controller(VendingMachineView vendingMachineView) {
    	this.vendingMachineView = vendingMachineView;
    
    }
    
    public Controller(AddItemView addItemView, String machineType) {
        this.addItemView = addItemView;
        this.machineType = machineType;
        
        addItemView.addCustomizeButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean customizationMode = addItemView.isCustomizationMode();
                if (!customizationMode) {
                    addItemView.setCustomizeButtonText("Next");
                    addItemView.setCustomizationMode(true);
                    addItemView.setPart(Main.specialVendingMachine.getParts().get(addItemView.getCurrentNumber()));
                } else {
                    int currentNum = addItemView.getCurrentNumber();
                    if (currentNum < 3) {
                        addItemView.setCurrentNumber(currentNum + 1);
                        addItemView.setPart(Main.specialVendingMachine.getParts().get(addItemView.getCurrentNumber()));
                    } else {
                        addItemView.setCurrentNumber(0);
                        addItemView.setCustomizeButtonText("Customize");
                        addItemView.setCustomizationMode(false);
                        addItemView.setPart("");
                    }
                }
                addItemView.updateItemList();
            }
        });


        addItemView.addAddItemButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = addItemView.getItemName();
                int quantity = addItemView.getQuantity();
                double price = addItemView.getPrice();
                int calories = addItemView.getCalories();

                if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
                    Main.regularVendingMachine.addItem(itemName, quantity, price, calories);
                } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
                	if (addItemView.isCustomizationMode()) {
                        if (addItemView.getCurrentNumber() == 0) {
                            Main.specialVendingMachine.addFirstPart(itemName, quantity, price, calories);
                        } else if (addItemView.getCurrentNumber() == 1) {
                            Main.specialVendingMachine.addSecondPart(itemName, quantity, price, calories);
                        } else if (addItemView.getCurrentNumber() == 2) {
                            Main.specialVendingMachine.addThirdPart(itemName, quantity, price, calories);
                        } else if (addItemView.getCurrentNumber() == 3) {
                            Main.specialVendingMachine.addFourthPart(itemName, quantity, price, calories);
                        }   
                    } else if (!addItemView.isCustomizationMode()) {
                        Main.specialVendingMachine.addSellableItem(itemName, quantity, price, calories);
                    }
                }
                addItemView.updateItemList();
            }
        });
        
        this.addItemView.returner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addItemView.dispose();
                CreatePageView open = new CreatePageView(machineType);
                open.setVisible(true);
                new Controller(open, machineType);
            }
        });
    }
    
    public Controller(CustomizeItemView customizeItemView) {
    	this.customizeItemView = customizeItemView;
    
    }
    
    public Controller(MaintenancePageView maintenancePageView) {
    	this.customizeItemView = customizeItemView;
    
    }
    
}
