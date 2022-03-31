package cordiello.bcs345.hwk.purchases.presentation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import cordiello.bcs345.hwk.purchases.business.Customer;
import cordiello.bcs345.hwk.purchases.business.Purchase;

/**
 * @author Thomas Cordiello
 *
 * @version 1.0
 * @since 10/23/16
 */
public class CustomerPurchaseConsoleUI {
	
	/**
	 * Shows the user interface for the Customer Purchase Console, 
	 * letting the user select what they want to do.
	 */
	public void ShowUI()
	{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean run = true;
		int decision = 0;
		
		//Class declarations and memory allocation.
		Customer cst = new Customer();
		Purchase pch = new Purchase();
		
		//Start of UI
		while (run == true)
		{
			//Menu Display
			System.out.println("Customer/Purchase UI\n"
							+ "----------------------\n"
							+ "1 - Read customer from file\n"
							+ "2 - Write customer to file\n"
							+ "3 - Show customer info on screen\n"
							+ "4 - Show customer JSON on screen\n"
							+ "5 - Read purchase from file\n"
							+ "6 - Write purchase to file\n"
							+ "7 - Show purchase info on screen\n"
							+ "8 - Show purchase JSON on screen\n"
							+ "9 - Return to ConsoleUI Selection\n\n"
							+ "Enter Choice: ");
			
			//User input
			try{
				decision = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch(InputMismatchException ime){
				System.err.println("ERROR - Please input a number 1 - 9\n");
			}
			
			//Decision switch
			switch (decision)
			{
			//Option 1 - Read Customer from File
				case 1:{
					String input;
					System.out.println("Please enter the name of the file you would like to load from: ");
					input = keyboard.nextLine();
					
					try {
						FileReader fr = new FileReader(input);
						Scanner infile = new Scanner(fr);
						
						cst.Read(infile);
						System.err.println("\nLoad Successful\n");
					} 
					catch (FileNotFoundException e) {
						System.err.println("ERROR - File not found");
					}
					break;
				}
				
				//Option 2 - Write Customer to File
				case 2:{
					String output;
					System.out.println("Please enter the name of the file you would like to write to: ");
					output = keyboard.nextLine();
					
					try {
						PrintStream ps = new PrintStream(output);
						
						cst.Write(ps);
						System.err.println("\nWrite Successful\n");
					} 
					catch (FileNotFoundException e) {
						System.err.println("ERROR - File not found");
					}
					break;
				}
				
				//Option 3 - Show Customer info on Screen
				case 3:{
					System.out.println(cst.toString() + "\nEnter \"x\" to return to menu\n");
					
					String key;
					key = keyboard.next();
					switch (key){
						case "x":{
							break;
						}
						default:{
							break;
						}
					}
					break;
				}
				
				//Option 4 - Show Customer JSON on Screen
				case 4:{
					System.out.println(cst.getJSON() + "\nEnter \"x\" to return to menu\n");
					
					String key;
					key = keyboard.next();
					switch (key){
						case "x":{
							break;
						}
						default:{
							break;
						}
					}
					break;
					
				}
				
				//Option 5 - Read purchase from file
				case 5:{
					String input;
					System.out.println("Please enter the name of the file you would like to load from: ");
					input = keyboard.nextLine();
					
					try {
						FileReader fr = new FileReader(input);
						Scanner infile = new Scanner(fr);
						
						pch.Read(infile);
						System.err.println("\nLoad Successful\n");
					} 
					catch (FileNotFoundException e) {
						System.err.println("ERROR - File not found");
					}
					break;
				}
				
				//Option 6 - Write purchase to file
				case 6:{
					String output;
					System.out.println("Please enter the name of the file you would like to write to: ");
					output = keyboard.nextLine();
					
					try {
						PrintStream ps = new PrintStream(output);
						
						pch.Write(ps);
						System.err.println("\nWrite Successful\n");
					} 
					catch (FileNotFoundException e) {
						System.err.println("ERROR - File not found");
					}
					break;
				}
				
				//Option 7 - Show Purchase info on screen
				case 7:{
					System.out.println(pch.toString() + "\nEnter \"x\" to return to menu\n");
					
					String key;
					key = keyboard.next();
					switch (key){
						case "x":{
							break;
						}
						default:{
							break;
						}
					}
					break;
				}
				
				//Option 8 - Show purchase JSON on screen
				case 8:{
					System.out.println(pch.getJSON() + "\n" + "\nEnter \"x\" to return to menu\n");
					
					String key;
					key = keyboard.next();
					switch (key){
						case "x":{
							break;
						}
						default:{
							break;
						}
					}
					break;
				}
				
				//Option 9 - Exit
				case 9:{
					run = false;
					break;
				}
				
				default:{
					System.out.println("ERROR - Please input a number 1 - 9\n");
					break;
			}
		}	
	}
}
}








