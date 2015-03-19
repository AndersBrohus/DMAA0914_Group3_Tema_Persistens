package ControlLayer;

import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

public class CtrZipCode {
	
	public CtrZipCode()
	{
		
	}
	
    public ArrayList<ZipCode> findAllZipCodes()
    {
      IFDBZipCode dbZip = new DbZipCodes();
      ArrayList<ZipCode> allZip = new ArrayList<ZipCode>();
      allZip = dbZip.getAllZipCodes();
      return allZip;
    }
    
    public ZipCode findZipCode(int Zip)
    {
    	IFDBZipCode dbZip = new DbZipCodes();
		ZipCode singleZip = new ZipCode();
		singleZip = dbZip.findZipCode(Zip);
		return singleZip;
    }
	

}
