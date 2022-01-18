package model;

public class Drink {
	private int IdDrink;
	private String name;
	private String description;
	private double price;

	public Drink(int idDrink, String name, String description, double price) {
		this.IdDrink = idDrink;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * @return the idDrink
	 */
	public int getIdDrink() {
		return IdDrink;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param idDrink the idDrink to set
	 */
	public void setIdDrink(int idDrink) {
		IdDrink = idDrink;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
