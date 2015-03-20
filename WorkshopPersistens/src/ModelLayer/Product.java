package ModelLayer;

public class Product {
	private int id;
	private String name;
	private int purchasePrice;
	private int salesPrice;
	private int rentPrice;
	private String countryOfOrigin;
	private int stockId;
	private int supplierId;
	private int type;
	private String clothingSize;
	private String clothingColor;
	private String equipmentType;
	private String equipmentDescription;
	private String gunFabric;
	private String gunCalibre;
	
	public Product(String name, int purchasePrice, int salesPrice,
			int rentPrice, String countryOfOrigin, int stockId, int supplierId,
			int type, String clothingSize, String clothingColor,
			String equipmentType, String equipmentDescription,
			String gunFabric, String gunCalibre) {
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.stockId = stockId;
		this.supplierId = supplierId;
		this.type = type;
		this.clothingSize = clothingSize;
		this.clothingColor = clothingColor;
		this.equipmentType = equipmentType;
		this.equipmentDescription = equipmentDescription;
		this.gunFabric = gunFabric;
		this.gunCalibre = gunCalibre;
	}
	
	public Product()
	{
		
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the purchasePrice
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the salesPrice
	 */
	public int getSalesPrice() {
		return salesPrice;
	}

	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * @return the rentPrice
	 */
	public int getRentPrice() {
		return rentPrice;
	}

	/**
	 * @param rentPrice the rentPrice to set
	 */
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	/**
	 * @return the countryOfOrigin
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	 * @param countryOfOrigin the countryOfOrigin to set
	 */
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the clothingSize
	 */
	public String getClothingSize() {
		return clothingSize;
	}

	/**
	 * @param clothingSize the clothingSize to set
	 */
	public void setClothingSize(String clothingSize) {
		this.clothingSize = clothingSize;
	}

	/**
	 * @return the clothingColor
	 */
	public String getClothingColor() {
		return clothingColor;
	}

	/**
	 * @param clothingColor the clothingColor to set
	 */
	public void setClothingColor(String clothingColor) {
		this.clothingColor = clothingColor;
	}

	/**
	 * @return the equipmentType
	 */
	public String getEquipmentType() {
		return equipmentType;
	}

	/**
	 * @param equipmentType the equipmentType to set
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	/**
	 * @return the equipmentDescription
	 */
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	/**
	 * @param equipmentDescription the equipmentDescription to set
	 */
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	/**
	 * @return the gunFabric
	 */
	public String getGunFabric() {
		return gunFabric;
	}

	/**
	 * @param gunFabric the gunFabric to set
	 */
	public void setGunFabric(String gunFabric) {
		this.gunFabric = gunFabric;
	}

	/**
	 * @return the gunCalibre
	 */
	public String getGunCalibre() {
		return gunCalibre;
	}

	/**
	 * @param gunCalibre the gunCalibre to set
	 */
	public void setGunCalibre(String gunCalibre) {
		this.gunCalibre = gunCalibre;
	}

	
	
}
