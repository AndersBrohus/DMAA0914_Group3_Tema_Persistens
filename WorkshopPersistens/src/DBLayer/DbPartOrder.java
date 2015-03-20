package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbPartOrder implements IFDBPartOrder {
	private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbPartOrder() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<PartOrder> getAllPartOrders()
    {
        return miscWhere("");
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM PartOrder";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<PartOrder> miscWhere(String wClause)
	{
        ResultSet results;
	    ArrayList<PartOrder> list = new ArrayList<PartOrder>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			PartOrder parObj = new PartOrder();
			parObj = buildPartOrder(results);	
                 list.add(parObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private PartOrder buildPartOrder(ResultSet results)
    {  
		PartOrder parObj = new PartOrder();
        try
        { // the columns from the table ZipCode  are used
        	parObj.setId(results.getInt("id"));
        	parObj.setProductId(results.getInt("productId"));
        	parObj.setAmount(results.getInt("amount"));
        	parObj.setSalesOrderId(results.getInt("salesOrderId"));
        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return parObj;
    }
	
    public PartOrder findPartOrder(int id)
    {   String wClause = "  id = " + id;
        return singleWhere(wClause);
    }
    
	private PartOrder singleWhere(String wClause)
	{
		ResultSet results;
		PartOrder parObj = new PartOrder();
                
	    String query = buildQuery(wClause);
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			parObj = buildPartOrder(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	parObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return parObj;
	}
	
	@Override
    public PartOrder insertPartOrder(PartOrder par) throws Exception
    {
	   String query="INSERT INTO PartOrder(productId, salesOrderId, amount)  VALUES("+
			 par.getProductId() + "," +
	  		 par.getSalesOrderId() + "," +
			 par.getAmount() + ")";
       //System.out.println("insert : " + query);
      try{ // insert new employee +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("PartOrder ikke oprettet");
          throw new Exception ("PartOrder ikke oprettet");
       }
      PartOrder parObj = getLatest();
      return parObj;
    }
	
	private PartOrder getLatest()
	{
		ResultSet results;
		PartOrder parObj = new PartOrder();
                
	    String query = "SELECT TOP 1 * FROM PartOrder ORDER BY id DESC;";
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			parObj = buildPartOrder(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	parObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return parObj;
	}
}
