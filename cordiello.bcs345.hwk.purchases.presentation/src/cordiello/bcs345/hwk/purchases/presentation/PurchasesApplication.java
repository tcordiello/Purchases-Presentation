package cordiello.bcs345.hwk.purchases.presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import cordiello.bcs345.hwk.purchases.business.PurchaseCollection;
import javafx.application.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.*;

/**
 * @author Thomas Cordiello
 *
 * @version 1.0
 * @since 12/06/16
 */
public class PurchasesApplication extends Application{
	
	private PurchaseCollection pc = new PurchaseCollection();
	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem openMenuItem = new MenuItem("Open...");
	private MenuItem saveAsMenuItem = new MenuItem("Save As...");
	private MenuItem saveReportMenuItem = new MenuItem("Save Report...");
	private MenuItem exitMenuItem = new MenuItem("Exit");
	private ListView<String> listview;
	private ObservableList<String> items;
	private TabPane tp;
	private TextField firstNameTF;
	private TextField lastNameTF;
	private TextField numberTF;
	private TextField streetTF;
	private TextField cityTF;
	private TextField stateTF;
	private TextField zipTF;
	
	/**
	 * Creates the window for the application, including tabs, menus, and text fields.
	 * Also defines the events of each option of the application.
	 */
	@Override
	public void start(Stage stage1) throws Exception {
		
		tp = new TabPane();
		
		stage1.setTitle("Purchases Application");
		stage1.setHeight(500);
		stage1.setWidth(500);
		
		//setting up the tab vboxs
		VBox customerVbox = new VBox();
		VBox purchasesVbox = new VBox();
		
		//setting up the tabs
		Tab customerTab = new Tab("Customer");
		Tab purchasesTab = new Tab("Purchases");
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//setting up the Labels and text fields for the customer tab
		Label firstNameLabel = new Label("First Name");
		Label lastNameLabel = new Label("Last Name");
		Label numberLabel = new Label("Number");
		Label streetLabel = new Label("Street");
		Label cityLabel = new Label("City");
		Label stateLabel = new Label("State");
		Label zipLabel = new Label("Zip");
		firstNameTF = new TextField();
		lastNameTF = new TextField();
		numberTF = new TextField();
		streetTF = new TextField();
		cityTF = new TextField();
		stateTF = new TextField();
		zipTF = new TextField();
		firstNameTF.setEditable(false);
		firstNameTF.setMouseTransparent(true);
		firstNameTF.setFocusTraversable(false);
		lastNameTF.setEditable(false);
		lastNameTF.setMouseTransparent(true);
		lastNameTF.setFocusTraversable(false);
		numberTF.setEditable(false);
		numberTF.setMouseTransparent(true);
		numberTF.setFocusTraversable(false);
		streetTF.setEditable(false);
		streetTF.setMouseTransparent(true);
		streetTF.setFocusTraversable(false);
		cityTF.setEditable(false);
		cityTF.setMouseTransparent(true);
		cityTF.setFocusTraversable(false);
		stateTF.setEditable(false);
		stateTF.setMouseTransparent(true);
		stateTF.setFocusTraversable(false);
		zipTF.setEditable(false);
		zipTF.setMouseTransparent(true);
		zipTF.setFocusTraversable(false);
		customerVbox.getChildren().add(firstNameLabel);
		customerVbox.getChildren().add(firstNameTF);
		customerVbox.getChildren().add(lastNameLabel);
		customerVbox.getChildren().add(lastNameTF);
		customerVbox.getChildren().add(numberLabel);
		customerVbox.getChildren().add(numberTF);
		customerVbox.getChildren().add(streetLabel);
		customerVbox.getChildren().add(streetTF);
		customerVbox.getChildren().add(cityLabel);
		customerVbox.getChildren().add(cityTF);
		customerVbox.getChildren().add(stateLabel);
		customerVbox.getChildren().add(stateTF);
		customerVbox.getChildren().add(zipLabel);
		customerVbox.getChildren().add(zipTF);
		
		//setting up the list view
		listview = new ListView<String>();
		items = FXCollections.observableArrayList();
		listview.setItems(items);
		listview.setOrientation(Orientation.VERTICAL);
		
		//setting up the menu bar and file menu
		menuBar = new MenuBar();
		fileMenu = new Menu("File");
		menuBar.getMenus().add(fileMenu);
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
		fileMenu.getItems().add(openMenuItem);
		fileMenu.getItems().add(separatorMenuItem);
		fileMenu.getItems().add(saveAsMenuItem);
		fileMenu.getItems().add(saveReportMenuItem);
		fileMenu.getItems().add(separatorMenuItem2);
		fileMenu.getItems().add(exitMenuItem);
		
		//opens the file at the user specified location, specified from the FileChooser
		openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) 
			{
				FileReader fr; 
				FileReader fr2; 
				
				try {	
					FileChooser fileChooser = new FileChooser();
					FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
	                fileChooser.getExtensionFilters().add(extFilter);
					fileChooser.setTitle("Open Resource File");
					
					// pc.read(s);
					// Get the purchase array from PC				
					// Loop through the purchase array
					// add the current purchase string to the observable list
					
					File file = fileChooser.showOpenDialog(stage1);
					if (file != null){								
						String fileName = file.getName();
						fr = new FileReader(fileName);
						Scanner s = new Scanner(fr);
						fr2 = new FileReader(fileName);
						Scanner s2 = new Scanner(fr2);
						
						pc.Read(s);
						//pull from pc not scanner
						//create method in purchase collection to get the size
						firstNameTF.setText(pc.GetCustomer().getFirst());
						lastNameTF.setText(pc.GetCustomer().getLast());
						numberTF.setText(pc.GetCustomer().getAddress().getNumber());
						streetTF.setText(pc.GetCustomer().getAddress().getStreet());
						cityTF.setText(pc.GetCustomer().getAddress().getCity());
						stateTF.setText(pc.GetCustomer().getAddress().getState());
						zipTF.setText(pc.GetCustomer().getAddress().getZip());
						
						int size = pc.GetSize(s2);
						items.clear();
						for(int i = 0; i < size; i++){
							items.add(pc.GetByIndex(i).toString());
						}	
					}
			} 
				catch (FileNotFoundException e1){
					System.err.println("ERROR - File not found");
				}
				catch (Exception e2){
					e2.printStackTrace();	
				}
			}
		}
	);
		//saves the open file to the user specified location, specified from the FileChooser
		saveAsMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) 
			{
				PrintStream ps; 
				
				try {	
					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Save File");
					
					// pc.read(s);
					// Get the purchase array from PC				
					// Loop through the purchase array
					// add the current purchase string to the observable list
					
					File file = fileChooser.showSaveDialog(stage1);
					if (file != null){								
						ps = new PrintStream(file);
						
						pc.Write(ps);
							
					}
			} 
				catch (FileNotFoundException e1){
					System.err.println("ERROR - File not found");
				}
				catch (Exception e2){
					e2.printStackTrace();	
				}
			}
		}
	);
		//saves a generated report to the user specified location, specified from the FileChooser
		saveReportMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) 
			{
				PrintStream ps; 
				
				try {	
					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Save Report");
					
					// pc.read(s);
					// Get the purchase array from PC				
					// Loop through the purchase array
					// add the current purchase string to the observable list
					
					File file = fileChooser.showSaveDialog(stage1);
					if (file != null){								
						ps = new PrintStream(file);
						
						pc.Report(ps);
							
					}
			} 
				catch (FileNotFoundException e1){
					System.err.println("ERROR - File not found");
				}
				catch (Exception e2){
					e2.printStackTrace();	
				}
			}
		}
	);
		//exits the application, bringing the user back to the main console UI
		exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) 
			{
				stage1.close(); 
			} 
		}
	);
		
		//creating the main vbox and adding all controls to it
		VBox mainVbox = new VBox();
		mainVbox.getChildren().add(menuBar);
		mainVbox.getChildren().add(tp);
		customerTab.setContent(customerVbox);
		purchasesTab.setContent(purchasesVbox);
		tp.getTabs().add(customerTab);
		tp.getTabs().add(purchasesTab);	
		purchasesVbox.getChildren().add(listview);
		
		Scene scene = new Scene(mainVbox, 500, 500);
		stage1.setScene(scene);
		stage1.show();
		
	}

}










