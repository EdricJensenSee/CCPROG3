	import java.util.*;
	
	/**
	* Represents the workings of the regular vending machine
	*/ 
	class RegularVendingMachine {
	    protected CashBox cashbox;
	    protected int totalItems, totalUnique;
	    protected int count;
	    protected HashMap<Integer, String> itemNumbers;
	    
		/**
	     * Constructs an instance of the RegularVendingMachine class.
	     */
	    public RegularVendingMachine() {
	    	Main.itemRegular = new Item();
	        cashbox = new CashBox();
	        itemNumbers = new HashMap<>();
	    }
	
	    public HashMap<Integer, String> getItemNumbers() {
			return itemNumbers;
		}
	
		public void setItemNumbers(HashMap<Integer, String> itemNumbers) {
			this.itemNumbers = itemNumbers;
		}
	
	    /**
	     * Returns the item in the vending machine.
	     *
	     * @return the item.
	     */
	    public Item getItem() {
	    	return Main.itemRegular;
	    }
	    
	    public CashBox getCashBox() {
	    	return cashbox;
	    }
	}
