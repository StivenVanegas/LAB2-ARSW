package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000);
		
		pft.start();
		
		try{
			Thread.sleep(5*1000);
			pft.suspenderhilo();
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			System.out.println("Presione ENTER");
			String line = myObj.nextLine();  // Read user input
			if(line.equals("")){
				pft.renaudarhilo();
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
        }	
		/*
		PrimeFinderThread pft1=new PrimeFinderThread(0, 9999999);
		PrimeFinderThread pft2=new PrimeFinderThread(10000000, 19999999);
		PrimeFinderThread pft3=new PrimeFinderThread(20000000, 30000000);
		
		pft1.start();
		pft2.start();
		pft3.start();
		*/
		
		
	}
	
}