package ControlLayer;

import java.sql.Date;
import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

public class CtrPartOrder {
    public ArrayList<PartOrder> getAllPartOrder()
    {
      IFDBPartOrder dbPartOrder = new DbPartOrder();
      ArrayList<PartOrder> allPar = new ArrayList<PartOrder>();
      allPar = dbPartOrder.getAllPartOrders();
      return allPar;
    }
    
    public PartOrder findPartOrder(int id)
    {
        IFDBPartOrder dbPartOrder = new DbPartOrder();
        PartOrder singlePar = new PartOrder();
        singlePar = dbPartOrder.findPartOrder(id);
		return singlePar;
    }
    
    public PartOrder insertNew(int productId, int salesOrderId, int amount) throws Exception
    {    
    	PartOrder parObj = new PartOrder();
    	parObj.setAmount(amount);
    	parObj.setProductId(productId);
    	parObj.setSalesOrderId(salesOrderId);
         
         DbConnection.startTransaction();
         DbPartOrder dbPar = new DbPartOrder();
         PartOrder parObj2 = dbPar.insertPartOrder(parObj);
         DbConnection.commitTransaction();

         
         return parObj2;
    }
}
