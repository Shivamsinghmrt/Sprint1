package com.capgemini.go.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.go.Dao.RetailerInventoryDaoImpl;

public class RetailerInventoryDaoImplTest {
	RetailerInventoryDaoImpl  dao;
	@Before
	public void setUp() throws Exception {
	dao=new RetailerInventoryDaoImpl();
	}

	/*@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRetailerInventoryDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSoldItemDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMonthlyShelfTimeReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQuarterlyShelfTimeReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetYearlyShelfTimeReport() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testR_IDExists() throws SQLException {
		
	assertEquals(1,	dao.R_IDExists("129"));
	}

}
