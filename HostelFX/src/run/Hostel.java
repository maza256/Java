package run;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Hostel extends Application {
	
    private TenantList list;
    private int noOfRooms;
    
    private final int WIDTH = 800;
    private final int HEIGHT = 500;

    private Label titleLabel = new Label("Hostel Application");
    private Label roomLabel = new Label("Room");
    private TextField roomField1 = new TextField();
    private Label nameLabel = new Label("Name");
    private TextField nameField = new TextField();
    private Button addTenantButton = new Button("Add Tenant");
    private Button displayTenantsButton = new Button("Display Tenants");
    private Button remTenantButton = new Button("Remove Tenant");
    private Button saveQuitButton = new Button("Save and Quit");
    
    private TextArea displayArea1 = new TextArea();
    private Label roomLabel2 = new Label("Room");
    private TextField roomField2 = new TextField();
    private Label monthLabel = new Label("Month");
    private TextField monthField = new TextField();
    private Label amountLabel = new Label("Amount");
    private TextField amountField = new TextField();
    
    private Button makePaymentButton = new Button("Make Payment");
    private Button listPaymentsButton = new Button("List Payments");
    private TextArea displayArea2 = new TextArea();
    

    @Override
    public void start(Stage stage)
    {
        HBox roomDetails = new HBox(10);
        HBox tenantButtons = new HBox(10);
        HBox paymentDetails = new HBox(10);
        HBox paymentButtons = new HBox(10);

        roomDetails.getChildren().addAll(roomLabel, roomField1, nameLabel, nameField);
        roomDetails.setAlignment(Pos.CENTER);
        roomDetails.setMaxWidth(WIDTH);
        roomDetails.setMinWidth(WIDTH);
        tenantButtons.getChildren().addAll(addTenantButton, displayTenantsButton, remTenantButton, saveQuitButton);
        tenantButtons.setAlignment(Pos.CENTER);
        tenantButtons.setMaxWidth(WIDTH);
        tenantButtons.setMinWidth(WIDTH);
        paymentDetails.getChildren().addAll(roomLabel2, roomField2, monthLabel, monthField, amountLabel, amountField);
        paymentDetails.setAlignment(Pos.CENTER);
        paymentDetails.setMaxWidth(WIDTH);
        paymentDetails.setMinWidth(WIDTH);
        paymentButtons.getChildren().addAll(makePaymentButton, listPaymentsButton);
        paymentButtons.setAlignment(Pos.CENTER);
        paymentButtons.setMaxWidth(WIDTH);
        paymentButtons.setMinWidth(WIDTH);
        VBox root = new VBox(10);
        root.getChildren().addAll(titleLabel, roomDetails, tenantButtons, displayArea1, paymentDetails,paymentButtons, displayArea2);
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(HEIGHT);
        root.setMaxHeight(HEIGHT);
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        addTenantButton.setOnAction(e -> addHandler());
        displayTenantsButton.setOnAction(e -> displayHandler());
        remTenantButton.setOnAction(e -> removeHandler());
        saveQuitButton.setOnAction(e -> saveAndQuitHandler());
        makePaymentButton.setOnAction(e -> paymentsHandler());
        listPaymentsButton.setOnAction(e -> listPaymentsHandler());

        noOfRooms = getNumberOfRooms();
        list = new TenantList(noOfRooms);
        TenantFileHandler.readRecords(list);
        stage.setScene(scene);
        stage.setTitle("Hostel Application");
        stage.show();
    }

    private int checkRoomNum(String roomNumber)
    {
        int retValue = -1;
        if(!roomNumber.isEmpty())
        {
            try{
                retValue = Integer.parseInt(roomNumber);
                if(retValue > noOfRooms || retValue < 1)
                    retValue = -1;
            }
            catch(Exception e) { }
        }
        return retValue;
    }

    private void addHandler()
    {
        int roomNum;
        if((!nameField.getText().isEmpty()) && (!roomField1.getText().isEmpty()))
        {
            roomNum = checkRoomNum(roomField1.getText());
            if(roomNum != -1)
            {
                if(list.search(roomNum) == null)
                {
                    Tenant newTenant = new Tenant(nameField.getText(), roomNum);
                    list.addTenant(newTenant);
                    displayArea1.setText("Added " + nameField.getText() + " into room " + roomNum);
                }
                else
                {
                	displayArea1.setText("Room is occupied");
                }
            }
            else
                displayArea1.setText("That is not a valid room number");
        }
    }

    private void displayHandler()
    {
        if(list.isEmpty())
        {
            displayArea1.setText("The hostel is currently empty");
        }
        else {
        	
        	StringBuffer toDisplay = new StringBuffer(noOfRooms * 2 * 20);
        	toDisplay.append("Room\tName\n");
        	
            for (int i = 1; i <= list.getTotal(); i++)
            {
            	toDisplay.append(Integer.toString(list.getTenant(i).getRoom()));
            	toDisplay.append("\t" + list.getTenant(i).getName() + "\n");
            }

            displayArea1.setText(toDisplay.toString());
        }
    }

    private void removeHandler() {
        int roomNum;
        if(roomField1.getText().isEmpty())
        {
            displayArea1.setText("Please input a room number to remove");
        }
        else {
            roomNum = checkRoomNum(roomField1.getText());
            if(roomNum != -1)
            {
                Tenant t = list.search(roomNum);
                if(t != null)
                {
                    list.removeTenant(roomNum);       
                    displayArea1.setText("Tenant removed");
 
                }
                else
                    displayArea1.setText("No such tenant");
            }
        }
    }

    String[] months = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

    private void paymentsHandler() {
        int roomNum = checkRoomNum(roomField2.getText());
        if((roomNum == -1) || list.search(roomNum) == null)
        {
            displayArea2.setText("No Valid Room Number");
            return;
        }
        String month = monthField.getText();
        for (String m : months)
        {
            if(m.compareTo(month.substring(0, 3).toLowerCase()) == 0)
            {
                month = m;
                break;
            }
            displayArea2.setText("Invalid month");
            return;
        }
        double amount;
        try {
            amount = Double.parseDouble(amountField.getText());
        }
        catch (Exception e) { 
            displayArea2.setText("Invalid amount");
            return;
        }

        Tenant ten = list.search(roomNum);
        Payment pay = new Payment(month, amount);
        ten.makePayment(pay);
        displayArea2.setText("Payment for " + month + " for " + amount + " made");
    }

    private void listPaymentsHandler() {
        int roomNum = checkRoomNum(roomField2.getText());
        if((roomNum == -1) || list.search(roomNum) == null)
        {
            displayArea2.setText("No Valid Room Number");
            return;
        }
        else { 
        	NumberFormat nf = NumberFormat.getCurrencyInstance();
            roomNum = checkRoomNum(roomField2.getText());
            Tenant t = list.search(roomNum);
            displayArea2.setText("Month\t\tAmount\n");
            PaymentList payments = t.getPayments();
            String s;
            for(int i = 1; i <= payments.getTotal(); i++)
            {
            	s = nf.format(payments.getPayment(i).getAmount());
            	displayArea2.appendText("" + payments.getPayment(i).getMonth() + "\t\t\t" + s +"\n");
            }
            
            displayArea2.appendText("Total Paid so far: " + nf.format(payments.calculateTotalPayments()));
        }
    }

    private void saveAndQuitHandler()
    {
        TenantFileHandler.saveRecords(list.getTotal(), list);
        Platform.exit();
    }

    private int getNumberOfRooms()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("How many rooms?");
        dialog.setTitle("Room Information Request");
        String response = dialog.showAndWait().get();
        return Integer.parseInt(response);
    }

    public static void main(String[] args)
    {
    	System.out.println("Hello World");
        launch(args);
    }
}