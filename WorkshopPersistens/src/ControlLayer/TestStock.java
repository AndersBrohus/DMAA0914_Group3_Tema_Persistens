package ControlLayer;

import static org.junit.Assert.*;

import org.junit.Test;

import ModelLayer.*;

public class TestStock {

	@Test
	public void test() {
		CtrStock sto = new CtrStock();
		
		try{ 
	   	     Stock stoObj = sto.insertNew(2, 500);
	   	     String stoString = "ProductId - " + stoObj.getProductId() + " Amount - " + stoObj.getAmount();
	   	     System.out.println(stoString);
	       }
	       catch(Exception e){
	       	System.out.println("Not working");
	       	
	       }
	}

}
