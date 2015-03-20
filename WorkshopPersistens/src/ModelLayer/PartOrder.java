package ModelLayer;

public class PartOrder {
	private int id;
	private int productId;
	private int salesOrderId;
	private int amount;
	
	public PartOrder()
	{
		
	}

	public PartOrder(int productId, int salesOrderId, int amount) 
	{
		this.productId = productId;
		this.salesOrderId = salesOrderId;
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
	 * @return the salesOrderId
	 */
	public int getSalesOrderId() {
		return salesOrderId;
	}

	/**
	 * @param salesOrderId the salesOrderId to set
	 */
	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
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
	
	
}
