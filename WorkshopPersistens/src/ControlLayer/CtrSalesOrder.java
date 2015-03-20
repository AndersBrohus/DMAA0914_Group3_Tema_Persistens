package ControlLayer;

import java.sql.Date;
import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

public class CtrSalesOrder {
	public CtrSalesOrder()
	{
		
	}
	
    public ArrayList<SalesOrder> getAllSalesOrder()
    {
      IFDBSalesOrder dbSalesOrder = new DbSalesOrder();
      ArrayList<SalesOrder> allOrd = new ArrayList<SalesOrder>();
      allOrd = dbSalesOrder.getAllSalesOrder();
      return allOrd;
    }
    
    public SalesOrder findSalesOrder(int id)
    {
        IFDBSalesOrder dbSalesOrder = new DbSalesOrder();
        SalesOrder singleOrd = new SalesOrder();
        singleOrd = dbSalesOrder.findSalesOrder(id);
		return singleOrd;
    }
    
    public SalesOrder insertNew(int amount, String deliveryStatus, String deliveryDate, int customerId, int inoviceNo) throws Exception
    {    
    	SalesOrder ordObj = new SalesOrder();
    	ordObj.setAmount(amount);
    	ordObj.setCustomerId(customerId);
    	ordObj.setDeliveryDate(deliveryDate);
    	ordObj.setInvoiceNo(inoviceNo);
    	ordObj.setDeliveryStatus(deliveryStatus);
         
         DbConnection.startTransaction();
         DbSalesOrder dbOrd = new DbSalesOrder();
         SalesOrder ordObj2 = dbOrd.insertSalesOrder(ordObj);
         DbConnection.commitTransaction();

         
         return ordObj2;
    }
}
