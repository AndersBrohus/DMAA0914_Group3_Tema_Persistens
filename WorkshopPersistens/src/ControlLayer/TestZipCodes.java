package ControlLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ControlLayer.*;
import ModelLayer.*;

public class TestZipCodes {

	@Test
	public void test() {
		CtrZipCode zip = new CtrZipCode();
		ArrayList<ZipCode> zippies = zip.findAllZipCodes();
		
		for(ZipCode zipi : zippies)
		{
			System.out.println(zipi.getZipCode() + " - " + zipi.getCity());
		}
		System.out.println("----------");
		System.out.println(zip.findZipCode(9000));
	}
}
