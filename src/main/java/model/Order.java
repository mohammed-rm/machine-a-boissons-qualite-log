package model;

public class Order {
	private int drinkId;
	private int drinkQuantity;
	private int sugarQuantity;
	private boolean cup;
	private boolean cancel;

	public Order(int drinkId, int drinkQuantity, int sugarQuantity, boolean cup,
			boolean cancel) {
		this.drinkId = drinkId;
		this.drinkQuantity = drinkQuantity; // 35 ou 75 (petit ou grand gobelet)
		this.sugarQuantity = sugarQuantity;
		this.cup = cup;						// L'utilisateur utilise son gobelet
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
	 * @return the cancel
	 */
	public boolean isCancel() {
		return cancel;
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
	 * @param cancel the cancel to set
	 */
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public String toString() {
		return "Order{" +
				", drinkId=" + drinkId +
				", drinkQuantity=" + drinkQuantity +
				", sugarQuantity=" + sugarQuantity +
				", cup=" + cup +
				", cancel=" + cancel +
				'}';
	}

}
