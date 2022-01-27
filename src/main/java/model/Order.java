package model;

public class Order {
    private int drinkId;
    private double drinkQuantity;
    private int sugarQuantity;
    private boolean cup;
    private boolean cancel;

    public Order(int drinkId, double drinkQuantity, int sugarQuantity, boolean cup,
                 boolean cancel) {
        this.drinkId = drinkId;
        this.drinkQuantity = drinkQuantity; // 35 ou 75 (petit ou grand gobelet)
        this.sugarQuantity = sugarQuantity;
        this.cup = cup;                        // L'utilisateur utilise son gobelet
        this.cancel = cancel;
    }

    /**
     * @return the drinkId
     */
    public int getDrinkId() {
        return drinkId;
    }

    /**
     * @return the drinkQuantity
     */
    public double getDrinkQuantity() {
        return drinkQuantity;
    }

    /**
     * @return the sugarQuantity
     */
    public int getSugarQuantity() {
        return sugarQuantity;
    }

    /**
     * @return the cup
     */
    public boolean isCup() {
        return cup;
    }

    /**
     * @return the cancel
     */
    public boolean isCancel() {
        return cancel;
    }

    public String toString() {
        return "Order{" +
                "drinkId=" + drinkId +
                ", drinkQuantity=" + drinkQuantity +
                ", sugarQuantity=" + sugarQuantity +
                ", cup=" + cup +
                ", cancel=" + cancel +
                '}';
    }

}
