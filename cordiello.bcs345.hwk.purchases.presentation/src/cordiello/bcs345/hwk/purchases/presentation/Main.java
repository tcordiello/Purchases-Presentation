package cordiello.bcs345.hwk.purchases.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contains the main program.
 * 
 * @author Thomas Cordiello
 *
 * @version 4.0
 * @since 12/06/16
 */
public class Main {

	/**
	 * Contains the main program.
	 * Creates and allocates instances of the CustomerPurchaseConsoleUI,
	 * PurchaseCollectionConsoleUI class and the PurchaseGraphicalUI class
	 * then runs the ShowUI method of any of the 3 classes, or exits, depending on the users decisions.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean run = true;
		int decision = 0;
			
		
		//Start of UI
		while (run == true)
		{
			//Menu Display
			System.out.println("Choose UI\n"
							+  "---------\n"
							+ "1 - CustomerPurchaseConsoleUI\n"
							+ "2 - PurchaseCollectionConsoleUI\n"
							+ "3 - PurchasesGraphicalUI\n"
							+ "4 - Exit\n"
							+ "Enter Choice: ");
			
			//User input
			try{
				decision = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch(InputMismatchException ime){
				System.err.println("ERROR - Please input a number 1 - 4\n");
			}
			
			//Decision switch
			switch (decision)
			{
			//Option 1 - Starts the ShowUI method of the CustomerPurchaseConsoleUI class
				case 1:{
					CustomerPurchaseConsoleUI cpcUI = new CustomerPurchaseConsoleUI();
					cpcUI.ShowUI();
					break;
				}
				
				//Option 2 - Starts the ShowUI method of the PurchaseCollectionConsoleUI class
				case 2:{
					PurchaseCollectionConsoleUI pccUI = new PurchaseCollectionConsoleUI();
					pccUI.ShowUI();
					break;
				}
				
				//Option 3 - Starts the ShowUI method of the PurchasesGraphicalUI class
				case 3:{
					PurchasesGraphicalUI gui = new PurchasesGraphicalUI();
					gui.ShowUI();
					break;
				}

				//Option 4 - Exit
				case 4:{
					run = false;
					break;
				}
				
				default:{
					System.out.println("ERROR - Please input a number 1 - 4\n");
					break;
			}
		}
		
	}
		
	}

}




