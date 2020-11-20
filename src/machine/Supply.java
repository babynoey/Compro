package machine;

class Supply {

    private String name;
    private int quantity;
    int getQuantity;

    public Supply(String name) {
        this.name = name;
    }

    public Supply(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void add(int amount) {
        quantity += amount;
    }

    public void feed(int toFeed) {
        quantity -= toFeed;
    }

}
