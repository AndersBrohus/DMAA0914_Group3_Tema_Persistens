package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbProduct implements IFDBProduct {
	private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbProduct() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<Product> getAllProduct()
    {
        return miscWhere("");
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM Product";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<Product> miscWhere(String wClause)
	{
        ResultSet results;
	    ArrayList<Product> list = new ArrayList<Product>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			Product proObj = new Product();
			proObj = buildProduct(results);	
                 list.add(proObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private Product buildProduct(ResultSet results)
    {  
		Product proObj = new Product();
        try
        { // the columns from the table ZipCode  are used
        	proObj.setId(results.getInt("id"));
        	proObj.setPurchasePrice(results.getInt("purchasePrice"));
        	proObj.setSalesPrice(results.getInt("salesPrice"));
        	proObj.setRentPrice(results.getInt("rentPrice"));
        	proObj.setStockId(results.getInt("stockId"));
        	proObj.setSupplierId(results.getInt("supplierId"));
        	proObj.setType(results.getInt("type"));
        	proObj.setName(results.getString("name"));
        	proObj.setCountryOfOrigin(results.getString("countryOfOrigin"));
        	proObj.setClothingSize(results.getString("clothingSize"));
        	proObj.setClothingColor(results.getString("clothingColor"));
        	proObj.setEquipmentType(results.getString("equipmentType"));
        	proObj.setEquipmentDescription(results.getString("equipmentDescription"));
        	proObj.setGunFabric(results.getString("gunFabric"));
        	proObj.setGunCalibre(results.getString("gunCalibre"));
        }
        catch(Exception e)
        {
        	System.out.println("error in building the product object");
        }
        return proObj;
    }
	
    public Product findProduct(int id)
    {   String wClause = "  id = " + id;
        return singleWhere(wClause);
    }
    
	private Product singleWhere(String wClause)
	{
		ResultSet results;
		Product proObj = new Product();
                
	    String query = buildQuery(wClause);
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			proObj = buildProduct(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	proObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return proObj;
	}
	
	@Override
    public Product insertProduct(Product pro) throws Exception
    {
	   String query="INSERT INTO Product(name, purchasePrice, salesPrice,rentPrice,countryOfOrigin,stockId,supplierId,type,clothingSize,clothingColor,equipmentType,equipmentDescription,gunFabric,gunCalibre)  VALUES('"+
			 pro.getName() + "'," +
	  		 pro.getPurchasePrice() + "," +
			 pro.getSalesPrice() + "," +
			 pro.getRentPrice() + ",'" +
			 pro.getCountryOfOrigin() + "'," +
			 pro.getStockId() + "," + pro.getSupplierId() + "," + pro.getType() + ",'" + pro.getClothingSize() + "','" + 
			 pro.getClothingColor() + "','" + pro.getEquipmentType() + "','" + pro.getEquipmentDescription() + "','" +
			 pro.getGunFabric() + "','" + pro.getGunCalibre() 
			 + "')";
       //System.out.println("insert : " + query);
      try{ // insert new employee +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("Employee ikke oprettet");
          throw new Exception ("Employee is not inserted correct");
       }
      Product proObj = getLatest();
      return proObj;
    }
	
	public Product getLatest()
	{
		ResultSet results;
		Product proObj = new Product();
                
	    String query = "SELECT TOP 1 * FROM Product ORDER BY id DESC;";
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			proObj = buildProduct(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	proObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return proObj;
	}
}
