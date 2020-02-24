package com.capgemini.go.Dao;
import com.capgemini.go.dto.RetailerInventoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RetailerInventoryDao {
	
public ArrayList<RetailerInventoryDTO>getSoldItemDetails() throws SQLException;
public ArrayList<RetailerInventoryDTO>getMonthlyShelfTimeReport(String R_ID,String Month ) throws SQLException;
public ArrayList<RetailerInventoryDTO>getQuarterlyShelfTimeReport(String R_ID,String Quarter) throws SQLException;
public ArrayList<RetailerInventoryDTO>getYearlyShelfTimeReport(String R_ID,String Year) throws SQLException;

public int R_IDExists(String R_ID) throws SQLException;
	

}
