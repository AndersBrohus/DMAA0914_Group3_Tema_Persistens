package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbSupplier implements IFDBSupplier {
	private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbSupplier() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<Supplier> getAllSupplier()
    {
        return miscWhere("");
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM Supplier";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<Supplier> miscWhere(String wClause)
	{
        ResultSet results;
	    ArrayList<Supplier> list = new ArrayList<Supplier>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			Supplier supObj = new Supplier();
			supObj = buildSupplier(results);	
                 list.add(supObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private Supplier buildSupplier(ResultSet results)
    {  
		Supplier supObj = new Supplier();
        try
        { // the columns from the table ZipCode  are used
        	supObj.setCountry(results.getString("country"));
        	supObj.setAddress(results.getString("address"));
        	supObj.setEmail(results.getString("email"));
        	supObj.setName(results.getString("name"));
        	supObj.setPhoneNo(results.getInt("phoneNo"));
        	supObj.setId(results.getInt("id"));
        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return supObj;
    }
	
    public Supplier findSupplier(int id)
    {   String wClause = "  id = " + id;
        return singleWhere(wClause);
    }
    
	private Supplier singleWhere(String wClause)
	{
		ResultSet results;
		Supplier supObj = new Supplier();
                
	    String query = buildQuery(wClause);
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			supObj = buildSupplier(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	supObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return supObj;
	}
	
	@Override
    public Supplier insertSupplier(Supplier sup) throws Exception
    {
	   String query="INSERT INTO Supplier(name, address, country,phoneNo,email)  VALUES('"+
	  		sup.getName()  + "','"  +
	  		sup.getAddress()  + "','"  +
            sup.getCountry() + "'," +
            sup.getPhoneNo() + ",'" +
            sup.getEmail() + "')";
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
      Supplier supObj = getLatest();
      return supObj;
    }
	
	private Supplier getLatest()
	{
		ResultSet results;
		Supplier supObj = new Supplier();
                
	    String query = "SELECT TOP 1 * FROM Supplier ORDER BY id DESC;";
        //System.out.println(query);
        
		try
		{ 	// read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			supObj = buildSupplier(results);
	            
	            stmt.close();
			}
            else
            { 	//no employee was found
            	supObj = null;
            }
		}//end try	
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: "+e);
	 	}
		return supObj;
	}
}
