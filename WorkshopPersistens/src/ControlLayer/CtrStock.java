package ControlLayer;

import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

public class CtrStock {
	public CtrStock()
	{
		
	}
    public ArrayList<Stock> getAllStock()
    {
      IFDBStock dbStock = new DbStock();
      ArrayList<Stock> allSto = new ArrayList<Stock>();
      allSto = dbStock.getAllStock();
      return allSto;
    }
    
    public Stock findStock(int id)
    {
        IFDBStock dbStock = new DbStock();
        Stock singleSto = new Stock();
        singleSto = dbStock.findStock(id);
		return singleSto;
    }
    
    public Stock insertNew(int productId, int amount) throws Exception
    {    
    	Stock stoObj = new Stock();
    	stoObj.setProductId(productId);
    	stoObj.setAmount(amount);
        
         DbConnection.startTransaction();
         DbStock dbSto = new DbStock();
         Stock stoObj2 = dbSto.insertStock(stoObj);
         DbConnection.commitTransaction();

         
         return stoObj2;
    }
}
