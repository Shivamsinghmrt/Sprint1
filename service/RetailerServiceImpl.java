package com.capgemini.go.service;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.go.Dao.RetailerInventoryDao;
import com.capgemini.go.Dao.RetailerInventoryDaoImpl;
import com.capgemini.go.dto.RetailerInventoryDTO;
import com.capgemini.go.exception.RetailerException;

public class RetailerServiceImpl implements RetailInventoryService{
	RetailerInventoryDao dao;
	ArrayList<RetailerInventoryDTO> ar;
	RetailerInventoryDTO info;
	
	Scanner scanner = new Scanner(System.in);

	String R_ID,Month,Year,Quarter;


	@Override
	public void getAllSoldItemDetails() throws SQLException {
		
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getSoldItemDetails();
		for(RetailerInventoryDTO info1:ar) {
			
			//LocalDateTime sale_TS=info1.getProductSaleTimeStamp().toLocalDateTime();
			//LocalDateTime receive_TS=info1.getProductReceiveTimeStamp().toLocalDateTime();
			
			LocalDate sale_TS=info1.getProductSaleTimeStamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimeStamp().toLocalDateTime().toLocalDate();

			LocalDateTime sale_TS1=info1.getProductSaleTimeStamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimeStamp().toLocalDateTime();
			

			
			
			Duration duration=Duration.between(receive_TS1, sale_TS1);
            Period period=Period.between(receive_TS, sale_TS);		
	
            System.out.println(info1+" shelf time = "+"Y-"+period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays() +" "+duration);
		}
	}

	@Override
	public void getThisMonthlyShelfTimeReport(String R_ID, String Month) throws SQLException {
		if(R_IDExists1(R_ID)==-1) {
			throw new RetailerException("entry does not exists of this R_ID");}
		else {
		RetailerInventoryDTO info=new RetailerInventoryDTO();
		
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getMonthlyShelfTimeReport(R_ID, Month);
		for(RetailerInventoryDTO info1:ar) {
			
			LocalDate sale_TS=info1.getProductSaleTimeStamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimeStamp().toLocalDateTime().toLocalDate();

			LocalDateTime sale_TS1=info1.getProductSaleTimeStamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimeStamp().toLocalDateTime();
			

			
			
			Duration duration=Duration.between(receive_TS1, sale_TS1);
            Period period=Period.between(receive_TS, sale_TS);		
	
            System.out.println(info1+" shelf time = "+" Y-"+period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays() +" "+duration);
	
		}
		}
	}

	@Override
	public void getThisQuarterlyShelfTimeReport(String R_ID, String Quarter) throws SQLException {

		if(R_IDExists1(R_ID)==-1)
			throw new RetailerException("entry does not exists of this R_ID");
		else {
		
RetailerInventoryDTO info=new RetailerInventoryDTO();
		
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getQuarterlyShelfTimeReport(R_ID, Quarter);
		for(RetailerInventoryDTO info1:ar) {
			
			LocalDate sale_TS=info1.getProductSaleTimeStamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimeStamp().toLocalDateTime().toLocalDate();

			LocalDateTime sale_TS1=info1.getProductSaleTimeStamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimeStamp().toLocalDateTime();
			

			
			
			Duration duration=Duration.between(receive_TS1, sale_TS1);
            Period period=Period.between(receive_TS, sale_TS);		
	
            System.out.println(info1+" shelf time = "+" Y-"+period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays() +" "+duration);
		
		}
		}
		}
	

	@Override
	public  void getThisYearlyShelfTimeReport(String R_ID, String Year) throws SQLException {
		if(R_IDExists1(R_ID)==-1)
			throw new RetailerException("entry does not exists of this R_ID");
		else {
	
		RetailerInventoryDTO info=new RetailerInventoryDTO();
		
		dao=new RetailerInventoryDaoImpl();
		ar=new ArrayList();
		ar=dao.getYearlyShelfTimeReport(R_ID, Year);
		for(RetailerInventoryDTO info1:ar) {
			
			LocalDate sale_TS=info1.getProductSaleTimeStamp().toLocalDateTime().toLocalDate();
			LocalDate receive_TS=info1.getProductReceiveTimeStamp().toLocalDateTime().toLocalDate();

			LocalDateTime sale_TS1=info1.getProductSaleTimeStamp().toLocalDateTime();
			LocalDateTime receive_TS1=info1.getProductReceiveTimeStamp().toLocalDateTime();
			

			
			
			Duration duration=Duration.between(receive_TS1, sale_TS1);
            Period period=Period.between(receive_TS, sale_TS);		
	
            System.out.println(info1+" shelf time = "+" Y-"+period.getYears()+" M-"+period.getMonths()+" D-"+period.getDays() +" "+duration);
		
	}
		}
}

	@Override
	public int R_IDExists1(String R_ID) throws SQLException {
		dao=new RetailerInventoryDaoImpl();
	
		if(dao.R_IDExists(R_ID)==1) {
		return 1;}
		else if(dao.R_IDExists(R_ID)==-1) {
			return -1;}
		else
			return -1;
	}
}