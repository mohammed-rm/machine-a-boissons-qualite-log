package model;

public class Order {
	private int IdOrder;
	private int drinkId;
	private int drinkQuantity;
	private int sugarQuantity;
	private boolean cup;
	private double water;
	private boolean cancel;

	/**
	 * Constructor
	 * @param idOrder
	 * @param drinkId
	 * @param drinkQuantity
	 * @param sugarQuantity
	 * @param cup
	 * @param water
	 * @param cancel
	 */
	public Order(int idOrder, int drinkId, int drinkQuantity, int sugarQuantity, boolean cup, double water,
			boolean cancel) {
		IdOrder = idOrder;
		this.drinkId = drinkId;
		this.drinkQuantity = drinkQuantity;
		this.sugarQuantity = sugarQuantity;
		this.cup = cup;
		this.water = water;
		this.cancel = cancel;
	}

	/**
	 * @return the idOrder
	 */
	public int getIdOrder() {
		return IdOrder;
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
	public int getDrinkQuantity() {
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
	 * @return the water
	 */
	public double getWater() {
		return water;
	}

	/**
	 * @return the cancel
	 */
	public boolean isCancel() {
		return cancel;
	}

	/**
	 * @param idOrder the idOrder to set
	 */
	public void setIdOrder(int idOrder) {
		IdOrder = idOrder;
	}

	/**
	 * @param drinkId the drinkId to set
	 */
	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	/**
	 * @param drinkQuantity the drinkQuantity to set
	 */
	public void setDrinkQuantity(int drinkQuantity) {
		this.drinkQuantity = drinkQuantity;
	}

	/**
	 * @param sugarQuantity the sugarQuantity to set
	 */
	public void setSugarQuantity(int sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
	}

	/**
	 * @param cup the cup to set
	 */
	public void setCup(boolean cup) {
		this.cup = cup;
	}

	/**
	 * @param water the water to set
	 */
	public void setWater(double water) {
		this.water = water;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

}
