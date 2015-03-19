package ModelLayer;

import java.sql.Date;

public class Stock {
	private int id;
	private int productId;
	private int amount;

	public Stock()
	{
		
	}
	
	public Stock(int productId ,int amount)
	{
		this.productId = productId;
		this.amount = amount;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
		String inv = id + " - " + productId + " - " + amount;
	    return inv;
	}
}
