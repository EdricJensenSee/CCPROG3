public class Money {
    private int type;
    private int quantity;

    public Money(int type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public int getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void replenish(int quantity) {
        this.quantity += quantity;
    }
}