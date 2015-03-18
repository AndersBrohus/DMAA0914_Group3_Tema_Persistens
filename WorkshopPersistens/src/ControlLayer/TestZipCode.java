package ControlLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestZipCode {

	@Test
	public void test() {
		CtrZipCode zip = new CtrZipCode();
		
		System.out.println(zip.findAllZipCodes());
	}
}
