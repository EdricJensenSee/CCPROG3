import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller {
	private CreatePageView createPageView = new CreatePageView("");
	private CreateVendingMachineView createVendingMachineView = new CreateVendingMachineView();
	//private CustomizeItemView customizeItemView = new CustomizeItemView();
	private MaintenancePageView maintenancePageView = new MaintenancePageView("");
	private TestPageView testPageView = new TestPageView();
	private 	TestVendingMachinePageView testVendingMachinePageView = new TestVendingMachinePageView("");
	private 	VendingMachineView vendingMachineView = new VendingMachineView("");
    private MainPageView mainPageView;
    private AddItemView addItemView;
    private String machineType;
	private CustomizeItemView customizeItemView;

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
				int itemNumber = 0;
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
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null)
			    	if (Main.regularVendingMachine.getItemSlots().get(itemNumber).getPrice() != 0) 
			    		vendingMachineView.setPriceCode(String.valueOf(Main.regularVendingMachine.getItemSlots().get(itemNumber).getPrice()));
			    	else;
			    else if (machineType.equals("Special") && Main.specialVendingMachine != null) 
			    	if (Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getPrice() != 0) 
			    		vendingMachineView.setPriceCode(String.valueOf(Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getPrice()));
            }
        });
        
        this.vendingMachineView.buy(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (Double.parseDouble(vendingMachineView.getInsert()) < Double.parseDouble(vendingMachineView.getPriceCode())) {
					vendingMachineView.setFinish("Insufficient Payment");
				}
				int itemNumber = 0;
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
							   
				    if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
				        if (Main.regularVendingMachine.getCashBox().isItemAvailable(Main.regularVendingMachine.getItemSlots().get(itemNumber))) {
				            if (Main.regularVendingMachine.getItemSlots().get(itemNumber).getPrice() != 0) {
				                if (Main.regularVendingMachine.getCashBox().receivePayment(Main.regularVendingMachine.getItemSlots(), Main.regularVendingMachine.getItemSlots().get(itemNumber).getItemName(), Double.parseDouble(vendingMachineView.getInsert()))) {
				                    vendingMachineView.setOutput(Main.regularVendingMachine.getItemSlots().get(itemNumber).getItemName());
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
				                if (Main.specialVendingMachine.getCashBox().receivePayment(Main.specialVendingMachine.getItemSellable(), Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getItemName(), Double.parseDouble(vendingMachineView.getInsert()))) {
				                	vendingMachineView.setOutput(Main.specialVendingMachine.getItemSellableSlots().get(itemNumber).getItemName());
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
			        if (Main.regularVendingMachine.getCashBox().getDenominationsSpent().size() > 0) {
			            if (!Main.regularVendingMachine.getCashBox().getDenominationsSpent().isEmpty()) {
			                vendingMachineView.setWallet(String.valueOf(Main.regularVendingMachine.getCashBox().getDenominationsSpent().get(0)));
			            }
			        } else {
			        	vendingMachineView.setFinish("NOT ENOUGH CHANGE IN MACHINE");
			        }
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
			        Main.specialVendingMachine.getCashBox();
			        if (Main.specialVendingMachine.getCashBox().getDenominationsSpent().size() > 0) {
			            if (!Main.specialVendingMachine.getCashBox().getDenominationsSpent().isEmpty()) {
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
				    vendingMachineView.itemAdder();
				}
            }
            
        });
        
        this.vendingMachineView.claimProduct(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(Main.specialVendingMachine.getCashBox().getDenominationsSpent());
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
				if (machineType.equals("Regular")) {
			        int size = Main.regularVendingMachine.getCashBox().getDenominationsSpent().size();
			        if (vendingMachineView.getCurrentIndex()[0] == size) {
			        	vendingMachineView.getCurrentIndex()[0] = -1;
			            vendingMachineView.setWallet("");
			            Main.regularVendingMachine.getCashBox().getDenominationsSpent().clear();
			        } else if (vendingMachineView.getCurrentIndex()[0] >= 0 && vendingMachineView.getCurrentIndex()[0] < size) {
			        	vendingMachineView.setCollect("+" + String.valueOf(Main.regularVendingMachine.getCashBox().getDenominationsSpent().get(vendingMachineView.getCurrentIndex()[0])));
			        	vendingMachineView.getCurrentIndex()[0]++;
			            if (vendingMachineView.getCurrentIndex()[0] < size) {
			            	 vendingMachineView.setWallet(String.valueOf(Main.regularVendingMachine.getCashBox().getDenominationsSpent().get(vendingMachineView.getCurrentIndex()[0])));
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
			        if (vendingMachineView.getCurrentIndex()[0] == size) {
			        	vendingMachineView.getCurrentIndex()[0] = -1;
			            vendingMachineView.setWallet("");
			            Main.specialVendingMachine.getCashBox().getDenominationsSpent().clear();
			        } else if (vendingMachineView.getCurrentIndex()[0] >= 0 && vendingMachineView.getCurrentIndex()[0] < size) {
			        	vendingMachineView.setCollect("+" + String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(vendingMachineView.getCurrentIndex()[0])));
			        	vendingMachineView.getCurrentIndex()[0]++;
			            if (vendingMachineView.getCurrentIndex()[0] < size) {
			            	 vendingMachineView.setWallet(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(vendingMachineView.getCurrentIndex()[0])));
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

			}
        });
        
        this.vendingMachineView.customize(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            	maintenancePageView.dispose();
                TestVendingMachinePageView open = new TestVendingMachinePageView(machineType);
                open.setVisible(true);
                new Controller(open, machineType);
            }
        });
        
        this.maintenancePageView.customize(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if ( maintenancePageView.getCustomize()== true)
            		maintenancePageView.incrementCur();
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
				    maintenancePageView.itemAdder();
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
            	int itemNumber = 0;
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
			    }
		        if (maintenancePageView.getbtnAddText().equals("Add Item")) {
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
				    	Main.specialVendingMachine.getItemSellable().get(itemNumber).setQuantity(Main.specialVendingMachine.getItemSellable().get(itemNumber).getQuantity() + 1);
				    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && maintenancePageView.getCustomize() == true) {
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
		        	 if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
		        		 Main.regularVendingMachine.getItem(itemNumber).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
					    } else if (machineType.equals("Special") && Main.specialVendingMachine != null  && maintenancePageView.getCustomize() == false) {
					    	Main.specialVendingMachine.getItemSellable().get(itemNumber).setPrice(Double.parseDouble(maintenancePageView.getPrice()));
					    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && maintenancePageView.getCustomize() == true) {
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
		        maintenancePageView.itemAdder();
            }
        });
    }
    
}
