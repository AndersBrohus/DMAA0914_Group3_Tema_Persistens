package ControlLayer;

import static org.junit.Assert.*;

import org.junit.Test;

import ModelLayer.*;

public class TestProduct {

	@Test
	public void test() {
		CtrProduct pro = new CtrProduct();
		CtrStock sto = new CtrStock();
		CtrSupplier sup = new CtrSupplier();
		try{ 
			
		 /*Create new Stock*/
		 int id = pro.getLatest();
		 					/*Product ID - Amount*/
		 Stock stock = sto.insertNew(id, 50);
		 int stoId = stock.getId();
		 
		 /*Create new Supplier*/
		 													/*Name - Address - Country - Phone No - Mail*/
		 Supplier supplier = sup.insertNew("Lille Kinamand", "Lille Kinaland 1", "Kina", 88888888, "DenLilleKinaMand@KinaLand.dk");
		 int supId = supplier.getId();
		 
		 /*Create new product*/
		 
		 /*Name - purchasePrice - salesPrice - rentPrice - countryOfOrigin - stockId - supplierId - type - clothingSize - clothingColor - equipmentType - equipmentDescription - gunFabric - gunCalibre */
		 Product proObj = pro.insertNew("Tada", 100, 1000, 750, "China", stoId , supId, 1, "Tada", "Blue", "", "", "", "");
   	   
       }
       catch(Exception e){
       	System.out.println("Not working");
       	
       }
	}

}
