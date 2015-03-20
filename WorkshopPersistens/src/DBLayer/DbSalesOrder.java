package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbSalesOrder implements IFDBSalesOrder {
	private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbSalesOrder() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<SalesOrder> getAllSalesOrder()
    {
        return miscWhere("");
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM SalesOrder";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<SalesOrder> miscWhere(String wClause)
	{
        ResultSet results;
	    ArrayList<SalesOrder> list = new ArrayList<SalesOrder>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			SalesOrder ordObj = new SalesOrder();
			ordObj = buildSalesOrder(results);	
                 list.add(ordObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private SalesOrder buildSalesOrder(ResultSet results)
    {  
		SalesOrder ordObj = new SalesOrder();
        try
        { // the columns from the table ZipCode  are used
        	ordObj.setId(results.getInt("id"));
        	ordObj.setAmount(results.getInt("amount"));
        	ordObj.setCustomerId(results.getInt("customerId"));
        	ordObj.setInvoiceNo(results.getInt("invoiceNo"));
        	ordObj.setDate(results.getDate("date"));
        	ordObj.setDeliveryDate(results.getString("deliveryDate"));
        	ordObj.setDeliveryStatus(results.getString("deliveryStatus"));
        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return ordObj;
    }
	
    public SalesOrder findSalesOrder(int id)
    {   String wClause = "  id = " + id;
        return singleWhere(wClause);
    }
    
	private SalesOrder singleWhere(String wClause)
	{
		ResultSet results;
		SalesOrder ordObj = new SalesOrder();
                
	    String query = buildQuery(wClause);
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			ordObj = buildSalesOrder(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	ordObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return ordObj;
	}
	
	@Override
    public SalesOrder insertSalesOrder(SalesOrder ord) throws Exception
    {
	   String query="INSERT INTO SalesOrder(amount, deliveryStatus, deliveryDate, customerId, invoiceNo)  VALUES("+
			 ord.getAmount() + ",'" +
			 ord.getDeliveryStatus() + "','" +
			 ord.getDeliveryDate() + "'," + 
			 ord.getCustomerId() + "," + 
			 ord.getInvoiceNo() +
			 ")";
       //System.out.println("insert : " + query);
      try{ // insert new employee +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("SalesOrder ikke oprettet");
          throw new Exception ("SalesOrder ikke oprettet");
       }
      SalesOrder ordObj = getLatest();
      return ordObj;
    }
	
	private SalesOrder getLatest()
	{
		ResultSet results;
		SalesOrder ordObj = new SalesOrder();
                
	    String query = "SELECT TOP 1 * FROM SalesOrder ORDER BY id DESC;";
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			ordObj = buildSalesOrder(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	ordObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return ordObj;
	}
}
