package com.capgemini.go.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.go.dto.RetailerInventoryDTO;

public interface RetailInventoryService {
	
public void getAllSoldItemDetails() throws SQLException;
public void getThisMonthlyShelfTimeReport(String R_ID,String Month ) throws SQLException;
public void getThisQuarterlyShelfTimeReport(String R_ID,String Quarter) throws SQLException;
public void getThisYearlyShelfTimeReport(String R_ID,String Year) throws SQLException;
public int R_IDExists1(String R_ID) throws SQLException;
	


}
