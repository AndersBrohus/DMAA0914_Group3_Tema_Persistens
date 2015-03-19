package ControlLayer;

import static org.junit.Assert.*;

import org.junit.Test;

import ModelLayer.*;

public class TestSupplier {

	@Test
	public void test() {
		CtrSupplier sup = new CtrSupplier();
		
		try{ 
   	     Supplier supObj = sup.insertNew("Test", "Test", "Test", 1234, "Test@test.dk");
   	     
   	     System.out.println(supObj.getId());
       }
       catch(Exception e){
       	System.out.println("Not working");
       	
       }
	}

}

