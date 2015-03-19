package ControlLayer;

import static org.junit.Assert.*;

import org.junit.Test;

import ModelLayer.*;

public class TestInvoice {

	@Test
	public void test() {
		CtrInvoice inv = new CtrInvoice();
		
		try{ 
   	     Invoice invObj = inv.insertNew(12345678);
       }
       catch(Exception e){
       	System.out.println("Not working");
       	
       }
	}

}

