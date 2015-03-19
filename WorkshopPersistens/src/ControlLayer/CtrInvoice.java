package ControlLayer;

import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

public class CtrInvoice {
	public CtrInvoice()
	{
		
	}
	
    public ArrayList<Invoice> getAllInvoices()
    {
      IFDBInvoice dbInvoice = new DbInvoice();
      ArrayList<Invoice> allInv = new ArrayList<Invoice>();
      allInv = dbInvoice.getAllInvoices();
      return allInv;
    }
    
    public Invoice findZipCode(int invoiceNo)
    {
        IFDBInvoice dbInvoice = new DbInvoice();
        Invoice singleInv = new Invoice();
        singleInv = dbInvoice.findInvoice(invoiceNo);
		return singleInv;
    }
    
    public Invoice insertNew(int amount) throws Exception
    {    
    	 Invoice invObj = new Invoice();
         invObj.setAmount(amount);
         
         DbConnection.startTransaction();
         DbInvoice dbInv = new DbInvoice();
         Invoice invObj2 = dbInv.insertInvoice(invObj);
         DbConnection.commitTransaction();

         
         return invObj2;
    }
}
