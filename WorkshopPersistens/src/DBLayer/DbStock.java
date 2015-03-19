package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbStock implements IFDBStock {
	private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbStock() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<Stock> getAllStock()
    {
        return miscWhere("");
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM Stock";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<Stock> miscWhere(String wClause)
	{
        ResultSet results;
	    ArrayList<Stock> list = new ArrayList<Stock>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			Stock stoObj = new Stock();
			stoObj = buildSupplier(results);	
                 list.add(stoObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private Stock buildSupplier(ResultSet results)
    {  
		Stock stoObj = new Stock();
        try
        { // the columns from the table ZipCode  are used
        	stoObj.setId(results.getInt("id"));
        	stoObj.setAmount(results.getInt("amount"));
        	stoObj.setProductId(results.getInt("productId"));

        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return stoObj;
    }
	
    public Stock findStock(int id)
    {   String wClause = "  id = " + id;
        return singleWhere(wClause);
    }
    
	private Stock singleWhere(String wClause)
	{
		ResultSet results;
		Stock stoObj = new Stock();
                
	    String query = buildQuery(wClause);
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			stoObj = buildSupplier(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	stoObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return stoObj;
	}
	
	@Override
    public Stock insertStock(Stock sto) throws Exception
    {
	   String query="INSERT INTO Stock(productId, amount)  VALUES("+
			 sto.getProductId() + "," +
	  		 sto.getAmount() + ")";
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
      Stock stoObj = getLatest();
      return stoObj;
    }
	
	private Stock getLatest()
	{
		ResultSet results;
		Stock stoObj = new Stock();
                
	    String query = "SELECT TOP 1 * FROM Stock ORDER BY id DESC;";
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			stoObj = buildSupplier(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	stoObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return stoObj;
	}
}
