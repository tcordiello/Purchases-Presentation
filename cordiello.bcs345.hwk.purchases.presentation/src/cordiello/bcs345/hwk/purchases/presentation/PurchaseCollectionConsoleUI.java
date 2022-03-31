package cordiello.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import cordiello.bcs345.hwk.purchases.business.PurchaseCollection;

/** 
 * @author Thomas Cordiello
 *
 * @version 1.0
 * @since 11/11/16
 */
public class PurchaseCollectionConsoleUI {
	
	/**
	 * Shows the user interface for the Purchase Collection Console, 
	 * letting the user select what they want to do.
	 */
	public void ShowUI(){
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean run = true;
		int decision = 0;
		
		//Class declarations and memory allocation.
		PurchaseCollection pc = new PurchaseCollection();
		
		//Start of UI
		while (run == true)
		{
			//Menu Display
			System.out.println("PurchaseCollection UI\n"
							+ "----------------------\n"
							+ "1 - Read PurchaseCollection from file\n"
							+ "2 - Write PurchaseCollection to file\n"
							+ "3 - Show purchase by index\n"
							+ "4 - Show maximum purchase\n"
							+ "5 - Show PurchaseCollection as JSON string on screen\n"
							+ "6 - Show PurchaseCollection report on screen\n"
							+ "7 - Show PurchaseCollection toString on screen\n"
							+ "8 - Return to ConsoleUI Selection\n"
							+ "Enter Choice: ");
			
			//User input
			try{
				decision = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch(InputMismatchException ime){
				System.err.println("ERROR - Please input a number 1 - 8\n");
			}
			
			//Decision switch
			switch (decision)
			{
			//Option 1 - Read PurchaseCollection from file
				case 1:{
					
					String input;
					System.out.println("Please enter the name of the file you would like to load from: ");
					input = keyboard.nextLine();
					
					try {						
						FileReader fr = new FileReader(input);
						Scanner infile = new Scanner(fr);
												
						pc.Read(infile);
						System.err.println("\nLoad Successful\n");
					} 
					catch (FileNotFoundException e) {
						System.err.println("ERROR - File not found");
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}
					
					break;
				}
				
				//Option 2 - Write PurchaseCollection to file
				case 2:{
					String output;
					System.out.println("Please enter the name of the file you would like to write to: ");
					output = keyboard.nextLine();
					
					try {
						PrintStream ps = new PrintStream(output);
						
						pc.Write(ps);
						System.err.println("\nWrite Successful\n");
					} 
					catch (FileNotFoundException e) {
						System.err.println("ERROR - File not found");
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}
					
					break;
				}
				
				//Option 3 - Show purchase by index
				case 3:{
					int index=0;
					System.out.println("Enter the Purchase's index: ");
					
					try{
						index = keyboard.nextInt();
					}
					catch(InputMismatchException IME){
						System.err.println("ERROR - Please input an integer");
					}
					
					try{
						System.out.println(pc.GetByIndex(index));
						
						System.out.println("\nEnter \"x\" to return to menu\n");
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
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}
					catch(ArrayIndexOutOfBoundsException e){
						System.err.println("ERROR - Index invalid");
					}
					
					break;
				}
				
				//Option 4 - Show maximum purchase
				case 4:{
					try{
						System.out.println("Here is the maximum purchase:\n" + pc.GetMaxPurchase() + "\nEnter \"x\" to return to menu\n");
						
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
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}
					break;

				}	
				
				//Option 5 - Show PurchaseCollection as JSON string on screen
				case 5:{
					try{
					System.out.println(pc.GetJSON() + "\nEnter \"x\" to return to menu\n");
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}

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
				
				//Option 6 - Show PurchaseCollection report on screen
				case 6:{
					try{
						PrintStream ps = new PrintStream(System.out);
						pc.Report(ps);
						
						System.out.println("\nEnter \"x\" to return to menu\n");
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
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}
					
					break;
				}
				
				//Option 7 - Show PurchaseCollection toString on screen
				case 7:{
					try{
						System.out.println(pc.toString() + "\nEnter \"x\" to return to menu\n");
					}
					catch(NullPointerException NPE){
						System.err.println("ERROR - Array invalid");
					}

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
				
				//Option 8 - Exit
				case 8:{
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
