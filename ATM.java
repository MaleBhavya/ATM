package com.atm;

import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


class Required
{
	float CheckingsBalance;
	float SavingsBalance;
	
    HashMap<String,Integer> mp= new HashMap<>();
    HashMap<Float,String> ministmt= new HashMap<>();
	
	
	public void CheckPin()
	{
		mp.put("4281936507",7321);
		mp.put("5178920463",4892);
		mp.put("6098742315",1548);
		mp.put("7834015926",6743);
		System.out.println("Enter the Account Number:");
		Scanner sc=new Scanner(System.in);
		String enteredAN=sc.nextLine();
		System.out.println("Enter the Pin:");
		Scanner sc2=new Scanner(System.in);
		int enteredPIN=sc2.nextInt();
		boolean flag=false; 
		
		for(Entry<String, Integer> entry:mp.entrySet())
		{
			 String key = entry.getKey();
			   Integer value = entry.getValue();
			   if(key.equals(enteredAN) && value==enteredPIN )
			   {
				   flag=true;
			   }
		}
		if(flag)
		{
			selectAccount();
		}
		else
		{
			System.out.println("Incorrect Account Number or PIN");
			CheckPin();
		}
	}
	public void selectAccount()
	{
		System.out.println("Select the account you want to access:");
		System.out.println("1. Checking Account");
		System.out.println("2. Savings Account");
		System.out.println("3. EXIT");
		Scanner sc1=new Scanner(System.in);
		int selectOption=sc1.nextInt();
		if(selectOption==1)
		{
			checkingAccount();
		}
		else if(selectOption==2)
		{
			savingsAccount();
		}
		else if(selectOption==3)
		{
			System.out.println("Thank you for using the ATM. Goodbye!");
	        System.exit(0);
		}
	}
	public void checkingAccount()
	{
		System.out.println("Checking Account:");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Generate Mini Statement");
		System.out.println("5. Back");
		System.out.println("6. EXIT");
		Scanner sc1=new Scanner(System.in);
		int selectOption=sc1.nextInt();
		if(selectOption==1)
		{
			checkBalanceC();
		}
		else if(selectOption==2)
		{
			withDrawMoneyC();
		}
		else if(selectOption==3)
		{
			depositMoneyC();
		}
		else if(selectOption==4)
		{
			miniStatement();
			checkingAccount();
		}
		else if(selectOption==5)
		{
			selectAccount();
		}
		else if(selectOption==6)
		{
			System.out.println("Thank you for using the ATM. Goodbye!");
	        System.exit(0);
		}
		
		
	}
	public void savingsAccount()
	{
		System.out.println("Savings Account:");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Generate Mini Statement");
		System.out.println("5. Back");
		System.out.println("6. EXIT");
		Scanner sc1=new Scanner(System.in);
		int selectOption=sc1.nextInt();
		if(selectOption==1)
		{
			checkBalanceS();
		}
		else if(selectOption==2)
		{
			withDrawMoneyS();
		}
		else if(selectOption==3)
		{
			depositMoneyS();
		}
		else if(selectOption==4)
		{
			miniStatement();
			savingsAccount();
		}
		else if(selectOption==5)
		{
			selectAccount();
		}
		else if(selectOption==6)
		{
			return;
		}
		
	}
	public void miniStatement()
	{
		System.out.println("*****************************************");
		System.out.println("*                                       *");
		System.out.println("*  Here are your previous transactions  *");
		System.out.println("*                                       *");
		System.out.println("*****************************************");
		System.out.println("*---------------------------------------*");
		System.out.printf("*  %-10s| %-20s     *%n", "Amount", "Description");
		System.out.println("*---------------------------------------*");

		for (Map.Entry<Float, String> entry : ministmt.entrySet()) {
			if(entry.getValue()==" Withdrawn" )
			{
				System.out.printf("* -%-10.2f | %-20s    *%n", entry.getKey(), entry.getValue());
			}
			else if(entry.getValue()==" Deposited")
			{
				 System.out.printf("* +%-10.2f | %-20s    *%n", entry.getKey(), entry.getValue());
			}
		   
		}

		System.out.println("*---------------------------------------*");
		System.out.println("*          End of statement             *");
		System.out.println("*****************************************");


	}
	public void checkBalanceC()
	{
		System.out.println("Checking Balance: "+CheckingsBalance);
		checkingAccount();
	}
	public void withDrawMoneyC()
	{
		
		System.out.println("Enter amount to be withdrawn:");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		if(amount>CheckingsBalance)
		{
			System.out.println("Cannot draw money over the balance");
			checkingAccount();
		}
		else
		{
			ministmt.put(amount," Withdrawn");
			CheckingsBalance =CheckingsBalance-amount;
			System.out.println("Money withdrawn successfully");
			
		}
		checkBalanceC();
		
	}
	public void depositMoneyC()
	{
		System.out.println("Enter amount to be deposited:");
		Scanner sc=new Scanner(System.in);
		float depoAmount=sc.nextFloat();
		ministmt.put(depoAmount," Deposited");
		CheckingsBalance=CheckingsBalance+depoAmount;
		System.out.println("Money deposited Succesfully");
		checkBalanceC();
	}
	public void checkBalanceS()
	{
		System.out.println("Savings Balance: "+SavingsBalance);
		savingsAccount();
	}
	public void withDrawMoneyS()
	{
		System.out.println("Enter amount to be withdrawn:");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		if(amount>SavingsBalance)
		{
			System.out.println("Cannot draw money over the balance");
			savingsAccount();
		}
		else
		{
			ministmt.put(amount," Withdrawn");
			SavingsBalance =SavingsBalance-amount;
			System.out.println("Money withdrawn successfully");
			
		}
		checkBalanceS();
		
	}
	public void depositMoneyS()
	{
		System.out.println("Enter amount to be deposited:");
		Scanner sc=new Scanner(System.in);
		float depoAmount=sc.nextFloat();
		ministmt.put(depoAmount," Deposited");
		SavingsBalance=SavingsBalance+depoAmount;
		System.out.println("Money deposited Succesfully");
		checkBalanceS();
	}
	
	
}
public class ATM{
 
	public static void main(String[] args) {
		Required rq=new Required();
		 rq.CheckPin();
	}

}