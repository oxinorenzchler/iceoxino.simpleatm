package com.iceoxino.simpleatm;

import java.util.Scanner;

public class SimpleATM {
	
	public int pin;
	public long balance;
	
	public SimpleATM() {
		System.out.println("Qoute of the day: One does not simply walk into Mordor.");
		pin = 1234;
		balance = 0;
	}
	
	//Run program
	void run() {
		
		Scanner in = new Scanner(System.in);	
		System.out.println("\n*********\nEnter PIN\n*********\n");
		
		//Validate PIN
		boolean isPinValid = (in.nextInt() == pin) ? true : false;
		
		if(isPinValid) {

			//Select transaction
			boolean isContinued = true;
			
			while(isContinued) {
				
				printIntro();
				
				int txnType = in.nextInt();
				
				switch (txnType) {
				case 1: {
					
					System.out.println("\nEnter deposit amount.");
					deposit(in.nextLong());
					isContinued = checkContinuedProcess(in);
					break;
				}
				case 2: {
					
					System.out.println("\nEnter withdrawal amount.");
					withdraw(in.nextLong());
					isContinued = checkContinuedProcess(in);
					break;
				}
				case 3: {
					
					System.out.println("\n Current balance is: " + balance);
					
				}
				default:
					System.out.println(isContinued);
				}
				
			}
			
			
		}else {
			
			System.out.println("Incorrect PIN");
		}
		
		in.close();
		
	}
	
	//Deposit
	void deposit(long amount) {
		
		if(amount >= 1 ) {
			
			balance += amount;
			System.out.println("\nTransaction processed successfully. New balance is: " + balance);
		}else {
			
			System.out.println("\nInvalid amount. Minimum deposit amount is 1.");
			
		}
		
	}
	
	//Withdraw
	void withdraw(long amount) {
		
		System.out.println(balance);
		
		if(amount > 0 || amount <= balance && balance != 0) {
			
			balance -= amount;
			System.out.println("\nTransaction processed successfully. New balance is: " + balance);
			
		}else {
			
			System.out.println("\nInvalid amount or insufficient balance. Minimum amount withdrawal is 1.");
			
		}
	}
	
	//Check additional transaction
	boolean checkContinuedProcess(Scanner in) {
		
		System.out.println("\nDo you wish to proceed with another tranasaction?\nSelect 1(Yes) or 2(No)");
		
		
		int answer = in.nextInt();
		boolean result = true;
		
		
		if(answer < 1 || answer > 2) {
			System.out.println();
			result = false;
			System.out.println("\nInvalid choice. Please choice 1 or 2 only. Exiting process....");
		}else {
			
			if(answer == 2) {
				
				result = false;
				
				System.out.println("\nThank you! Have a nice day.");
			}
			
		}	
		return result;		
	}
	
	//Validate PIN
	boolean validatePin(int pin) {
		
		boolean isValid = false;
		
		if(this.pin == pin) {	
			isValid = true;
		}
		
		return isValid;
		
	}
	
	//Menu
	void printIntro() {
		
		System.out.println("\n*********************\n"
				+ "Select a transaction:\n*********************\n ");
		System.out.println("1. Deposit\n2. Widthraw\n3. Check Balance\n");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleATM st = new SimpleATM();
		
		st.run();
	
	}

}
