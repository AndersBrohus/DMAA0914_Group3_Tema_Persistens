package ModelLayer;

public class ZipCode {
	private int zipCode;
	private String city;
	
	public ZipCode()
	{
		
	}
	
	public ZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}
	
	public ZipCode(int zipCode, String city)
	{
		this.zipCode = zipCode;
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	public String toString() {
		String zip = zipCode + " - " + city;
	    return zip;
	}
	
}
