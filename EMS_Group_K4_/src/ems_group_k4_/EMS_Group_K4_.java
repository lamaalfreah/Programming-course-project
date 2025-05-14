package ems_group_k4_;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EMS_Group_K4_ extends Application
{
    public static void main(String[] args)  
    {
    Application.launch(args);
    }// end of main.
    Electronics electronicsFile = new Electronics();
    Clothes clothesFile = new Clothes();
    User admin = new User("Lama","1234");
    User customer = new User("Furat","4321"); 
    
    @Override
    public void start(Stage primaryStage)
    {
    Font font1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 32);  
    Font font2 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25);
    Font font3 = Font.font("Times New Roman", FontWeight.BOLD, 25);
    Font font4 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30);
    Font font5 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);

    
    
        
    
    //7- Buying Electronics Screen :)
    BorderPane BuyingElectronicBorderPane = new BorderPane();  
      
    Pane BuyingElectronicPane=new Pane();
    BuyingElectronicPane.setPadding(new Insets(10,100,100,100));
    BuyingElectronicPane.setLayoutX(200);
    BuyingElectronicPane.setLayoutY(15);
    
    GridPane BuyingElectronicGridPane=new GridPane();
    BuyingElectronicGridPane.setPadding(new Insets(280,120,100,140));
    BuyingElectronicGridPane.setHgap(15);
    BuyingElectronicGridPane.setVgap(15);
    
    Image BuyingElectronicImage=new Image("Electronic.jpg");
    ImageView BuyingElectronicImageView=new ImageView(BuyingElectronicImage);
    BuyingElectronicImageView.setFitHeight(270);
    BuyingElectronicImageView.setFitWidth(350); 
    BuyingElectronicPane.getChildren().add((BuyingElectronicImageView));
    
    Label itemID=new Label("itemID*: ");
    itemID.setFont(font4);
    TextField itemIDField=new TextField();
    
    Label itemName=new Label("itemName*: ");
    itemName.setFont(font4);
    TextField itemNameField=new TextField();   
    itemNameField.setPrefColumnCount(20);
    
    Label brand=new Label("Brand: "); 
    brand.setFont(font4);
    TextField brandField=new  TextField();
    
    Label model=new Label("Model: "); 
    model.setFont(font4);
    TextField modelField=new  TextField();
    
    Label quantity=new Label("Quantity: ");
    quantity.setFont(font4);
    TextField quantityField=new  TextField();
    
    Button buyButton=new Button("Buy");
    buyButton.setPrefSize(200, 60);
    buyButton.setFont(font2);
    buyButton.setStyle("-fx-background-color: #f2dba7");
    
    Button exitButton=new Button("Exit");
    exitButton.setFont(font2);
    exitButton.setPrefSize(200, 60);
    exitButton.setStyle("-fx-background-color: #f2dba7");
    
    BuyingElectronicGridPane.add(itemID, 0, 0);
    BuyingElectronicGridPane.add(itemIDField, 1, 0);
    BuyingElectronicGridPane.add(itemName, 0, 1);
    BuyingElectronicGridPane.add(itemNameField, 1, 1);
    BuyingElectronicGridPane.add(brand, 0, 2);
    BuyingElectronicGridPane.add(brandField, 1, 2);
    BuyingElectronicGridPane.add(model, 0, 3);
    BuyingElectronicGridPane.add(modelField, 1, 3);
    BuyingElectronicGridPane.add(quantity, 0, 4);
    BuyingElectronicGridPane.add(quantityField, 1, 4);
    BuyingElectronicGridPane.add(buyButton, 0, 6);
    BuyingElectronicGridPane.add(exitButton, 1, 6);
   
    Text alert2=new Text();
    alert2.setLayoutX(145);
    alert2.setLayoutY(635);
    alert2.setFont(font4);
    alert2.setStyle("-fx-font-size: 2.2em; ");
    alert2.setFill(Color.ROSYBROWN);
    
    buyButton.setOnAction( e -> 
    { 
    if(itemIDField.getText().isEmpty() || itemNameField.getText().isEmpty())
    {
    alert2.setText("*ItemID and ItemName are required fields");
    }// end of if.
    else
    {
        try
        {
            if(Electronics.match(itemIDField.getText())==false)
            {
            alert2.setText("Sorry we have no such item, please try again...");
            }// end of if.
           else
            {
            Electronics ElectronicsItem= new Electronics();
            ElectronicsItem.setItemID(Integer.parseInt(itemIDField.getText())); 
            ElectronicsItem.setItemName(itemNameField.getText());
            ElectronicsItem.setBrand(brandField.getText());
            ElectronicsItem.setModel(modelField.getText());
            String price= Electronics.findingPrice(itemIDField.getText());
            ElectronicsItem.setPrice(Integer.parseInt(price.trim()));
            alert2.setText(ElectronicsItem.orderSummary(Integer.parseInt(quantityField.getText()))+"\n    Thank you for your purchased!");
            alert2.setStyle("-fx-font-size: 1.75em; ");
            }// end of else.
        }// end of try.
        catch(Exception ex)
        {
        System.out.print(ex); 
        }// end of catch.
    }// end of else.
    });// end of event.
    
    exitButton.setOnAction( e -> { Platform.exit();});
    
    BuyingElectronicBorderPane.setStyle("-fx-background-color: #FFFFFF");
    BuyingElectronicBorderPane.getChildren().add(BuyingElectronicPane);
    BuyingElectronicBorderPane.setBottom(BuyingElectronicGridPane);
    BuyingElectronicBorderPane.getChildren().add(alert2);
    
    Scene BuyingElectronicScene=new Scene(BuyingElectronicBorderPane,800,700);
    Stage BuyingElectronicStage=new Stage();
    BuyingElectronicStage.setResizable(false);
    BuyingElectronicStage.setTitle("Buying Electronics Screen");
    BuyingElectronicStage.setScene(BuyingElectronicScene);
    
    
    
    
    
    //6- Buying Clothes Screen :)
    BorderPane BuyingClothesBorderPane=new BorderPane();
    
    GridPane BuyingClothesGridPane=new GridPane();
    BuyingClothesGridPane.setPadding(new Insets(280,120,100,140));
    BuyingClothesGridPane.setHgap(15);
    BuyingClothesGridPane.setVgap(15);
    
    Pane BuyingClothesPane=new Pane();
    BuyingClothesPane.setPadding(new Insets(50,100,100,100));
    BuyingClothesPane.setLayoutX(200);
    BuyingClothesPane.setLayoutY(15);
    
    Image BuyingClothesImage=new Image("Clothes.jpg");
    ImageView BuyingClothesImageView=new ImageView(BuyingClothesImage);
    BuyingClothesImageView.setFitHeight(290);
    BuyingClothesImageView.setFitWidth(350); 
    BuyingClothesPane.getChildren().add(BuyingClothesImageView);

    Label clothesItemID=new Label("itemID*: ");
    clothesItemID.setFont(font4);
    TextField clothesItemIDField=new TextField();
    
    Label clothesItemName=new Label("itemName*: ");
    clothesItemName.setFont(font4);
    TextField clothesItemNameField=new TextField();
    clothesItemNameField.setPrefColumnCount(20);
    
    Label clothesColor=new Label("Color: "); 
    clothesColor.setFont(font4);
    TextField clothesColorField=new TextField();
    
    Label department=new Label("Department: "); 
    department.setFont(font4);
    TextField departmentField=new TextField();
    
    Label clothesQuantity=new Label("Quantity: ");
    clothesQuantity.setFont(font4);
    TextField clothesQuantityField=new TextField();
    
    Button clothesBuyButton=new Button("Buy");
    clothesBuyButton.setPrefSize(200, 60);
    clothesBuyButton.setFont(font2);
    clothesBuyButton.setStyle("-fx-background-color: #f2dba7");
    
    Button exitButton1=new Button("Exit");
    exitButton1.setFont(font2);
    exitButton1.setPrefSize(200, 60);
    exitButton1.setStyle("-fx-background-color: #f2dba7");
    
    BuyingClothesGridPane.add(clothesItemID, 0, 0);
    BuyingClothesGridPane.add(clothesItemIDField, 1, 0);
    BuyingClothesGridPane.add(clothesItemName, 0, 1);
    BuyingClothesGridPane.add(clothesItemNameField, 1, 1);
    BuyingClothesGridPane.add(clothesColor, 0, 2);
    BuyingClothesGridPane.add(clothesColorField, 1, 2);
    BuyingClothesGridPane.add(department, 0, 3);
    BuyingClothesGridPane.add(departmentField, 1, 3);
    BuyingClothesGridPane.add(clothesQuantity, 0, 4);
    BuyingClothesGridPane.add(clothesQuantityField, 1, 4);
    BuyingClothesGridPane.add(clothesBuyButton, 0, 6);
    BuyingClothesGridPane.add(exitButton1, 1, 6);
   
    Text alert=new Text();
    alert.setLayoutX(145);
    alert.setLayoutY(635);
    alert.setFont(font4);
    alert.setStyle("-fx-font-size: 2.2em; ");
    alert.setFill(Color.ROSYBROWN);    

    exitButton1.setOnAction( e -> Platform.exit());
    
    clothesBuyButton.setOnAction( e -> 
    {
    if(clothesItemIDField.getText().isEmpty() || clothesItemNameField.getText().isEmpty())
    {
    alert.setText("*ItemID and ItemName are required fields");
    }// end of if.
    else
    {
      try
      {
          if(Clothes.match(clothesItemIDField.getText())==false)
          {
          alert.setText("Sorry we have no such item, please try again...");
          }// end of if.
          else
          {
          Clothes ClothesItem= new Clothes();
          ClothesItem.setItemID(Integer.parseInt(clothesItemIDField.getText())); 
          ClothesItem.setItemName(clothesItemNameField.getText());
          ClothesItem.setColor(clothesColorField.getText());
          ClothesItem.setDepartment(departmentField.getText());
          String price= Clothes.findingPrice(clothesItemIDField.getText());
          ClothesItem.setPrice(Integer.parseInt(price.trim()));
          alert.setText(ClothesItem.orderSummary(Integer.parseInt(clothesQuantityField.getText()))+"\n    Thank you for your purchased!");
          alert.setStyle("-fx-font-size: 1.75em; ");
          }// end of else. 
      }// end of try.
      catch(Exception ex)
      {
      System.out.print(ex); 
      }// end of catch.
    }// end of else.
    });// end of event.
   
    BuyingClothesBorderPane.setStyle("-fx-background-color: #FFFFFF");
    BuyingClothesBorderPane.getChildren().add(BuyingClothesPane);
    BuyingClothesBorderPane.setBottom(BuyingClothesGridPane);
    BuyingClothesBorderPane.getChildren().add(alert);
    Scene BuyingClothesScene=new Scene(BuyingClothesBorderPane,800,700);

    Stage BuyingClothesStage = new Stage();
    BuyingClothesStage.setResizable(false);
    BuyingClothesStage.setTitle("Buying Clothes Screen");
    BuyingClothesStage.setScene(BuyingClothesScene);
    
     



    //5- Customer Menu Screen :)
    BorderPane customerBorderPane = new BorderPane();
    
    FlowPane customerFlowPane=new FlowPane();
    customerFlowPane.setPadding(new Insets(350,250,200,290));
    customerFlowPane.setHgap(15);
    customerFlowPane.setVgap(20);
    
    Pane customerPane=new Pane();
    customerPane.setPadding(new Insets(100,100,100,100));
    customerPane.setLayoutX(270);
    customerPane.setLayoutY(40);

    Button firstButton=new Button("Electronics");
    firstButton.setStyle("-fx-background-color: #9fcec6");
    firstButton.setFont(font4);
    firstButton.setPrefSize(260, 70);
    firstButton.setOnAction(e -> BuyingElectronicStage.show());
    
    Button secondButton=new Button("Clothes");
    secondButton.setStyle("-fx-background-color: #f2dba7");
    secondButton.setFont(font4);
    secondButton.setPrefSize(260, 70);
    secondButton.setOnAction(e -> BuyingClothesStage.show());
    
    Button thirdButton=new Button("Exit");
    thirdButton.setStyle("-fx-background-color: #b9d4db");
    thirdButton.setFont(font4);
    thirdButton.setPrefSize(260, 70);
    thirdButton.setOnAction( e -> Platform.exit() );
    
    Image CustomerMenuImage=new Image("CustomerMenu.JPG");
    ImageView CustomerMenuImageView=new ImageView(CustomerMenuImage);
    CustomerMenuImageView.setFitHeight(290);
    CustomerMenuImageView.setFitWidth(350); 
    customerPane.getChildren().add(CustomerMenuImageView);  
  
    customerFlowPane.getChildren().addAll(firstButton,secondButton,thirdButton);
    customerBorderPane.setStyle("-fx-background-color: #FFFFFF");
    customerBorderPane.getChildren().add(customerPane);
    customerBorderPane.setBottom(customerFlowPane);
    
    Scene customerScene=new Scene(customerBorderPane,800,700);
    Stage customerStage = new Stage();
    customerStage.setResizable(false);
    customerStage.setTitle("Customer Menu Screen");
    customerStage.setScene(customerScene);
    
    
    
    
    //4- Deleting Screen :)
    VBox vbox = new VBox(20);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(50,100,50,100));
    
    HBox hbox= new HBox(20);
    hbox.setPadding(new Insets(10,10,50,120));
    
    BorderPane deleteBorderPane = new BorderPane();
    deleteBorderPane.setStyle("-fx-background-color: WHITE");
    
    Image deletingImage=new Image("Deleting.jpg");
    ImageView deletingImageImageView = new ImageView(deletingImage);
    vbox.getChildren().add(deletingImageImageView);  
    deletingImageImageView.setFitHeight(300);
    deletingImageImageView.setFitWidth(450);

    Text deleteLabel=new Text("Enter the item data separated by comma as the following:\n" +
     "itemID,itemName,brand,model,year,price\n" +
     "For example:\n" +
     "1001,Mobile Phone,Apple,iphone,2018,1500");
    deleteLabel.setFont(font5);
    vbox.getChildren().add(deleteLabel);

    TextField deleteTextField=new TextField();
    vbox.getChildren().add(deleteTextField);
    
    VBox vbox2 = new VBox(20);
    vbox2.setAlignment(Pos.CENTER);
    vbox2.setPadding(new Insets(20,50,70,50));
    Label label1 = new Label("Product deleted successfully :)");
    label1.setFont(font5);
    
    Button deleteClothesButton = new Button("Delete clothes");
    deleteClothesButton.setFont(font5);
    hbox.getChildren().add(deleteClothesButton);
    deleteClothesButton.setPrefSize(200,60);
    deleteClothesButton.setStyle("-fx-background-color: #b9d4db");
    deleteClothesButton.setOnAction(e -> 
    {
    try 
    {
    Clothes.deleteItem(deleteTextField.getText());
    vbox2.getChildren().add(label1);
   
    Electronics electronicsFile = new Electronics();
    Clothes clothesFile = new Clothes();
    electronicsFile.displayFile();
    clothesFile.displayFile();
    }// end of try.
    catch (Exception ex) 
    {
    System.out.print(ex);
    }// end of catch.
    });// end of event.
    
    Button deleteElectronicsButton = new Button("Delete electronics");
    deleteElectronicsButton.setFont(font5);
    hbox.getChildren().add(deleteElectronicsButton);
    deleteElectronicsButton.setPrefSize(200,60);
    deleteElectronicsButton.setStyle("-fx-background-color: #b9d4db");
    deleteElectronicsButton.setOnAction(e -> 
    {
    try 
    {
    Electronics.deleteItem(deleteTextField.getText());
    vbox2.getChildren().add(label1);
    
    Electronics electronicsFile = new Electronics();
    Clothes clothesFile = new Clothes();
    electronicsFile.displayFile();
    clothesFile.displayFile();
    }// end of try.
    catch (Exception ex) 
    {
    System.out.print(ex);
    }// end of catch.
    });// end of event.
    
    deleteBorderPane.setTop(vbox);
    deleteBorderPane.setCenter(hbox);
    deleteBorderPane.setBottom(vbox2);

    Scene deletingScene=new Scene(deleteBorderPane,700,800);
    Stage deletingStage = new Stage();
    deletingStage.setResizable(false);
    deletingStage.setTitle("Deleting an item Screen");
    deletingStage.setScene(deletingScene);
    
    
    
    
    //3- Add Screen :)
    VBox addVBox = new VBox(20);
    addVBox.setAlignment(Pos.CENTER);
    addVBox.setPadding(new Insets(50,100,50,100));
    addVBox.setStyle("-fx-background-color: WHITE");
    
    HBox addHBox = new HBox(20);
    addHBox.setAlignment(Pos.CENTER);
    addHBox.setPadding(new Insets(30,30,30,30));
    addHBox.setStyle("-fx-background-color: WHITE");
    
    Image addImage = new Image("add.jpg"); 
    ImageView addImageView = new ImageView(addImage);
    addVBox.getChildren().add(addImageView);
    addImageView.setFitHeight(300);
    addImageView.setFitWidth(450); 
    
    Label addLabel = new Label("Enter the item data separated by comma as the following:\n" +
    "itemID, itemName, brand, model, year, price\n" +
    "For example:\n" +
    "1001,Mobil Phone,Apple,iphone,2018,1500");
    addVBox.getChildren().add(addLabel);
    addLabel.setFont(font5);
    
    TextField addTextField = new TextField();
    addVBox.getChildren().add(addTextField);
    
    addVBox.getChildren().add(addHBox);
    
    Button clothesAddButton = new Button("Add clothes");
    clothesAddButton.setFont(font5);
    addHBox.getChildren().add(clothesAddButton);
    clothesAddButton.setPrefSize(200,60);
    clothesAddButton.setStyle("-fx-background-color: #b9d4db");
 
    Label label2 = new Label("Product added successfully :)");
    label2.setFont(font5);
    
    clothesAddButton.setOnAction(e -> 
    { 
    try
    {    
    FileWriter fileWriter = new FileWriter("clothes.txt",true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write(addTextField.getText());
    bufferedWriter.newLine();
    bufferedWriter.close();
    addVBox.getChildren().add(label2);
    
    Electronics electronicsFile = new Electronics();
    Clothes clothesFile = new Clothes();
    electronicsFile.displayFile();
    clothesFile.displayFile();
    }// end of try.
    catch(Exception ex)
    {
    System.out.print(ex); 
    }// end of catch.
    });// end of event.
    
    Button electronicsAddButton = new Button("Add Electronics");
    electronicsAddButton.setFont(font5);
    addHBox.getChildren().add(electronicsAddButton);
    electronicsAddButton.setPrefSize(200,60);
    electronicsAddButton.setStyle("-fx-background-color: #b9d4db");
    
    electronicsAddButton.setOnAction(e -> 
    { 
    try
    {    
    FileWriter fileWriter = new FileWriter("electronics.txt",true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.append(addTextField.getText());
    bufferedWriter.newLine();
    bufferedWriter.close();
    addVBox.getChildren().add(label2);
    
    Electronics electronicsFile = new Electronics();
    Clothes clothesFile = new Clothes();
    electronicsFile.displayFile();
    clothesFile.displayFile();
    }// end of try.
    catch(Exception ex)
    {
    System.out.print(ex); 
    }// end of catch.
    });// end of event.
        
    Scene addScene = new Scene (addVBox,700,800); 
    Stage addStage = new Stage();
    addStage.setResizable(false);
    addStage.setTitle("Add an item Screen");// Set the stage title 
    addStage.setScene(addScene);// Place the scene in the stage 
    
    
    
    
    //2- Admin Screen :)    
    VBox adminPane = new VBox(20);
    adminPane.setAlignment(Pos.CENTER);
    adminPane.setPadding(new Insets(50,150,50,150));
    adminPane.setStyle("-fx-background-color: WHITE");
        
    Image adminImage = new Image("admin.png"); 
    ImageView adminImageView = new ImageView(adminImage);
    adminPane.getChildren().add(adminImageView);
    adminImageView.setFitHeight(300);
    adminImageView.setFitWidth(240); 
    
    Button addItemButton = new Button("Add a new item ");
    addItemButton.setFont(font1);
    adminPane.getChildren().add(addItemButton);
    addItemButton.setStyle ("-fx-background-color: #9fcec6");
    addItemButton.setPrefSize(300,80);
    addItemButton.setOnAction(e -> addStage.show());
    
    Button deleteButton1 = new Button("Delete an item");
    deleteButton1.setFont(font1);
    adminPane.getChildren().add(deleteButton1);
    deleteButton1.setStyle("-fx-background-color: #f2dba7");
    deleteButton1.setPrefSize(300,80);
    deleteButton1.setOnAction(e -> deletingStage.show());
    
    Button exitButton2 = new Button("Exit");
    exitButton2.setFont(font1);
    adminPane.getChildren().add(exitButton2);
    exitButton2.setStyle("-fx-background-color: #b9d4db");
    exitButton2.setPrefSize(300,80);
    exitButton2.setOnAction( e -> Platform.exit());
    
    Scene adminScene = new Scene (adminPane,700,800);
    Stage adminStage = new Stage();
    adminStage.setResizable(false);
    adminStage.setTitle("Admin Screen"); // Set the stage title 
    adminStage.setScene(adminScene); // Place the scene in the stage 
    
    
    
    
    //1- Login Screen :)
    GridPane loginPane = new GridPane();
    loginPane.setVgap(20);
    loginPane.setHgap(20);   
    loginPane.setAlignment(Pos.CENTER);
    loginPane.setPadding(new Insets(50,0,50,0));
    loginPane.setStyle("-fx-background-color: WHITE");

    Label Label = new Label("E-Store Management System (EMS)");
    loginPane.add(Label,1,1);
    Label.setFont(font1);
    
    Label usernameLabel = new Label("Username");
    loginPane.add(usernameLabel,0,2);
    usernameLabel.setFont(font2);
    usernameLabel.setPrefWidth(150);
    
    TextField usernameTextField = new TextField();
    loginPane.add(usernameTextField,1,2);
    
    Label passwordLabel = new Label("Password");
    loginPane.add(passwordLabel,0,3);
    passwordLabel.setFont(font2);
    passwordLabel.setPrefWidth(150);
    
    TextField passwordTextField = new TextField();
    loginPane.add(passwordTextField,1,3);
    passwordTextField.setPrefWidth(20);

    Button loginButton = new Button("Login");
    loginPane.add(loginButton,1,4);
    loginButton.setFont(font1);
    loginButton.setPrefSize(200,60);
    loginButton.setStyle("-fx-background-color: #b9d4db");

    Image shopImage = new Image("shop.png"); 
    ImageView shopImageView = new ImageView(shopImage);
    loginPane.add(shopImageView,1,0);
    shopImageView.setFitHeight(300);
    shopImageView.setFitWidth(330);
    
    Text alert5=new Text();
    alert5.setLayoutX(145);
    alert5.setLayoutY(635);
    alert5.setFont(font4);
    alert5.setFill(Color.ROSYBROWN);
    alert5.setStyle("-fx-font-size: 1.75em; ");
    loginPane.add(alert5, 1, 5);
    
    loginButton.setOnAction( e ->
    { 
    if (usernameTextField.getText().equals(admin.getUserName()) && passwordTextField.getText().equals(admin.getPassword()))  
    {
        adminStage.show();
        try
        {
        Electronics electronicsFile= new Electronics();
        Clothes clothesFile= new Clothes();
        electronicsFile.displayFile();
        clothesFile.displayFile();
        }// end of try.
        catch(Exception ex)
        {
        System.out.print(ex); 
        }// end of catch.
    }// end of if.   
    else if (usernameTextField.getText().equals(customer.getUserName()) && passwordTextField.getText().equals(customer.getPassword()))
    {
        customerStage.show();
        try
        {
        Electronics electronicsFile= new Electronics();
        Clothes clothesFile= new Clothes();
        electronicsFile.displayFile();
        clothesFile.displayFile();
        }// end of try.
        catch(Exception ex)
        {
        System.out.print(ex); 
        }// end of catch. 
    } // end of else if.   
    else 
    alert5.setText("Incorecct username or/and password :(\n                    please try again...");
    });// end of event. 
            
    Scene loginScene = new Scene (loginPane,700,800);
    Stage loginStage = new Stage();
    loginStage.setResizable(false);
    loginStage.setTitle("E-Store Management System (EMS)"); // Set the stage title 
    loginStage.setScene(loginScene); // Place the scene in the stage 
    loginStage.show(); // Display the stage
    }// end of start.     
}// end of EMS_Group_K4.