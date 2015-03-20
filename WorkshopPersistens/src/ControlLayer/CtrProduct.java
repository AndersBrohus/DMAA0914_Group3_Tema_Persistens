package ControlLayer;

import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

public class CtrProduct {
	public CtrProduct()
	{
		
	}
	
    public ArrayList<Product> getAllProduct()
    {
      IFDBProduct dbProduct = new DbProduct();
      ArrayList<Product> allPro = new ArrayList<Product>();
      allPro = dbProduct.getAllProduct();
      return allPro;
    }
    
    public Product findProduct(int id)
    {
        IFDBProduct dbProduct = new DbProduct();
        Product singlePro = new Product();
        singlePro = dbProduct.findProduct(id);
		return singlePro;
    }
    
    public Product insertNew(String name, int purchasePrice, int salesPrice,
			int rentPrice, String countryOfOrigin, int stockId, int supplierId,
			int type, String clothingSize, String clothingColor,
			String equipmentType, String equipmentDescription,
			String gunFabric, String gunCalibre) throws Exception
    {    
    	Product proObj = new Product();
    	proObj.setName(name);
    	proObj.setPurchasePrice(purchasePrice);
		proObj.setSalesPrice(salesPrice);
		proObj.setRentPrice(rentPrice);
		proObj.setCountryOfOrigin(countryOfOrigin);
		proObj.setStockId(stockId);
		proObj.setSupplierId(supplierId);
		proObj.setType(type);
		proObj.setClothingSize(clothingSize);
		proObj.setClothingColor(clothingColor);
		proObj.setEquipmentDescription(equipmentDescription);
		proObj.setEquipmentType(equipmentType);
		proObj.setGunCalibre(gunCalibre);
		proObj.setGunFabric(gunFabric);
         
         DbConnection.startTransaction();
         DbProduct dbPro = new DbProduct();
         Product ProObj2 = dbPro.insertProduct(proObj);
         DbConnection.commitTransaction();

         
         return ProObj2;
    }
    
    public int getLatest()
    {
    	IFDBProduct dbProduct = new DbProduct();
        Product singlePro = dbProduct.getLatest();
        int id = singlePro.getId() + 1;
        return id;
    }
}
