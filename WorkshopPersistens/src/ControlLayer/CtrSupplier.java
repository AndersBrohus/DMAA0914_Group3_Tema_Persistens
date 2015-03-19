package ControlLayer;

import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

public class CtrSupplier {
	public CtrSupplier()
	{
		
	}
	
    public ArrayList<Supplier> getAllSupplier()
    {
      IFDBSupplier dbSupplier = new DbSupplier();
      ArrayList<Supplier> allSup = new ArrayList<Supplier>();
      allSup = dbSupplier.getAllSupplier();
      return allSup;
    }
    
    public Supplier findSupplier(int id)
    {
        IFDBSupplier dbSupplier = new DbSupplier();
        Supplier singleSup = new Supplier();
        singleSup = dbSupplier.findSupplier(id);
		return singleSup;
    }
    
    public Supplier insertNew(String name, String address, String country, int phoneNo, String email) throws Exception
    {    
    	Supplier supObj = new Supplier();
    	supObj.setName(name);
    	supObj.setAddress(address);
    	supObj.setCountry(country);
    	supObj.setEmail(email);
        supObj.setPhoneNo(phoneNo);
        
         DbConnection.startTransaction();
         DbSupplier dbSup = new DbSupplier();
         Supplier supObj2 = dbSup.insertSupplier(supObj);
         DbConnection.commitTransaction();

         
         return supObj2;
    }
}
