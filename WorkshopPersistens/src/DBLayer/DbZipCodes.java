package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public class DbZipCodes implements IFDBZipCode {
	
    private  Connection con;
    /** Creates a new instance of DBZipCodes */
    public DbZipCodes() {
      con = DbConnection.getInstance().getDBcon();
    }
	
    public ArrayList<ZipCode> getAllZipCodes(boolean retriveAssociation)
    {
        return miscWhere("", false);
    }
    
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM ZipCodes";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private ArrayList<ZipCode> miscWhere(String wClause, boolean retrieveAssociation)
	{
        ResultSet results;
	    ArrayList<ZipCode> list = new ArrayList<ZipCode>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
	     	 ZipCode zipObj = new ZipCode();
		 zipObj = buildZipCode(results);	
                 list.add(zipObj);	
		}//end while
                 stmt.close();     			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private ZipCode buildZipCode(ResultSet results)
    {  
		ZipCode zipObj = new ZipCode();
        try
        { // the columns from the table ZipCode  are used
	        zipObj.setZipCode(results.getInt("zipCode"));
	        zipObj.setCity(results.getString("city"));
        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return zipObj;
    }
}
