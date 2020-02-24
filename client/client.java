package com.capgemini.go.client;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.go.exception.RetailerException;
import com.capgemini.go.service.RetailInventoryService;
import com.capgemini.go.service.RetailerServiceImpl;

public class client {

	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
	
		RetailInventoryService service = null;
		service = new RetailerServiceImpl();

	
			System.out.println("Select Operation");
			System.out.println("1 get all details");
			System.out.println("2.Show All details month wise");
			System.out.println("3.show details year wise");
			System.out.println("4.show details quarter wise");

			int op = scanner.nextInt();
            String R_ID=null;
			switch (op) {
			case 1:
				try {
					service.getAllSoldItemDetails();
				} catch (SQLException|RetailerException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 2:
				System.out.println("enter R_ID,month");
				R_ID=scanner.next();
				boolean b2=Pattern.compile("[1-9][0-9][0-9]").matcher(R_ID).matches();
				if(b2==false)
					throw new RetailerException("only 3 digit number are allowed in R_ID");
				String Month=scanner.next();
				boolean b5=Pattern.compile("[0-1][1-9]").matcher(Month).matches();
				if(b5==false)
					throw new RetailerException("Months could be between 01-12 only!");
				
				try {
					service.getThisMonthlyShelfTimeReport(R_ID, Month);;
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("enter R_ID,year");
				R_ID=scanner.next();
				boolean b1=Pattern.compile("[1-9][0-9][0-9]").matcher(R_ID).matches();
				if(b1==false)
					throw new RetailerException("only 3 digit number are allowed in R_ID");
				String Year=scanner.next();
				boolean b7=Pattern.compile("[1-9][1-9]").matcher(R_ID).matches();
				service.getThisYearlyShelfTimeReport(R_ID, Year);
			    break;
			case 4:
				System.out.println("enter R_ID,quarter");
				 R_ID=scanner.next();
				 boolean b3=Pattern.compile("[1-9][0-9][0-9]").matcher(R_ID).matches();
				 if(b3==false)
						throw new RetailerException("only 3 digit number are allowed in R_ID");
				String Quarter=scanner.next();
				boolean b4=Pattern.compile("[1-4]").matcher(R_ID).matches();
				if(b4==false)
					throw new  RetailerException("only 1,2,3,4 is allowed !");
				service.getThisQuarterlyShelfTimeReport(R_ID, Quarter);
				break;
			default:
				throw new RetailerException("Enter the valid option please!");
				
			}
		
		}

	}


