package com.capgemini.go.Dao;

import java.util.ArrayList;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.go.dto.RetailerInventoryDTO;
import com.capgemini.go.util.DataBaseUtil;

public class RetailerInventoryDaoImpl implements RetailerInventoryDao{
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	RetailerInventoryDTO info;

	ArrayList<RetailerInventoryDTO> ar;

	public RetailerInventoryDaoImpl() throws SQLException {
		connection = DataBaseUtil.myconnection();
		connection.setAutoCommit(false);
	}

	@Override
	public ArrayList<RetailerInventoryDTO> getSoldItemDetails() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select * from retailertable2");
		ar = new ArrayList<>();
		while (rs.next()) {
			info = null;
			info = new RetailerInventoryDTO();
			info.setRetailerID(rs.getString(1));
			info.setProductCategory(rs.getString(2));
			info.setProductID(rs.getString(3));
			info.setProductUniqueID(rs.getString(4));
			info.setProductReceiveTimeStamp(rs.getTimestamp(5));
			info.setProductSaleTimeStamp(rs.getTimestamp(6));
			ar.add(info);
			
		}
		return ar ;
	}

	@Override
	public ArrayList<RetailerInventoryDTO> getMonthlyShelfTimeReport(String R_ID, String Month) throws SQLException {
		
		st = connection.createStatement();
		pst = connection.prepareStatement
				("select * from retailertable2 where retailerid=? and to_char(receive_TS,'MM')=?");
		pst.setString(1, R_ID);
		pst.setString(2, Month);
		rs = null;
		rs = pst.executeQuery();

        st.close();
		ar = new ArrayList<>();
		while (rs.next()) {
			info = null;
			info = new RetailerInventoryDTO();
			info.setRetailerID(rs.getString(1));
			info.setProductCategory(rs.getString(2));
			info.setProductID(rs.getString(3));
			info.setProductUniqueID(rs.getString(4));
			info.setProductReceiveTimeStamp(rs.getTimestamp(5));
			info.setProductSaleTimeStamp(rs.getTimestamp(6));
			ar.add(info);
		}
		return ar ;
	}

	@Override
	public ArrayList<RetailerInventoryDTO> getQuarterlyShelfTimeReport(String R_ID, String Quarter) throws SQLException {
		st = connection.createStatement();
		if(Quarter.equals("1"))
		{
			pst = connection.prepareStatement("select * from retailertable2 where retailerid=? and to_char(receive_TS,'MM')=any('01','02','03')");
			pst.setString(1, R_ID);
			rs = null;
			rs = pst.executeQuery();

			ar = new ArrayList<>();
			
			while (rs.next()) {
				info = null;
				info = new RetailerInventoryDTO();
				info.setRetailerID(rs.getString(1));
				info.setProductCategory(rs.getString(2));
				info.setProductID(rs.getString(3));
				info.setProductUniqueID(rs.getString(4));
				info.setProductReceiveTimeStamp(rs.getTimestamp(5));
				info.setProductSaleTimeStamp(rs.getTimestamp(6));
				ar.add(info);
			}
			return ar ;
	 
		}
		else if(Quarter.equals("2"))
		{
			pst = connection.prepareStatement("select * from retailertable2 where retailerID=? and to_char(receive_TS,'MM')=any('04','05','06') ");
			pst.setString(1, R_ID);
			rs = null;
			rs = pst.executeQuery();
			pst.close();
			ar = new ArrayList<>();
			while (rs.next()) {
				info = null;
				info = new RetailerInventoryDTO();
				info.setRetailerID(rs.getString(1));
				info.setProductCategory(rs.getString(2));
				info.setProductID(rs.getString(3));
				info.setProductUniqueID(rs.getString(4));
				info.setProductReceiveTimeStamp(rs.getTimestamp(5));
				info.setProductSaleTimeStamp(rs.getTimestamp(6));
				ar.add(info);
			}
			return ar ;
	
		}

			
		else if(Quarter.equals("3"))
		{
			pst = connection.prepareStatement("select * from retailertable2 where retailerID=? and to_char(receive_TS,'MM')=any('07','08','09') ");
			pst.setString(1, R_ID);
			rs = null;
			rs = pst.executeQuery();
          
			ar = new ArrayList<>();
			while (rs.next()) {
				info = null;
				info = new RetailerInventoryDTO();
				info.setRetailerID(rs.getString(1));
				info.setProductCategory(rs.getString(2));
				info.setProductID(rs.getString(3));
				info.setProductUniqueID(rs.getString(4));
				info.setProductReceiveTimeStamp(rs.getTimestamp(5));
				info.setProductSaleTimeStamp(rs.getTimestamp(6));
				ar.add(info);
			}
			return ar ;
	
		}	
		
		else if(Quarter.equals("4"))
		{
			pst = connection.prepareStatement("select * from retailertable2 where retailerID=? and to_char(receive_TS,'MM')=any('10','11','12') ");
			pst.setString(1, R_ID);
			rs = null;
			rs = pst.executeQuery();


		
			ar = new ArrayList<>();
			while (rs.next()) {
				info = null;
				info = new RetailerInventoryDTO();
				info.setRetailerID(rs.getString(1));
				info.setProductCategory(rs.getString(2));
				info.setProductID(rs.getString(3));
				info.setProductUniqueID(rs.getString(4));
				info.setProductReceiveTimeStamp(rs.getTimestamp(5));
				info.setProductSaleTimeStamp(rs.getTimestamp(6));
				ar.add(info);
			}
			return ar ;
		}
		return null;
		}
			

	@Override
	public ArrayList<RetailerInventoryDTO> getYearlyShelfTimeReport(String R_ID, String Year) throws SQLException {

		st = connection.createStatement();
		pst = connection.prepareStatement
				("select * from retailertable2 where retailerid=? and to_char(receive_TS,'YYYY')=?");
		pst.setString(1, R_ID);
		pst.setString(2, Year);
		rs = null;
		rs = pst.executeQuery();
       
		ar = new ArrayList<>();

		while (rs.next()) {
			info = null;
			info = new RetailerInventoryDTO();
			info.setRetailerID(rs.getString(1));
			info.setProductCategory(rs.getString(2));
			info.setProductID(rs.getString(3));
			info.setProductUniqueID(rs.getString(4));
			info.setProductReceiveTimeStamp(rs.getTimestamp(5));
			info.setProductSaleTimeStamp(rs.getTimestamp(6));
			ar.add(info);
		}
		return ar ;
	}

	@Override
	public int R_IDExists(String R_ID) throws SQLException {
		st = connection.createStatement();
		pst = connection.prepareStatement
				("select  * from retailertable2 where retailerid=?");
		pst.setString(1, R_ID);
		rs = null;
		rs = pst.executeQuery();
		st.close();
		if(rs.next()) {
			return 1;}
		else
			return -1;

	
	}
	
	
}
	

	


	