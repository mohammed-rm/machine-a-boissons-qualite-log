package model;

public class Stock {

    private int IdStock;
    private double water;
    private int smallCup;
    private int largeCup;
    private int sugar;

    public Stock(int idStock, double water, int smallCup, int largeCup, int sugar) {
        this.IdStock = idStock;
        this.water = water;
        this.smallCup = smallCup;
        this.largeCup = largeCup;
        this.sugar = sugar;
    }

    /**
     * @return the idStock
     */
    public int getIdStock() {
        return IdStock;
    }

    /**
     * @return the water
     */
    public double getWater() {
        return water;
    }

    /**
     * @return the smallCup
     */
    public int getSmallCup() {
        return smallCup;
    }

    /**
     * @return the largeCup
     */
    public int getLargeCup() {
        return largeCup;
    }

    /**
     * @return the sugar
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * @param idStock the idStock to set
     */
    public void setIdStock(int idStock) {
        IdStock = idStock;
    }

    /**
     * @param water the water to set
     */
    public void setWater(double water) {
        this.water = water;
    }

    /**
     * @param smallCup the smallCup to set
     */
    public void setSmallCup(int smallCup) {
        this.smallCup = smallCup;
    }

    /**
     * @param largeCup the largeCup to set
     */
    public void setLargeCup(int largeCup) {
        this.largeCup = largeCup;
    }

    /**
     * @param sugar the sugar to set
     */
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public String toString() {
        return "id:" + this.IdStock + " ; water:" + this.getWater() + " ; SmallCup:" + this.getSmallCup() + " ; LargeCup:" + this.getLargeCup() + " ; sugar:" + this.getSugar();
    }

}
