import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller {
	private CreatePageView createPageView = new CreatePageView("");
	private CreateVendingMachineView createVendingMachineView = new CreateVendingMachineView();
	private CustomizeItemView customizeItemView = new CustomizeItemView();
	private MaintenancePageView maintenancePageView = new MaintenancePageView("");
	private TestPageView testPageView = new TestPageView();
	private TestVendingMachinePageView testVendingMachinePageView = new TestVendingMachinePageView("");
	private VendingMachineView vendingMachineView = new VendingMachineView("");
    private MainPageView mainPageView;
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
                if (Main.regularVendingMachine == null) {
                    String message = "The vending machine hasn't been created!";
                    JOptionPane.showMessageDialog(null, message, "Machine Has Not Been Created", JOptionPane.WARNING_MESSAGE);
                } else {
                    testPageView.dispose();
                    TestVendingMachinePageView open = new TestVendingMachinePageView("Regular");
                    open.setVisible(true);
                    new Controller(open, "Regular");
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
                	new Controller(open, "Special");
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
    
    public Controller (TestVendingMachinePageView testVendingMachinePageView, String machineType) {
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
                VendingMachineView open = new VendingMachineView(machineType);
                open.setVisible(true);
                new Controller(open, machineType);
            }
        });

        this.testVendingMachinePageView.setbtnMaintance(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testVendingMachinePageView.dispose();
                MaintenancePageView open = new MaintenancePageView(machineType);
                open.setVisible(true);
                new Controller(open, machineType);
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
				 new Controller(open);
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
                    String message = machineType + " Vending machine(4x3) created successfully!";
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
                        Main.specialVendingMachine.getParts().add("Cake Base");
                        Main.specialVendingMachine.getParts().add("Fillings");
                        Main. specialVendingMachine.getParts().add("Frostings");
                        Main.specialVendingMachine.getParts().add("Toppings");
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
        
        this.createPageView.setCreate(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = machineType + " Vending machine(4x3) created successfully!";
                Main.specialVendingMachine = new SpecialVendingMachine();
                Main.specialVendingMachine.getParts().add("Cake Base");
                Main.specialVendingMachine.getParts().add("Fillings");
                Main. specialVendingMachine.getParts().add("Frostings");
                Main.specialVendingMachine.getParts().add("Toppings");
                JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
                createPageView.enableRecipe();
            }
        });
        

        this.createPageView.setCreateCustomMachineBtnListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String part1 = createPageView.getPart1();
                String part2 = createPageView.getPart2();
                String part3 = createPageView.getPart3();
                String part4 = createPageView.getPart4();
                ArrayList<String> recipe = new ArrayList<>();
                if (part1.isEmpty() || part2.isEmpty() || part3.isEmpty() || part4.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the parts", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    recipe.add(part1);
                    recipe.add(part2);
                    recipe.add(part3);
                    recipe.add(part4);
                    Main.specialVendingMachine.addRecipe(recipe, createPageView.getProductName());
                }
            }
        });
    }

    public Controller(VendingMachineView vendingMachineView, String machineType) {
        this.vendingMachineView = vendingMachineView;
        
        vendingMachineView.A(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals("")) 
					vendingMachineView.setCode(vendingMachineView.getCode() + "A");
            }
        });
        this.vendingMachineView.B(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals("")) 
					vendingMachineView.setCode(vendingMachineView.getCode() + "B");
            }
        });
        this.vendingMachineView.C(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals(""))
					vendingMachineView.setCode(vendingMachineView.getCode() + "C");
            }
        });
        
        this.vendingMachineView.D(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals("")) 
					vendingMachineView.setCode(vendingMachineView.getCode() + "D");
            }
        });
        
        this.vendingMachineView.number1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals("A") || vendingMachineView.getCode().equals("B") || vendingMachineView.getCode().equals("C") || vendingMachineView.getCode().equals("D")) 
					vendingMachineView.setCode(vendingMachineView.getCode() + "1");
            }
        });
        
        
        this.vendingMachineView.number2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals("A") || vendingMachineView.getCode().equals("B") || vendingMachineView.getCode().equals("C") || vendingMachineView.getCode().equals("D")) 
					vendingMachineView.setCode(vendingMachineView.getCode() + "2");
            }
        });
        
        this.vendingMachineView.number3(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (vendingMachineView.getCode().equals("A") || vendingMachineView.getCode().equals("B") || vendingMachineView.getCode().equals("C") || vendingMachineView.getCode().equals("D")) 
					vendingMachineView.setCode(vendingMachineView.getCode() + "3");
            }
        });
        
        this.vendingMachineView.cancel(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	vendingMachineView.setCode("");
            	vendingMachineView.setPriceCode("");
            }
        });
        
        this.vendingMachineView.add100(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular")) {
					Main.regularVendingMachine.getCashBox().addTotalAmount(100);
					vendingMachineView.setInsert(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				}
				if (machineType.equals("Special")) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(100);
					vendingMachineView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
				}
            }
        });
        
        this.vendingMachineView.add50(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular")) {
					Main.regularVendingMachine.getCashBox().addTotalAmount(50);
					vendingMachineView.setInsert(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				}
				if (machineType.equals("Special")) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(50);
					vendingMachineView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
				}
            }
        });
        
        this.vendingMachineView.add20(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular")) {
					Main.regularVendingMachine.getCashBox().addTotalAmount(20);
					vendingMachineView.setInsert(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				}
				if (machineType.equals("Special")) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(20);
					vendingMachineView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
				}
            }
        });
        
        this.vendingMachineView.add10(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular")) {
					Main.regularVendingMachine.getCashBox().addTotalAmount(10);
					vendingMachineView.setInsert(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				}
				if (machineType.equals("Special")) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(10);
					vendingMachineView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
				}
            }
        });
        
        this.vendingMachineView.add5(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular")) {
					Main.regularVendingMachine.getCashBox().addTotalAmount(5);
					vendingMachineView.setInsert(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				}
				if (machineType.equals("Special")) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(5);
					vendingMachineView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
				}
            }
        });
        
        this.vendingMachineView.clear(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular")) {
					Main.regularVendingMachine.getCashBox().resetAmountPaid();
				    if (Main.regularVendingMachine.getCashBox().getAmountPaid() > 0) {
				    	vendingMachineView.setInsert(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				    } else {
				    	vendingMachineView.setInsert("");
				    }
				} 
				if (machineType.equals("Special")) {
					Main.specialVendingMachine.getCashBox().resetAmountPaid();
				    if (Main.specialVendingMachine.getCashBox().getAmountPaid() > 0) {
				    	vendingMachineView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));
				    } else {
				    	vendingMachineView.setInsert("");
				    }
				}
            }
        });
        
        this.vendingMachineView.enterItem(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (vendingMachineView.getCode().equals("")) {
           		 JOptionPane.showMessageDialog(null, "Enter Item.");
           		 return;
           	}
				int itemNumber = -1;
			    if (!vendingMachineView.getCode().equals("")) {
			        if (vendingMachineView.getCode().equals("A1"))
			            itemNumber = 0;
			        else if (vendingMachineView.getCode().equals("A2"))
			            itemNumber = 1;
			        else if (vendingMachineView.getCode().equals("A3"))
			            itemNumber = 2;
			        else if (vendingMachineView.getCode().equals("B1"))
			            itemNumber = 3;
			        else if (vendingMachineView.getCode().equals("B2"))
			            itemNumber = 4;
			        else if (vendingMachineView.getCode().equals("B3"))
			            itemNumber = 5;
			        else if (vendingMachineView.getCode().equals("C1"))
			            itemNumber = 6;
			        else if (vendingMachineView.getCode().equals("C2"))
			            itemNumber = 7;
			        else if (vendingMachineView.getCode().equals("C3"))
			            itemNumber = 8;
			        else if (vendingMachineView.getCode().equals("D1"))
			            itemNumber = 9;
			        else if (vendingMachineView.getCode().equals("D2"))
			            itemNumber = 10;
			        else if (vendingMachineView.getCode().equals("D3"))
			            itemNumber = 11;
			    }
            	if (itemNumber == -1) {
             		 JOptionPane.showMessageDialog(null, "Input Item.");
             		 return;
             	}
            	
            	if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
            	    if (itemNumber >= 0 && itemNumber <  Main.regularVendingMachine.getItemSlots().size()) {
            	        if ( Main.regularVendingMachine.getItemSlots().get(itemNumber).getPrice() != 0) {
            	            vendingMachineView.setPriceCode(String.valueOf( Main.regularVendingMachine.getItemSlots().get(itemNumber).getPrice()));
            	        } else {
            	        }
            	    } else {
                		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
                 		 return;
            	    }
            	} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
            	    if (itemNumber >= 0 && itemNumber < Main.specialVendingMachine.getItemSellableSlots().size()) {
            	        if (Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getPrice() != 0) {
            	            vendingMachineView.setPriceCode(String.valueOf(Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getPrice()));
            	        } else {
            	        }
            	    } else {
               		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
             		 return;
            	    }
            	}
            }
        });
        
        this.vendingMachineView.buy(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (vendingMachineView.getCode().equals("") || vendingMachineView.getPriceCode().equals("")) {
            		JOptionPane.showMessageDialog(null, "Input a product.");
            		return;
            	}
            	if (vendingMachineView.getInsert().equals("")) {
            		JOptionPane.showMessageDialog(null, "Insert Cash.");
            		return;
            	}
            	if (Double.parseDouble(vendingMachineView.getInsert()) < Double.parseDouble(vendingMachineView.getPriceCode())) {
            		JOptionPane.showMessageDialog(null, "Insufficient Payment.");
				}
            	            		
				int itemNumber = -1;
				    switch (vendingMachineView.getCode()) {
				        case "A1":
				            itemNumber = 0;
				            break;
				        case "A2":
				            itemNumber = 1;
				            break;
				        case "A3":
				            itemNumber = 2;
				            break;
				        case "B1":
				            itemNumber = 3;
				            break;
				        case "B2":
				            itemNumber = 4;
				            break;
				        case "B3":
				            itemNumber = 5;
				            break;
				        case "C1":
				            itemNumber = 6;
				            break;
				        case "C2":
				            itemNumber = 7;
				            break;
				        case "C3":
				            itemNumber = 8;
				            break;
				        case "D1":
				            itemNumber = 9;
				            break;
				        case "D2":
				            itemNumber = 10;
				            break;
				        case "D3":
				            itemNumber = 11;
				            break;
				        default:
				        	itemNumber = -1;
				            break;
				    }
				    
	            	if (itemNumber == -1) {
	              		 JOptionPane.showMessageDialog(null, "Input Item.");
	              		 return;
	              	}
							   
				    if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				        if (Main.regularVendingMachine.getCashBox().isItemAvailable(Main.regularVendingMachine.getItemSlots().get(itemNumber))) {
				            if (Main.regularVendingMachine.getItemSlots().get(itemNumber).getPrice() != 0) {
				                if (Main.regularVendingMachine.getCashBox().receivePayment(Main.regularVendingMachine.getItemSlots(), Main.regularVendingMachine.getItemSlots().get(itemNumber).getItemName(), Double.parseDouble(vendingMachineView.getInsert()))) {
				                    vendingMachineView.setOutput(Main.regularVendingMachine.getItemSlots().get(itemNumber).getItemName() + " - " + Main.regularVendingMachine.getItemSlots().get(itemNumber).getCalories() + "Cal");
				                    Main.regularVendingMachine.getCashBox().isEmpty(Main.regularVendingMachine.getItemSlots(), Main.regularVendingMachine.getItemSlots().get(itemNumber).getItemName());
				                    vendingMachineView.itemAdder(machineType);
				                } else {
				                }
				            } else {
				            }
				        } else {
				            vendingMachineView.setFinish("Item not found in stock");
				        }
				    } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				        if (Main.specialVendingMachine.getCashBox().isItemAvailable(Main.specialVendingMachine.getItemSellableSlots().get(itemNumber))) {
				            if (Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getPrice() != 0) {
				                if (Main.specialVendingMachine.getCashBox().receivePayment(Main.specialVendingMachine.getItemSellableSlots(), Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getItemName(), Double.parseDouble(vendingMachineView.getInsert()))) {
				                	vendingMachineView.setOutput(Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getItemName() + " - " + Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getCalories()+ "Cal");
				                	Main.specialVendingMachine.getCashBox().isEmpty(Main.specialVendingMachine.getItemSellableSlots(), Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getItemName());
				                	vendingMachineView.itemAdder(machineType);
				                } else {
				                }
				            } else {
				            }
				        } else {
				        	vendingMachineView.setFinish("Item not found in stock");
				        }
				    } 		
			    Timer timer1 = new Timer(2000, new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	vendingMachineView.setFinish("");
			        }
			    });
			    timer1.setRepeats(false);
			    timer1.start();
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
			        Main.regularVendingMachine.getCashBox();
			        if (Main.regularVendingMachine.getCashBox().getDenominationsSpent().size() > 0 || Double.parseDouble(vendingMachineView.getInsert()) == Double.parseDouble(vendingMachineView.getPriceCode())) {
			            if (!Main.regularVendingMachine.getCashBox().getDenominationsSpent().isEmpty()) {
			            	vendingMachineView.itemAdder(machineType);
			            	vendingMachineView.setWallet(String.valueOf(Main.regularVendingMachine.getCashBox().getDenominationsSpent().get(0)));
			            }
			        } else {
			        	vendingMachineView.setFinish("NOT ENOUGH CHANGE IN MACHINE");
			        }
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
			        Main.specialVendingMachine.getCashBox();
			        if (Main.specialVendingMachine.getCashBox().getDenominationsSpent().size() > 0 || Double.parseDouble(vendingMachineView.getInsert()) == Double.parseDouble(vendingMachineView.getPriceCode())) {
			            if (!Main.specialVendingMachine.getCashBox().getDenominationsSpent().isEmpty()) {
			            	vendingMachineView.itemAdder(machineType);
			            	vendingMachineView.setWallet(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(0)));
			            }
			        } else {
			        	vendingMachineView.setFinish("NOT ENOUGH CHANGE IN MACHINE");
			        }
			    

				    Timer timer = new Timer(2000, new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	vendingMachineView.setFinish("");
				        }
				    });
				    timer.setRepeats(false);
				    timer.start();
			}

				if (Double.parseDouble(vendingMachineView.getInsert()) < Double.parseDouble(vendingMachineView.getPriceCode())) {
					vendingMachineView.setFinish("Insufficient Payment");

				    Timer timer = new Timer(2000, new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	vendingMachineView.setFinish("");
				        }
				    });
				    timer.setRepeats(false);
				    timer.start();
				} else {
					vendingMachineView.setInsert("");

				    Timer timer = new Timer(2000, new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	vendingMachineView.setCode("");       
				        	vendingMachineView.setPriceCode("");  
				        }
				    });
				    timer.setRepeats(false);
				    timer.start();
				    if (machineType.equals("Regular") && Main.regularVendingMachine != null) 
				        Main.regularVendingMachine.getCashBox().resetAmountPaid();
				    else if (machineType.equals("Special") && Main.specialVendingMachine != null) 
				        Main.specialVendingMachine.getCashBox().resetAmountPaid();
				    vendingMachineView.itemAdder(machineType);
				}
				vendingMachineView.itemAdder(machineType);
            }
            
        });
        
        this.vendingMachineView.claimProduct(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!vendingMachineView.getOutput().equals(""))
					vendingMachineView.setFinish((vendingMachineView.getOutput()).toUpperCase() + " CLAIMED!");
                vendingMachineView.setOutput("");
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	vendingMachineView.setFinish("");
                    }
                });
                timer.setRepeats(false);
                timer.start();
			}
        });
        
        this.vendingMachineView.changeCollect(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int[] currentIndex = vendingMachineView.getCurrentIndex();
                vendingMachineView.setCollect("" + vendingMachineView.getWallet());
                if (machineType.equals("Regular")) {
                    int size = Main.regularVendingMachine.getCashBox().getDenominationsSpent().size();
                    if (currentIndex[0] == size-1) {
                        currentIndex[0] = -1;
                        vendingMachineView.setWallet("");
                        vendingMachineView.setCurrentIndex();
                        Main.regularVendingMachine.getCashBox().getDenominationsSpent().clear();
                    } else if (currentIndex[0] >= 0 && currentIndex[0] < size) {
                        vendingMachineView.setCollect(String.valueOf(Main.regularVendingMachine.getCashBox().getDenominationsSpent().get(currentIndex[0])));
                        currentIndex[0]++;
                        if (currentIndex[0] < size) {
                            vendingMachineView.setWallet(String.valueOf(Main.regularVendingMachine.getCashBox().getDenominationsSpent().get(currentIndex[0])));
                        }

                        Timer timer = new Timer(2000, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                vendingMachineView.setCollect("");
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                } else if (machineType.equals("Special")) {
                    int size = Main.specialVendingMachine.getCashBox().getDenominationsSpent().size();
                    if (currentIndex[0] == size - 1) {
                        currentIndex[0] = -1;
                        vendingMachineView.setWallet("");
                        vendingMachineView.setCurrentIndex();
                        Main.specialVendingMachine.getCashBox().getDenominationsSpent().clear();
                    } else if (currentIndex[0] >= 0 && currentIndex[0] < size) {
                        vendingMachineView.setCollect(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(currentIndex[0])));
                        currentIndex[0]++;
                        if (currentIndex[0] < size) {
                            vendingMachineView.setWallet(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(currentIndex[0])));
                        }

                        Timer timer = new Timer(2000, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                vendingMachineView.setCollect("");
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        vendingMachineView.setCollect("");
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        
        this.vendingMachineView.customize(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	vendingMachineView.setVisible(false);
            	Main.specialVendingMachine.getCashBox().resetAmountPaid();
            	CustomizeItemView open = new CustomizeItemView();
            	open.setVisible(true);
            	new Controller(open);
            }
        });
        
        this.vendingMachineView.btnReturner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	vendingMachineView.dispose();
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItemSlots() != null) {
			    	Main.regularVendingMachine.getCashBox().resetAmountPaid();
			    	TestVendingMachinePageView open = new TestVendingMachinePageView("Regular");
			    	open.setVisible(true);
			    	new Controller(open, machineType);
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItemSellableSlots() != null) {
			    	Main.specialVendingMachine.getCashBox().resetAmountPaid();
			    	TestVendingMachinePageView open = new TestVendingMachinePageView("Special");
			    	open.setVisible(true);
			    	new Controller(open, machineType);
			    }	
			    
            }
        });
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
                addItemView.updateItemList(machineType);
            }
        });


        addItemView.addAddItemButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addItemView.getItemName().equals("") || addItemView.getQuantity().equals("") || addItemView.getPrice().equals("") || addItemView.getCalories().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields before adding the item.");
                    return;
                }
            	int quantity = 0;
                double price = 0;
                int calories = 0;
                try {
                    String quantityStr = addItemView.getQuantity();
                    String priceStr = addItemView.getPrice();
                    String caloriesStr = addItemView.getCalories();
                    quantity = Integer.parseInt(quantityStr);
                    price = Double.parseDouble(priceStr);
                    calories = Integer.parseInt(caloriesStr);
                    
                } catch (NumberFormatException e1) {
                	JOptionPane.showMessageDialog(null, "Input valid numbers.");
                } 

                String itemName = addItemView.getItemName();                
                if (price%5!=0) {
                    JOptionPane.showMessageDialog(null, "The price must be divisible by 5.");
                    return;
                }

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
                addItemView.updateItemList(machineType);
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
    	this.customizeItemView.claimProduct(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				customizeItemView.setFinish((vendingMachineView.getOutput()).toUpperCase() + " CLAIMED!");
				customizeItemView.setOutput("");
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	customizeItemView.setFinish("");
                    	customizeItemView.getRecipe().clear();
                    	customizeItemView.setCurrentNumber(0);
                    	customizeItemView.dispose();
                    	 Main.specialVendingMachine.getCashBox().resetAmountPaid();
            			VendingMachineView open = new VendingMachineView("Special");
            			open.setVisible(true);
            			new Controller(open, "Special");
                    	
                    }
                });
                timer.setRepeats(false);
                timer.start();
			}
        });
        
    	this.customizeItemView.A(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals("")) 
					customizeItemView.setCode(customizeItemView.getCode() + "A");
            }
        });
        this.customizeItemView.B(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals("")) 
					customizeItemView.setCode(customizeItemView.getCode() + "B");
            }
        });
        this.customizeItemView.C(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals(""))
					customizeItemView.setCode(customizeItemView.getCode() + "C");
            }
        });
        
        this.customizeItemView.D(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals("")) 
					customizeItemView.setCode(customizeItemView.getCode() + "D");
            }
        });
        
        this.customizeItemView.number1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals("A") || customizeItemView.getCode().equals("B") || customizeItemView.getCode().equals("C") || customizeItemView.getCode().equals("D")) 
					customizeItemView.setCode(customizeItemView.getCode() + "1");
            }
        });
        
        
        this.customizeItemView.number2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals("A") || customizeItemView.getCode().equals("B") || customizeItemView.getCode().equals("C") || customizeItemView.getCode().equals("D")) 
					customizeItemView.setCode(customizeItemView.getCode() + "2");
            }
        });
        
        this.customizeItemView.number3(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (customizeItemView.getCode().equals("A") || customizeItemView.getCode().equals("B") || customizeItemView.getCode().equals("C") || customizeItemView.getCode().equals("D")) 
					customizeItemView.setCode(customizeItemView.getCode() + "3");
            }
        });
        
        this.customizeItemView.cancel(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	customizeItemView.setCode("");
            	customizeItemView.setPriceCode("");
            }
        });
        
        this.customizeItemView.printProcess(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(customizeItemView.getInsert().equals(""))
    				return;
    			if (Main.specialVendingMachine.prepareProduct(Main.specialVendingMachine.getRecipes().size() - 1, Double.parseDouble(customizeItemView.getInsert()))) {
    				customizeItemView.hidePanels();
    				if (Main.specialVendingMachine.getParts().get(0).equals("Cake Base")) {
    					customizeItemView.setFirstPart("Creating the Cake Base");

    				    Timer timer1 = new Timer(2000, new ActionListener() {
    				        public void actionPerformed(ActionEvent e) {
    				            if (Main.specialVendingMachine.getParts().get(1).equals("Fillings")) {
    				            	customizeItemView.setSecondPart("Filling with Irresistible Goodness");

    				                Timer timer2 = new Timer(2000, new ActionListener() {
    				                    public void actionPerformed(ActionEvent e) {
    				                        if (Main.specialVendingMachine.getParts().get(2).equals("Frostings")) {
    				                        	customizeItemView.setThirdPart("Layering with Delightful Frostings");

    				                            Timer timer3 = new Timer(2000, new ActionListener() {
    				                                public void actionPerformed(ActionEvent e) {
    				                                    if (Main.specialVendingMachine.getParts().get(3).equals("Toppings")) {
    				                                    	customizeItemView.setFourthPart("Adding Delectable Toppings");

    				                                        Timer timerClear = new Timer(2000, new ActionListener() {
    				                                            public void actionPerformed(ActionEvent e) {
    				                                            	customizeItemView.setFirstPart("");
    				                                            	customizeItemView.setSecondPart("");
    				                                            	customizeItemView.setThirdPart("");
    				                                            	customizeItemView.setFourthPart("");
    				                                            	customizeItemView.setOutput(Main.specialVendingMachine.findRecipeNameByIngredients(Main.specialVendingMachine.getRecipes().get(Main.specialVendingMachine.getRecipes().size() - 1)) + " - TOTAL CAL: " + Main.specialVendingMachine.calculateTotalCalories(Main.specialVendingMachine.getRecipes().get(Main.specialVendingMachine.getRecipes().size() - 1)));
    				                                            }
    				                                        });
    				                                        timerClear.setRepeats(false);
    				                                        timerClear.start();
    				                                    }
    				                                }
    				                            });
    				                            timer3.setRepeats(false);
    				                            timer3.start();
    				                        }
    				                    }
    				                });
    				                timer2.setRepeats(false);
    				                timer2.start();
    				            }
    				        }
    				    });
    				    timer1.setRepeats(false);
    				    timer1.start();
    				}}
    			Main.specialVendingMachine.getCashBox();

    			if (Main.specialVendingMachine.getCashBox().getDenominationsSpent().size() > 0 || Double.parseDouble(customizeItemView.getInsert()) == Double.parseDouble(customizeItemView.getPriceCode())) {
    			    if (!Main.specialVendingMachine.getCashBox().getDenominationsSpent().isEmpty()) {
    			        customizeItemView.setWallet(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(0)));
    			    }
    			} else {
    			    customizeItemView.setFinish("NOT ENOUGH CHANGE IN MACHINE");
    			}

    			if (Double.parseDouble(customizeItemView.getInsert()) < Double.parseDouble(customizeItemView.getPriceCode())) {
    			    customizeItemView.setFinish("Insufficient Payment");

    			    Timer timer = new Timer(2000, new ActionListener() {
    			        public void actionPerformed(ActionEvent e) {
    			            customizeItemView.setFinish("");
    			        }
    			    });
    			    timer.setRepeats(false);
    			    timer.start();
    			} else if (Main.specialVendingMachine.getCashBox().getDenominationsSpent().size() > 0 || Double.parseDouble(customizeItemView.getInsert()) == Double.parseDouble(customizeItemView.getPriceCode())){
    			    customizeItemView.setInsert("");

    			    Timer timer = new Timer(2000, new ActionListener() {
    			        public void actionPerformed(ActionEvent e) {
    			            customizeItemView.setCode("");
    			            customizeItemView.setPriceCode("");
    			        }
    			    });
    			    timer.setRepeats(false);
    			    timer.start();
    			}

    			Timer finishTimer = new Timer(2000, new ActionListener() {
    			    public void actionPerformed(ActionEvent e) {
    			        customizeItemView.setFinish("");
    			    }
    			});
    			finishTimer.setRepeats(false);
    			finishTimer.start();

 			}
        });
        
        this.customizeItemView.changeCollect(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				customizeItemView.setCollect(customizeItemView.getWallet());
			        int size = Main.specialVendingMachine.getCashBox().getDenominationsSpent().size();
			        if (customizeItemView.getCurrentIndex()[0] == size-1) {
			        	customizeItemView.getCurrentIndex()[0] = -1;
			        	customizeItemView.setWallet("");
			        	customizeItemView.setCurrentIndex();
			            Main.specialVendingMachine.getCashBox().getDenominationsSpent().clear();
			        } else if (customizeItemView.getCurrentIndex()[0] >= 0 && customizeItemView.getCurrentIndex()[0] < size) {
			        	customizeItemView.setCollect(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(customizeItemView.getCurrentIndex()[0])));
			        	customizeItemView.getCurrentIndex()[0]++;
			            if (customizeItemView.getCurrentIndex()[0] < size) {
			            	customizeItemView.setWallet(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(customizeItemView.getCurrentIndex()[0])));
			            }
			        }
		            Timer timer = new Timer(2000, new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                	customizeItemView.setCollect("");
		                }
		            });
		            timer.setRepeats(false);
		            timer.start();
			}
        });
        
        this.customizeItemView.add100(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(100);
					customizeItemView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
            }
        });
        
        this.customizeItemView.add50(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(50);
					customizeItemView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
            }
        });
        
        this.customizeItemView.add20(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(20);
					customizeItemView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
            }
        });
        
        this.customizeItemView.add10(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(10);
					customizeItemView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
            }
        });
        
        this.customizeItemView.add5(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
					Main.specialVendingMachine.getCashBox().addTotalAmount(5);
					customizeItemView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));				
            }
        });
        
        this.customizeItemView.indiv(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	customizeItemView.getRecipe().clear();
            	customizeItemView.setCurrentNumber(0);
            	customizeItemView.dispose();
    			VendingMachineView open = new VendingMachineView("Special");
    			open.setVisible(true);
    			new Controller(open, machineType);
            }
        });
        
        this.customizeItemView.clear(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    		    Main.specialVendingMachine.getCashBox().resetAmountPaid();
    		    if (Main.specialVendingMachine.getCashBox().getAmountPaid() > 0) {
    		    	customizeItemView.setInsert(Integer.toString((int) Main.specialVendingMachine.getCashBox().getAmountPaid()));
    		    } else {
    		    	customizeItemView.setInsert("");
    		    }
            }
        });
        
        this.customizeItemView.returner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	customizeItemView.getRecipe().clear();
            	customizeItemView.setCurrentNumber(0);
            	customizeItemView.dispose();
            	 Main.specialVendingMachine.getCashBox().resetAmountPaid();
    		    TestVendingMachinePageView open = new TestVendingMachinePageView("Special");
    		    open.setVisible(true);	
    		    new Controller(open, "Special");
            }
        });
        
        this.customizeItemView.btnEnter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (customizeItemView.getCode().equals("")) {
            		 JOptionPane.showMessageDialog(null, "Enter Item.");
            		 return;
            	}
            	int itemNumber = -1;
    		    switch (customizeItemView.getCode()) {
    		        case "A1":
    		            itemNumber = 0;
    		            break;
    		        case "A2":
    		            itemNumber = 1;
    		            break;
    		        case "A3":
    		            itemNumber = 2;
    		            break;
    		        case "B1":
    		            itemNumber = 3;
    		            break;
    		        case "B2":
    		            itemNumber = 4;
    		            break;
    		        case "B3":
    		            itemNumber = 5;
    		            break;
    		        case "C1":
    		            itemNumber = 6;
    		            break;
    		        case "C2":
    		            itemNumber = 7;
    		            break;
    		        case "C3":
    		            itemNumber = 8;
    		            break;
    		        case "D1":
    		            itemNumber = 9;
    		            break;
    		        case "D2":
    		            itemNumber = 10;
    		            break;
    		        case "D3":
    		            itemNumber = 11;
    		            break;
    		        default:
    		        	itemNumber = 0;
    		            break;
    		    }
    		    
            	if (itemNumber == -1) {
             		 JOptionPane.showMessageDialog(null, "Input Item.");
             		 return;
             	}
            	
            	
    	        String itemName = "";
    	        if (customizeItemView.getCurrentNumber() == 0) {
    	            itemName = Main.specialVendingMachine.getFirstPartName(itemNumber);
    	        } else if (customizeItemView.getCurrentNumber() == 1) {
    	            itemName = Main.specialVendingMachine.getSecondPartName(itemNumber);
    	        } else if (customizeItemView.getCurrentNumber() == 2) {
    	            itemName = Main.specialVendingMachine.getThirdPartName(itemNumber);
    	        } else if (customizeItemView.getCurrentNumber() == 3) {
    	            itemName = Main.specialVendingMachine.getFourthPartName(itemNumber);
    	        }     
    	        
    	        if(Main.specialVendingMachine.getItemCustomByName(itemName) == null) {
                		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
                		 return;
    	        }
    	        if (customizeItemView.getCurrentNumber() == 0) {
    	            itemName = Main.specialVendingMachine.getFirstPartName(itemNumber);
    	            boolean alreadyAdded = customizeItemView.getRecipe().contains(itemName);
    	            if (!alreadyAdded) {
    	                customizeItemView.getRecipe().add(itemName);
    	            }
    	        } else if (itemName != null && Main.specialVendingMachine.itemUsedCount(customizeItemView.getRecipe(), itemName) < Main.specialVendingMachine.getItemCustomByName(itemName).getQuantity()){
    	        	customizeItemView.getRecipe().add(itemName);
    	        }
    	        	
    	        int count = 0;
    	        StringBuilder recipes = new StringBuilder();
    	        if(!customizeItemView.getRecipe().isEmpty()) {
    	        	for (int i = 0; i < customizeItemView.getRecipe().size(); i++) {
    		            String item = customizeItemView.getRecipe().get(i);
    		            boolean isProcessed = false;

    		            for (int j = 0; j < i; j++) {
    		                if (item.equals(customizeItemView.getRecipe().get(j))) {
    		                    isProcessed = true;
    		                    break;
    		                }
    		            }
    		            if (!isProcessed) {
    		                String name = item;
    		                int quantity = Main.specialVendingMachine.itemUsedCount(customizeItemView.getRecipe(), item);
    		                recipes.append(name).append(" - ").append(quantity);
    		                int numSpaces = 15 - name.length() - String.valueOf(quantity).length();
    		                for (int j = 0; j < numSpaces; j++) {
    		                    recipes.append("&nbsp;");
    		                }
    		                count++;
    		                if (count % 2 == 0)
    		                    recipes.append("<br>");
    		            }
    		        }

    		        if (count % 2 != 0) {
    		            recipes.append("&nbsp;").append("<br>");
    		        }
    		        customizeItemView.setOutput("<html>Combination - Total Price - " + Double.toString(Main.specialVendingMachine.calculateTotalPrice(customizeItemView.getRecipe())) + "<br>" + recipes.toString() + "</html>");
    	        }
    	        if (itemName != null) {
    	            double itemPrice = Main.specialVendingMachine.getItemCustomByName(itemName).getPrice();
    	            customizeItemView.setPriceCode(String.valueOf(itemPrice));
    	        } else {
           		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
         		 return;
    	        }
            }
        });
        
        this.customizeItemView.addRecipe(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (customizeItemView.getCurrentNumber() == 0) {
            		if (customizeItemView.getCode().equals("") ||customizeItemView.getPriceCode().equals("")) {
            			 JOptionPane.showMessageDialog(null, "You need to have a cake base.");
            			 return;
            		}
            	}
            	
            	if (customizeItemView.getCurrentNumber() == 1) {
            		if (customizeItemView.getCode().equals("")|| customizeItemView.getPriceCode().equals("")) {
            			 JOptionPane.showMessageDialog(null, "Add filling.");
            			 return;
            		}
            	}
            	
            	if (customizeItemView.getCurrentNumber() == 2) {
            		if (customizeItemView.getCode().equals("")|| customizeItemView.getPriceCode().equals("")) {
            			 JOptionPane.showMessageDialog(null, "Add frosting.");
            			 return;
            		}
            	}
            	
            	if (customizeItemView.getCurrentNumber() == 3) {
            		if (customizeItemView.getCode().equals("")|| customizeItemView.getPriceCode().equals("")) {
            			 JOptionPane.showMessageDialog(null, "Add topping.");
            			 return;
            		}
            	}
            	int itemNumber = -1;
    	        switch (customizeItemView.getCode()) {
    	            case "A1":
    	                itemNumber = 0;
    	                break;
    	            case "A2":
    	                itemNumber = 1;
    	                break;
    	            case "A3":
    	                itemNumber = 2;
    	                break;
    	            case "B1":
    	                itemNumber = 3;
    	                break;
    	            case "B2":
    	                itemNumber = 4;
    	                break;
    	            case "B3":
    	                itemNumber = 5;
    	                break;
    	            case "C1":
    	                itemNumber = 6;
    	                break;
    	            case "C2":
    	                itemNumber = 7;
    	                break;
    	            case "C3":
    	                itemNumber = 8;
    	                break;
    	            case "D1":
    	                itemNumber = 9;
    	                break;
    	            case "D2":
    	                itemNumber = 10;
    	                break;
    	            case "D3":
    	                itemNumber = 11;
    	                break;
    	            default:
    	                itemNumber = 0;
    	                break;
    	        }
    	        
            	if (itemNumber == -1) {
             		 JOptionPane.showMessageDialog(null, "Input Item.");
             		 return;
             	}
    	        customizeItemView.setCode("");
    	        customizeItemView.setPriceCode("");
    	        customizeItemView.addCurrentNumber();
    	        if (customizeItemView.getCurrentNumber() >= 0 && customizeItemView.getCurrentNumber() < Main.specialVendingMachine.getParts().size()) {
    	            String set = Main.specialVendingMachine.getParts().get(customizeItemView.getCurrentNumber());
    	            customizeItemView.setFinish("Choose " + set);   
    	            customizeItemView.itemAdder(machineType);
    	        }else if (customizeItemView.getCurrentNumber() == Main.specialVendingMachine.getParts().size()) {
    	        	customizeItemView.hideButtons();
    	        	customizeItemView.setPriceCode(Double.toString(Main.specialVendingMachine.calculateTotalPrice(customizeItemView.getRecipe())));
    	        		Main.specialVendingMachine.addRecipe(customizeItemView.getRecipe(), "Custom Cake");
    	        		customizeItemView.setCurrentNumber(0);
    	        		customizeItemView.setFinish("");
    	           }
            }
        });
    }
    
    public Controller(MaintenancePageView maintenancePageView, String machineType) {
    	this.maintenancePageView = maintenancePageView;
        this.maintenancePageView.returner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	maintenancePageView.dispose();
                TestVendingMachinePageView open = new TestVendingMachinePageView(machineType);
                open.setVisible(true);
                new Controller(open, machineType);
            }
        });
        
        this.maintenancePageView.addItems(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
            	    Main.regularVendingMachine.getCashBox().resetTotalSales();
            	    for (Item item : Main.regularVendingMachine.getItemSlots()) {
            	        item.setSold(0);
            	    }
            	    try {
            	        Main.regularVendingMachine.getCashBox().getDeletedItems().clear();
            	    } catch (ConcurrentModificationException e1) {
            	    }
            	} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
            	    Main.specialVendingMachine.getCashBox().resetTotalSales();
            	    for (Item item : Main.specialVendingMachine.getItemSlots()) {
            	        item.setSold(0);
            	    }
            	    try {
            	        Main.specialVendingMachine.getCashBox().getDeletedItems().clear();
            	    } catch (ConcurrentModificationException e1) {
            	    }
            	}
        	    maintenancePageView.addItemsView();
            }
        });
        
        this.maintenancePageView.restock(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	maintenancePageView.restockView();
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
			    	Main.regularVendingMachine.getCashBox().resetTotalSales();
			    	for (Item item : Main.regularVendingMachine.getItemSlots()) {
			    		item.setSold(0);
			    	}
			    	for (Item item: Main.regularVendingMachine.getCashBox().getDeletedItems()) {
			    		Main.regularVendingMachine.getCashBox().getDeletedItems().remove(item);
			    	}
			    	
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null ) {
			    	Main.specialVendingMachine.getCashBox().resetTotalSales();
			    	for (Item item : Main.specialVendingMachine.getItemSlots()) {
			    		item.setSold(0);
			    	}
			    	for (Item item: Main.specialVendingMachine.getCashBox().getDeletedItems()) {
			    		Main.specialVendingMachine.getItemSlots().remove(item);
			    	}
			    }
            }
        });
        
        this.maintenancePageView.changePrice(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	maintenancePageView.changePriceView();
            }
        });
        
        this.maintenancePageView.replenishChange(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	maintenancePageView.replenishView();
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
			        StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			        for (Money m : Main.regularVendingMachine.getCashBox().getMoney()) {
			            allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
			        }
			        allDenoms.append("</html>");
			        maintenancePageView.setChange(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
			        StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			        for (Money m : Main.specialVendingMachine.getCashBox().getMoney()) {
			            allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
			        }
			        allDenoms.append("</html>");
			        maintenancePageView.setChange(allDenoms.toString());
			    }
            }
        });
        
        this.maintenancePageView.receipt(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	maintenancePageView.receiptView();
            	StringBuilder allDenoms = new StringBuilder("<html>Receipt - Total Earnings - ");
		        double totalEarnings = 0;

		        ArrayList<Item> itemsSlots = null;
		        ArrayList<Item> deletedItems = null;
		        if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItemSlots() != null) {
		        	deletedItems = Main.regularVendingMachine.getCashBox().getDeletedItems();
		            itemsSlots = Main.regularVendingMachine.getItemSlots();
		            totalEarnings = Main.regularVendingMachine.getCashBox().getTotalSales();
		        } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
		        	itemsSlots = Main.specialVendingMachine.getItemSlots();
		            totalEarnings = Main.specialVendingMachine.getCashBox().getTotalSales();
		        }

		        allDenoms.append(totalEarnings).append("<br>");
		        int count = 0;

		        if (itemsSlots != null) {
		            for (Item item : itemsSlots) {
		                String itemName = item.getItemName();
		                int quantitySold = item.getSold();
		                allDenoms.append("(" + (item.getQuantity() + quantitySold) + ")").append(itemName).append(" - ").append(quantitySold);

		                int numSpaces = 15 - itemName.length() - String.valueOf(quantitySold).length();
		                for (int i = 0; i < numSpaces; i++) {
		                    allDenoms.append("&nbsp;");
		                }

		                count++;
		                if (count % 2 == 0) {
		                    allDenoms.append("<br>");
		                }
		            }
		        }
		        if (deletedItems != null && !deletedItems.isEmpty()) {
		            for (Item item : deletedItems) {
		            	if (item != null)
		                allDenoms.append("(" + (item.getQuantity() + item.getSold()) + ")").append(item.getItemName()).append(" - ").append(item.getSold());
		            }
		        }

		        allDenoms.append("</html>");
		        maintenancePageView.setReceiptText(allDenoms.toString());
		        allDenoms.append("</html>");
		        maintenancePageView.setReceiptText(allDenoms.toString());
            }
        });
        
        
        this.maintenancePageView.customize(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if ( maintenancePageView.getCustomize()== true) {
            		maintenancePageView.incrementCur();
            	}
				if (maintenancePageView.getbtnCustomize().equals("Customize")) {
					maintenancePageView.setbtnCustomize("Next");
					maintenancePageView.setCustomize(true);
				} 
				if (maintenancePageView.getCurrentNumber() == 3)
					maintenancePageView.setbtnCustomize("Return");
				    if (maintenancePageView.getCurrentNumber() >= 0 && maintenancePageView.getCurrentNumber() < Main.specialVendingMachine.getParts().size()) {
				        String set = Main.specialVendingMachine.getParts().get(maintenancePageView.getCurrentNumber());
				        maintenancePageView.setFinish("Part: " + set);  
				    } else if (maintenancePageView.getCurrentNumber() == Main.specialVendingMachine.getParts().size()) {
				    	maintenancePageView.resetCur();
				    	maintenancePageView.setCustomize(false);
				    	maintenancePageView.setFinish("");
				    	maintenancePageView.setbtnCustomize("Customize"); 
				    } 
            		maintenancePageView.itemAdder(machineType);
            }
        });
        
        this.maintenancePageView.add5(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    Main.regularVendingMachine.getCashBox().getMoney()[0].replenish(1); 
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    Main.specialVendingMachine.getCashBox().getMoney()[0].replenish(1); 
				}

				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.regularVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.specialVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				}
            }
        });
        
        this.maintenancePageView.add10(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    Main.regularVendingMachine.getCashBox().getMoney()[1].replenish(1); 
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    Main.specialVendingMachine.getCashBox().getMoney()[1].replenish(1); 
				}

				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.regularVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.specialVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				}
            }
        });
        
        this.maintenancePageView.add20(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    Main.regularVendingMachine.getCashBox().getMoney()[2].replenish(1); 
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    Main.specialVendingMachine.getCashBox().getMoney()[2].replenish(1); 
				}

				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.regularVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.specialVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				}
            }
        });
        
        this.maintenancePageView.add50(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    Main.regularVendingMachine.getCashBox().getMoney()[3].replenish(1); 
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    Main.specialVendingMachine.getCashBox().getMoney()[3].replenish(1); 
				}

				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.regularVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.specialVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				}
            }
        });
        
        this.maintenancePageView.add100(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    Main.regularVendingMachine.getCashBox().getMoney()[4].replenish(1); 
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    Main.specialVendingMachine.getCashBox().getMoney()[4].replenish(1); 
				}

				if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.regularVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
				    StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    for (Money m : Main.specialVendingMachine.getCashBox().getMoney()) {
				        allDenoms.append("₱").append(m.getType()).append(" - Quantity: ").append(m.getQuantity()).append("<br>");
				    }
				    allDenoms.append("</html>");
				    maintenancePageView.setChange(allDenoms.toString());
				}
            }
        });
        
        this.maintenancePageView.addItem(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (!maintenancePageView.getbtnAddText().equals("Add Item")) {
                	if (maintenancePageView.getName().equals("")) {
               		 JOptionPane.showMessageDialog(null, "Input Item.");
               		 return;
               	}
            	}

            	int itemNumber = -1;
			    String nameText = maintenancePageView.getName();
			    if (!nameText.isEmpty()) {
			        if (nameText.equals("A1"))
			            itemNumber = 0;
			        else if (nameText.equals("A2"))
			            itemNumber = 1;
			        else if (nameText.equals("A3"))
			            itemNumber = 2;
			        else if (nameText.equals("B1"))
			            itemNumber = 3;
			        else if (nameText.equals("B2"))
			            itemNumber = 4;
			        else if (nameText.equals("B3"))
			            itemNumber = 5;
			        else if (nameText.equals("C1"))
			            itemNumber = 6;
			        else if (nameText.equals("C2"))
			            itemNumber = 7;
			        else if (nameText.equals("C3"))
			            itemNumber = 8;
			        else if (nameText.equals("D1"))
			            itemNumber = 9;
			        else if (nameText.equals("D2"))
			            itemNumber = 10;
			        else if (nameText.equals("D3"))
			            itemNumber = 11;
			        else{
			        	itemNumber = -1;}
			    }
			    
			    if (!maintenancePageView.getbtnAddText().equals("Add Item")) {
	            	if (itemNumber == -1) {
	              		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
	              		 return;
	              	}
	            	}

            	try {
		        if (maintenancePageView.getbtnAddText().equals("Add Item")) {
	            	if (maintenancePageView.getName().equals("") || maintenancePageView.getQuantity().equals("") || maintenancePageView.getPrice().equals("") || maintenancePageView.getCalories().equals("")) {
	            		 JOptionPane.showMessageDialog(null, "Fill up all fields.");
	            		 return;
	            	}
	                try {
	                    Integer.parseInt(maintenancePageView.getQuantity());
	                    Double.parseDouble(maintenancePageView.getPrice());
	                    Integer.parseInt(maintenancePageView.getCalories());
	                    
	                } catch (NumberFormatException e1) {
	                	JOptionPane.showMessageDialog(null, "Input valid numbers.");
	                	return;
	                } 

	            	if (Double.parseDouble(maintenancePageView.getPrice()) %5 != 0){
	            		JOptionPane.showMessageDialog(null, "Price must be divisible by 5.");
	            		return;
	            	}
		            if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
		                Main.regularVendingMachine.addItem(maintenancePageView.getName(), Integer.parseInt(maintenancePageView.getQuantity()), Double.parseDouble(maintenancePageView.getPrice()), Integer.parseInt(maintenancePageView.getCalories()));
		            } else if (machineType.equals("Special") && Main.specialVendingMachine != null && maintenancePageView.getCustomize() == false) {
		                Main.specialVendingMachine.addSellableItem(maintenancePageView.getName(), Integer.parseInt(maintenancePageView.getQuantity()), Double.parseDouble(maintenancePageView.getPrice()), Integer.parseInt(maintenancePageView.getCalories()));
		            } else if (machineType.equals("Special") && Main.specialVendingMachine != null && maintenancePageView.getCustomize() == true) {
		            	if (maintenancePageView.getCurrentNumber() == 0) {
		            		Main.specialVendingMachine.addFirstPart(maintenancePageView.getName(), Integer.parseInt(maintenancePageView.getQuantity()), Double.parseDouble(maintenancePageView.getPrice()), Integer.parseInt(maintenancePageView.getCalories()));
		            	} else if (maintenancePageView.getCurrentNumber() == 1) {
		            		Main.specialVendingMachine.addSecondPart(maintenancePageView.getName(), Integer.parseInt(maintenancePageView.getQuantity()), Double.parseDouble(maintenancePageView.getPrice()), Integer.parseInt(maintenancePageView.getCalories()));
		            	} else if (maintenancePageView.getCurrentNumber() == 2) {
		            		Main.specialVendingMachine.addThirdPart(maintenancePageView.getName(), Integer.parseInt(maintenancePageView.getQuantity()), Double.parseDouble(maintenancePageView.getPrice()), Integer.parseInt(maintenancePageView.getCalories()));
		            	} else if (maintenancePageView.getCurrentNumber() == 3) {
		            		Main.specialVendingMachine.addFourthPart(maintenancePageView.getName(), Integer.parseInt(maintenancePageView.getQuantity()), Double.parseDouble(maintenancePageView.getPrice()), Integer.parseInt(maintenancePageView.getCalories()));
		            	}
		            }
		        } else if (maintenancePageView.getbtnAddText().equals("Restock")) {
				    if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				    	Main.regularVendingMachine.getItem(itemNumber).setQuantity(Main.regularVendingMachine.getItem(itemNumber).getQuantity() + 1);
				    } else if (machineType.equals("Special") && Main.specialVendingMachine != null  && maintenancePageView.getCustomize() == false) {
				    	Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).setQuantity(Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getQuantity() + 1);
				    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && maintenancePageView.getCustomize() == true) {
				    	String itemName = "";
		    	        if (maintenancePageView.getCurrentNumber() == 0) {
		    	            itemName = Main.specialVendingMachine.getFirstPartName(itemNumber);
		    	        } else if (maintenancePageView.getCurrentNumber() == 1) {
		    	            itemName = Main.specialVendingMachine.getSecondPartName(itemNumber);
		    	        } else if (maintenancePageView.getCurrentNumber() == 2) {
		    	            itemName = Main.specialVendingMachine.getThirdPartName(itemNumber);
		    	        } else if (maintenancePageView.getCurrentNumber() == 3) {
		    	            itemName = Main.specialVendingMachine.getFourthPartName(itemNumber);
		    	        }     
		    	        
		    	        if(Main.specialVendingMachine.getItemCustomByName(itemName) == null) {
		                		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
		                		 return;
		    	        }
		            	if (maintenancePageView.getCurrentNumber() == 0) {
		            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getFirstPartName(itemNumber)).setQuantity(Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getFirstPartName(itemNumber)).getQuantity() + 1);
		            	} else if (maintenancePageView.getCurrentNumber() == 1) {
		            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getSecondPartName(itemNumber)).setQuantity(Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getSecondPartName(itemNumber)).getQuantity() + 1);
		            	} else if (maintenancePageView.getCurrentNumber() == 2) {
		            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getThirdPartName(itemNumber)).setQuantity(Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getThirdPartName(itemNumber)).getQuantity() + 1);
		            	} else if (maintenancePageView.getCurrentNumber() == 3) {
		            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getFourthPartName(itemNumber)).setQuantity(Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getFourthPartName(itemNumber)).getQuantity() + 1);		            	}
		            }	
		        } else if (maintenancePageView.getbtnAddText().equals("Change")){
	            	if (maintenancePageView.getName().equals("") || maintenancePageView.getPrice().equals("")) {
	            		 JOptionPane.showMessageDialog(null, "Fill up all fields.");
	            		 return;
	            	}
	            	try {
	                    Double.parseDouble(maintenancePageView.getPrice());
	                } catch (NumberFormatException e1) {
	                	JOptionPane.showMessageDialog(null, "Input valid numbers.");
	                	return;
	                } 
	            	if (Double.parseDouble(maintenancePageView.getPrice()) %5 != 0){
	            		JOptionPane.showMessageDialog(null, "New price must be divisible by 5.");
	            	}
		        	 if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
		        		 Main.regularVendingMachine.getItem(itemNumber).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
					    } else if (machineType.equals("Special") && Main.specialVendingMachine != null  && maintenancePageView.getCustomize() == false) {
					    	Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
					    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && maintenancePageView.getCustomize() == true) {
			    	        String itemName = "";
			    	        if (maintenancePageView.getCurrentNumber() == 0) {
			    	            itemName = Main.specialVendingMachine.getFirstPartName(itemNumber);
			    	        } else if (maintenancePageView.getCurrentNumber() == 1) {
			    	            itemName = Main.specialVendingMachine.getSecondPartName(itemNumber);
			    	        } else if (maintenancePageView.getCurrentNumber() == 2) {
			    	            itemName = Main.specialVendingMachine.getThirdPartName(itemNumber);
			    	        } else if (maintenancePageView.getCurrentNumber() == 3) {
			    	            itemName = Main.specialVendingMachine.getFourthPartName(itemNumber);
			    	        }     
			    	        
			    	        if(Main.specialVendingMachine.getItemCustomByName(itemName) == null) {
			                		 JOptionPane.showMessageDialog(null, "Input Valid Item.");
			                		 return;
			    	        }
			            	if (maintenancePageView.getCurrentNumber() == 0) {
			            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getFirstPartName(itemNumber)).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
			            	} else if (maintenancePageView.getCurrentNumber() == 1) {
			            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getSecondPartName(itemNumber)).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
			            	} else if (maintenancePageView.getCurrentNumber() == 2) {
			            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getThirdPartName(itemNumber)).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
			            	} else if (maintenancePageView.getCurrentNumber() == 3) {
			            		Main.specialVendingMachine.getItemCustomByName(Main.specialVendingMachine.getFourthPartName(itemNumber)).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
			            	}
			            }		
		        }
		        maintenancePageView.itemAdder(machineType);
            	}catch ( NullPointerException e1){
                	JOptionPane.showMessageDialog(null, "Input valid item.");
                	return;
            	}	
            }
        });
    }
    
}
