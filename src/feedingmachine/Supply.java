package feedingmachine;

class Supply {

    private String name;
    private int quantity;

    /**
     * Constructor of supply
     * @param name Name of supply
     */
    public Supply(String name) {
        this.name = name;
    }

    /**
     * Constructor
     * @param name Name of supply
     * @param quantity quantity of food
     */
    public Supply(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;

    }

    /**
     * @return Name of Box
     */
    public String getName() {
        return name;
    }

    /**
     * @return quantity of supply
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity set quantity of food for pet
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @pjavadoc: error - No public or protected classes found to document.aram amount amount of food for adding to box
     */
    public void add(int amount) {
        quantity += amount;
    }

    /**
     * @param toFeed quantity of food for feeding
     */
    public void feed(int toFeed) {
        quantity -= toFeed;
    }

}
