package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbInvoice implements IFDBInvoice {
	private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbInvoice() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<Invoice> getAllInvoices()
    {
        return miscWhere("");
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM Invoice";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<Invoice> miscWhere(String wClause)
	{
        ResultSet results;
	    ArrayList<Invoice> list = new ArrayList<Invoice>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			Invoice invObj = new Invoice();
			invObj = buildInvoice(results);	
                 list.add(invObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private Invoice buildInvoice(ResultSet results)
    {  
		Invoice invObj = new Invoice();
        try
        { // the columns from the table ZipCode  are used
        	invObj.setInvoiceNo(results.getInt("invoiceNo"));
        	invObj.setAmount(results.getInt("amount"));
        	invObj.setPaymentDate(results.getDate("paymentDate"));
        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return invObj;
    }
	
    public Invoice findInvoice(int invoiceNo)
    {   String wClause = "  invoiceNo = " + invoiceNo;
        return singleWhere(wClause);
    }
    
	private Invoice singleWhere(String wClause)
	{
		ResultSet results;
		Invoice invObj = new Invoice();
                
	    String query = buildQuery(wClause);
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			invObj = buildInvoice(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	invObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return invObj;
	}
	
	@Override
    public Invoice insertInvoice(Invoice inv) throws Exception
    {
	   String query="INSERT INTO Invoice(amount)  VALUES("+
	  		inv.getAmount() + ")";
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
      Invoice invObj = getLatest();
      return invObj;
    }
	
	private Invoice getLatest()
	{
		ResultSet results;
		Invoice invObj = new Invoice();
                
	    String query = "SELECT TOP 1 * FROM Invoice ORDER BY invoiceNo DESC;";
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			invObj = buildInvoice(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	invObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return invObj;
	}
}
