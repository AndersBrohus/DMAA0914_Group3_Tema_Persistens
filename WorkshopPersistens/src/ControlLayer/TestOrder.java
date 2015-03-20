package ControlLayer;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ModelLayer.*;

public class TestOrder {

	@Test
	public void test() {
		CtrInvoice inv = new CtrInvoice();
		CtrSalesOrder ord = new CtrSalesOrder();
		CtrPartOrder par = new CtrPartOrder();
		
		try{ 
		/*Create new Invoice*/
		Invoice invObj = inv.insertNew(1000);
		int invoiceNo = invObj.getInvoiceNo();
		
		/*Create new Order*/
		SalesOrder ordObj = ord.insertNew(1000, "false", "10-10-2015", 1, invoiceNo);
		int ordNumb = ordObj.getId();
		
		/*Create new PartOrders*/
		PartOrder parObj = par.insertNew(1, ordNumb, 5);
		PartOrder parObj2 = par.insertNew(2, ordNumb, 10);
       }
       catch(Exception e){
       	System.out.println(e);
       	
       }
	}

}
