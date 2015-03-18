package DBLayer;

public class DbZipCodes {
	
	private String buildQuery(String wClause)
	{
	    String query="SELECT * FROM ZipCodes";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
}
