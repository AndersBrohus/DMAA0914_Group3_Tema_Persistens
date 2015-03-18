package ControlLayer;

import static org.junit.Assert.*;

import org.junit.Test;

import ControlLayer.*;

public class TestZipCodes {

	@Test
	public void test() {
		CtrZipCode zip = new CtrZipCode();
		
		System.out.println(zip.findAllZipCodes());
	}

}
