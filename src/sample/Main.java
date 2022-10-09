package sample;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.*;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import java.util.ArrayList;
/*
Kelompok 1
Pemesanan kopi @ cafe
535189102 Michael Yan Petra
535180150 Paulus Samotana Zalukhu
535180125 Evander Christian Dumalang
535180124 Gabriel Carvenita Triasis

*/

public class Main extends Application {

    BorderPane borderAdmin;
    TableView<DrinkList> table;
    TableView<FoodList> table2;
    HBox hboxTotalPrice;
    Stage window,stek,stek2,stek3,stek4;
    Scene scene1, scene2, scene3, scene4;
    TextField textfieldJ;
    TextField textfieldJ1;
    GridPane menuLayout2,menuLayout3;
    ScrollPane menuLayout1;
    ArrayList<DrinkList> dataDrink = new ArrayList<>();
    ArrayList<Button> DrinkButton = new ArrayList<>();
    ArrayList<FoodList> dataFood = new ArrayList<>();
    Boolean answer,answer1,answer2;

    ArrayList<Button> FoodButton = new ArrayList<>();
    StackPane sp1,sp2,sp3,spd,spf;

    String foodPointer = "0";
    String  drinkPointer = "0";
    int totalIncPointer = 0;

    int dF = 0;
    int dD = 0;
    int prodT = 0;

    int prod = 0;
    int totalOrdPointer = 0;
    Image imageDrink,imageFood;
    Label totalInc;
    Label product;
    Label totalOrd;
    Label totalPrice;
    int pointerQD = 0;
    int pointerQF = 0;
    int totalPricePointer = 0;
    int Kembalian;
    Button newOrderBtn;
    TextField getfoodnum,getfoodname,getfoodpic,getfoodprice,getdrinknum,getdrinkname,getdrinkpic,getdrinkprice;

    ComboBox<String> choiceAddProd;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    //
    public void start(Stage primaryStage) throws Exception {
        prodT +=dataFood.size()+dataDrink.size(); // sebagai perhitungan total product
        DataMakanan();  //set data awal product

        //memberi nama pada Stage Primary
        window = primaryStage;
        window.setResizable(false);
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });


        //============================================SCENE PILIH ADMIN ATAU PELANGGAN====================//
        String family = "Arial Black";
        String family1 = "Tahoma";
        String family2 = "Freestyle Script";

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        Label title = new Label("UNTAR CAFE");
        title.setFont(Font.font("TAHOMA",
                FontWeight.BOLD, 20));
        HBox hb1 = new HBox();
        hb1.setPadding(new Insets(0, 0, 10, 0));
        hb1.getChildren().add(title);


        Button btnadmin = new Button("Admin");
        VBox vb1 = new VBox();
        btnadmin.setPrefSize(200, 350);
        btnadmin.setStyle("-fx-background-color:\n" +
                "        linear-gradient(#22D6FF 0%, #5EBCD2 25%, #3D7784 75%, #69D2EA 100%),\n" +
                "        linear-gradient(#95DDED 0%, #14B7DB 25%, #3BA9C2 75%, #7DC8D9 100%),\n" +
                "        linear-gradient(#95DDED 0%, #14B7DB 25%, #3BA9C2 75%, #7DC8D9 100%),\n" +
                "        linear-gradient(#95DDED 0%, #14B7DB 25%, #3BA9C2 75%, #7DC8D9 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Tahoma\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" );
        btnadmin.setOnAction(event -> adminProgram());
        vb1.getChildren().add(btnadmin);




        Button btnpelanggan = new Button("Pelanggan");
        btnpelanggan.setPrefSize(200, 350);
        VBox vb2 = new VBox();
        vb2.getChildren().add(btnpelanggan);
        btnpelanggan.setStyle("-fx-background-color:\n" +
                "        linear-gradient(#D66D8A 0%, #DF3F6B 25%, #A42E4F 75%, #D66D8A 100%),\n" +
                "        linear-gradient(#D14E4E 0%, #D33434 25%, #D14E4E 75%, #CD5757 100%),\n" +
                "        linear-gradient(#D14E4E 0%, #D33434 25%, #D14E4E 75%, #CD5757 100%),\n" +
                "        linear-gradient(#D14E4E 0%, #D33434 25%, #D14E4E 75%, #CD5757 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Tahoma\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" );
        btnpelanggan.setOnAction(actionEvent -> changeScene2());

        hb1.setAlignment(Pos.CENTER);
        pane.setTop(hb1);
        pane.setLeft(vb1);
        pane.setRight(vb2);
        scene1 = new Scene(pane, 500, 450);

        //============================================SCENE PILIH ADMIN ATAU PELANGGAN=========ENDHERE===========//


        //============================================SCENE PELANGGAN====================//
        HBox hbox = new HBox();//Top menu

        hbox.setStyle("-fx-background-color: #3a0000");
        hbox.setPadding(new Insets(5, 5, 5, 5));
        Button btnCheckout = new Button("Check Out");
        btnCheckout.setStyle("-fx-focus-color: RED;");
        btnCheckout.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        btnCheckout.setPrefSize(150, 20);
        btnCheckout.setTextFill(Color.BLACK);
        btnCheckout.setOnAction(event -> btnCheckoutClicked());


        StackPane stack = new StackPane();//kasih tombol checkout pada pojok kanan atas
        stack.getChildren().addAll(btnCheckout);
        stack.setAlignment(Pos.CENTER_RIGHT);


        Label labelTitle = new Label("UNTAR CAFE");
        labelTitle.setFont(Font.font(family2, FontWeight.EXTRA_BOLD, 30));
        labelTitle.setTextFill(Color.WHITESMOKE);
        labelTitle.setAlignment(Pos.BASELINE_CENTER);
        StackPane.setMargin(btnCheckout, new Insets(0, 10, 0, 0));
        StackPane stack1 = new StackPane();
        stack1.getChildren().add(labelTitle);
        stack1.setAlignment(Pos.CENTER_LEFT);


        hbox.getChildren().addAll(stack1, stack);//masukin ke bagian HBOX topmenu
        HBox.setHgrow(stack, Priority.ALWAYS);


        VBox vbox = new VBox();     //left Menu
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setStyle("-fx-background-color: #3a0000");
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(15, 8, 15, 5));


        Button btnDrink = new Button("Drink");
        btnDrink.setStyle("-fx-focus-color: RED;");
        btnDrink.setFont(Font.font(family1, FontWeight.BOLD, 20));
        btnDrink.setPrefSize(95, 400);
        btnDrink.setOnAction(event -> drinkButtonClicked()); //ketika tombol Drink Besar di CLick


        Button btnFood = new Button("Food");
        btnFood.setStyle("-fx-focus-color: RED;");
        btnFood.setFont(Font.font(family1, FontWeight.EXTRA_BOLD, 20));
        btnFood.setPrefSize(95, 400);
        btnFood.setOnAction(event -> foodButtonClicked()); //ketika tombol food Besar di click

        Button btnBack = new Button("Back");
        btnBack.setStyle("-fx-focus-color: RED;");
        btnBack.setFont(Font.font(family1, FontPosture.ITALIC, 20));
        btnBack.setPrefSize(95, 95);
        btnBack.setOnAction(actionEvent ->{
            changeScene1(); //dimana button back pada pelanggan di click, akan mengganti ke menu awal
            ;});



        vbox.getChildren().addAll(btnFood, btnDrink, btnBack);

        Button btnRemove = new Button("-");
        btnRemove.setStyle("-fx-focus-color: RED;");
        btnRemove.setOnAction(event -> btnRemoveClicked());

        HBox hboxTombolTabel = new HBox();
        hboxTombolTabel.setPadding(new Insets(5, 5, 5, 5));
        hboxTombolTabel.setSpacing(5);
        hboxTombolTabel.getChildren().addAll(btnRemove);

        Button btnRemove2 = new Button("-");
        btnRemove2.setStyle("-fx-focus-color: RED;");
        btnRemove2.setOnAction(event -> btnRemove1Clicked());

        HBox hboxTombolTabel2 = new HBox();
        hboxTombolTabel2.setPadding(new Insets(5, 5, 5, 5));
        hboxTombolTabel2.setSpacing(5);
        hboxTombolTabel2.getChildren().addAll(btnRemove2);

        TableColumn<DrinkList, String> nameDColumn = new TableColumn<>("Barang");  //table kolom nama minuman
        nameDColumn.setMinWidth(200);
        nameDColumn.setCellValueFactory(new PropertyValueFactory<>("nameDrink"));

        TableColumn<DrinkList, Integer> priceDColumn = new TableColumn<>("Harga");//table kolom harga minuman
        priceDColumn.setMinWidth(100);
        priceDColumn.setCellValueFactory(new PropertyValueFactory<>("priceDrink"));

        TableColumn <DrinkList,Integer>quantityDColumn = new TableColumn("Kuantitas"); //table kolom banyak minuman
        quantityDColumn.setCellValueFactory(new PropertyValueFactory<>("quantityDrink"));



        TableColumn<FoodList, String> nameFColumn = new TableColumn<>("Barang"); //table kolom nama makanan
        nameFColumn.setMinWidth(200);
        nameFColumn.setCellValueFactory(new PropertyValueFactory<>("nameFood"));

        TableColumn<FoodList, Integer> priceFColumn = new TableColumn<>("Harga");//table kolom harga makanan
        priceFColumn.setMinWidth(100);
        priceFColumn.setCellValueFactory(new PropertyValueFactory<>("priceFood"));

        TableColumn <FoodList,Integer>quantityFColumn = new TableColumn("Kuantitas");//table kolom banyak makanan
        quantityFColumn.setCellValueFactory(new PropertyValueFactory<>("quantityFood"));


        table = new TableView<>();
        table.getColumns().addAll(nameDColumn, priceDColumn, quantityDColumn);
        table.setMaxHeight(300);
        table.setMinWidth(425);

        table2 = new TableView<>();
        table2.getColumns().addAll(nameFColumn, priceFColumn, quantityFColumn);
        table2.setMaxHeight(300);
        table2.setMinWidth(425);

        table.setStyle("-fx-focus-color: RED;");
        table2.setStyle("-fx-focus-color: RED;");

        VBox vboxRightmenu = new VBox();
        vboxRightmenu.setMaxWidth(430);
        totalPrice = new Label("Rp.0");
        newOrderBtn = new Button("NEW ORDER");
        newOrderBtn.setFont(Font.font("Tahoma", FontWeight.BOLD,15));
        newOrderBtn.setMinSize(100,50);
        newOrderBtn.setTextFill(Color.BLACK);
        newOrderBtn.setStyle("-fx-background-color: #90D57F");
        newOrderBtn.setStyle("-fx-focus-color: RED;");
        newOrderBtn.setOnAction(event -> {
            totalPrice.setText("Rp.0");
            table.getItems().clear();
            table2.getItems().clear();});
        totalPrice.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD,20));
        hboxTotalPrice = new HBox();
        hboxTotalPrice.getChildren().add(newOrderBtn);
        hboxTotalPrice.getChildren().add(totalPrice);
        hboxTotalPrice.setSpacing(50);
        hboxTotalPrice.setAlignment(Pos.CENTER_LEFT);



        vboxRightmenu.getChildren().addAll(table2, hboxTombolTabel2,table,hboxTombolTabel,hboxTotalPrice);

        //Center Menu LIST MAKANAN MINUMAN
        menuLayout3 = new GridPane();
        menuLayout3.setHgap(20);
        menuLayout3.setVgap(10);
        menuLayout3.setPadding(new Insets(5,10,5,10));
        menuLayout2 = new GridPane();
        menuLayout2.setHgap(20);
        menuLayout2.setVgap(10);
        menuLayout2.setPadding(new Insets(5,10,5,10));
        menuLayout1 = new ScrollPane();
        menuLayout1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        menuLayout1.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        menuLayout1.setOnScroll(null);

        //BORDERPANE PELANGGAN (main)
        BorderPane border = new BorderPane();


        border.setTop(hbox);
        border.setLeft(vbox);
        border.setRight(vboxRightmenu);
        border.setCenter(menuLayout1);

        scene2 = new Scene(border,1000,1000);

        //============================================SCENE PELANGGAN===================END HERE====//


        //==========================================SCENE ADMIN==========================================//

        borderAdmin = new BorderPane();
        choiceAddProd = new ComboBox<>();  //combobox untuk add Makan dan Minum
        choiceAddProd.setPromptText("Add Product");
        choiceAddProd.getItems().add("Add Drink");
        choiceAddProd.getItems().add("Add Food");
        choiceAddProd.valueProperty().addListener((obs, oldValue, newValue) ->{
          if (newValue.equals("Add Food")){  //dimana, kalau add food dipilih maka akan menjalankan mauAddMakan;
            mauAddMakan();
          }
          if (newValue.equals("Add Drink")){
              mauAddMinum();    //dimana, kalau add drink dipilih maka akan menjalankan mauAddMinum;
          }
                });


        HBox hboxAtas = new HBox();
        hboxAtas.setStyle("-fx-background-color:\n" +
                "linear-gradient(to bottom, #2193FF, #339CFF);");
        hboxAtas.setPadding(new Insets(5, 5, 5, 5));
        title = new Label("Admin Page");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        title.setTextFill(Color.WHITESMOKE);
        title.setAlignment(Pos.TOP_LEFT);
        Button btnSOAd = new Button("Sign Out");
        btnSOAd.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
        btnSOAd.setStyle("-fx-background-color: \n" +
                "    linear-gradient(to bottom, #A9D7FF, #C1E2FF);"+
                "    -fx-font-family: Helvetica;\n" +
                "    -fx-text-fill: black;\n");
        btnSOAd.setPrefSize(90,20);
        btnSOAd.setOnAction(event -> changeScene1());
        hboxAtas.setMinHeight(30);
        hboxAtas.setMaxHeight(30);
        StackPane stekpen = new StackPane();
        stekpen.getChildren().addAll(btnSOAd,choiceAddProd);
        stekpen.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setMargin(btnSOAd, new Insets(0, 10, 0, 0));
        StackPane.setMargin(choiceAddProd, new Insets(0, 120, 0, 0));




        hboxAtas.setMinHeight(50);
        hboxAtas.getChildren().addAll(title,stekpen);
        HBox.setHgrow(stekpen, Priority.ALWAYS);

        Button btnHomeAd = new Button("HOME");
        btnHomeAd.setPrefSize(100,20);
        btnHomeAd.setStyle("-fx-background-color:\n" +
                "    linear-gradient(to bottom, #f2f2f2, #d4d4d4);"+
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-weight: bold;;");
        Button btnProductAd = new Button("PRODUCTS");
        btnProductAd.setStyle("-fx-background-color:\n" +
                "    linear-gradient(to bottom, #f2f2f2, #d4d4d4);"+
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-weight: bold;;");
        btnProductAd.setPrefSize(100,20);

        HBox hbAM = new HBox();
        hbAM.setPadding(new Insets(10,10,10,10));
        hbAM.setAlignment(Pos.CENTER);
        VBox vboxKiriAdmin = new VBox();
        vboxKiriAdmin.setStyle("-fx-background-color: #d4d4d4");
        vboxKiriAdmin.setMaxWidth(100);
        vboxKiriAdmin.setPadding(new Insets(0,0,0,0));
        ScrollPane scrollPaneAdmin = new ScrollPane();
        Pane paneAdmin = new Pane();

        //Main Admin//
        //Rectangle 1//
        Rectangle rectangle1 = new Rectangle(250, 150);
        rectangle1.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop(0,Color.web("#FFD800")),
                new Stop(0.5, Color.web("#FFA301"))));
        rectangle1.setStroke(Color.web("#D0E6FA"));
        rectangle1.setArcHeight(3.5);
        rectangle1.setArcWidth(3.5);

        //== PENAMPILAN JUMLAH SELURUH PRODUK


        dF = dataFood.size();
        dD = dataDrink.size();

        prod += dataFood.size()+dataDrink.size();
        product = new Label("Total Product :"+prod+"\n"+
                "Beverage :"+dD+"\n"+
                "Food :"+dF+"\n");
        product.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        product.setTextFill(Color.WHITE);


        //Rectangle 2//
        Rectangle rectangle2 = new Rectangle(250, 150);
        rectangle2.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop(0,Color.web("#73E805")),
                new Stop(0.5, Color.web("#42DC2F"))));
        rectangle2.setStroke(Color.web("#DAFFB8"));
        rectangle2.setArcHeight(3.5);
        rectangle2.setArcWidth(3.5);

        //total seluruh jumlah seluruh order dapat dilihat disini
        totalOrd = new Label("Total Order :"+"\n"+"No Order Yet" );
        totalOrd.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        totalOrd.setTextFill(Color.WHITE);


        //Rectangle 3//
        Rectangle rectangle3 = new Rectangle(250, 150);
        rectangle3.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop(0,Color.web("#0083FF")),
                new Stop(0.5, Color.web("#3284D3"))));
        rectangle3.setStroke(Color.web("#DAFFB8"));
        rectangle3.setArcHeight(3.5);
        rectangle3.setArcWidth(3.5);


        //total pendapatan dapat dilihat disini
        totalInc = new Label("Total Income :"+"\n"+"No Income Yet");
        totalInc.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        totalInc.setTextFill(Color.WHITE);

        sp1 = new StackPane();
        sp2 = new StackPane();
        sp3 = new StackPane();

        sp1.getChildren().addAll(rectangle1,product);


        sp2.getChildren().addAll(rectangle2,totalOrd);


        sp3.getChildren().addAll(rectangle3,totalInc);


        //pemisah
        //pemisah
        hbAM.getChildren().addAll(sp1,sp2,sp3);
        hbAM.setSpacing(60);
        hbAM.setAlignment(Pos.TOP_CENTER);
        paneAdmin.getChildren().addAll(hbAM);





        scrollPaneAdmin.setContent(paneAdmin);
        borderAdmin.setTop(hboxAtas);
        borderAdmin.setCenter(scrollPaneAdmin);
        scene3 = new Scene(borderAdmin,1000,1000);
        //==========================================SCENE ADMIN=======================END HERE===================//




        //menset scene pada primary stage

        window.setScene(scene1);
        window.show();

    }

    private void foodButtonClicked() { //ketika tombol food di click, maka akan memunculkan menu2 makanan
        if(FoodButton.size() != 0)
            for(int x = 0; x < FoodButton.size();x++)
                menuLayout3.getChildren().remove(FoodButton.size() - (1 + x)); //mengclear terlebih awal array
        FoodButton.clear();
        menuLayout1.getContent();
        menuLayout1.setContent(menuLayout3);

        for (int x = 0; x < dataFood.size(); x++) {
            Button listFoodButton = new Button();
            listFoodButton.setStyle("-fx-focus-color: RED;");
            listFoodButton.setPrefHeight(175);
            listFoodButton.setPrefWidth(125);
            int finalX = x;
            listFoodButton.setOnAction(e -> {
                foodPointer = dataFood.get(finalX).numberFood;
                ListFoodButtonClicked();
            });
            imageFood = new Image(getClass().getResourceAsStream(dataFood.get(x).pathPictureFood), 125, 175, false, false);
            listFoodButton.setGraphic(new ImageView(imageFood));
            FoodButton.add(listFoodButton);
        }
        templateMakan();
    }

    private void templateMakan() {
        //letak template menu makanan  addnya ke gridpane menulayout2
        int cs = 0;
        int rs = 0;
        for(int x = 0; x < FoodButton.size();x++)
        {
            menuLayout3.add(FoodButton.get(x),cs,rs,2,2); //2 column span, 2 row span
            cs += 2;
            if(cs > 8)
            {
                rs += 4;
                cs = 0;
            }
        }
    }

    public void drinkButtonClicked(){
        if(DrinkButton.size() != 0)
            for(int x = 0; x < DrinkButton.size();x++)
                menuLayout2.getChildren().remove(DrinkButton.size() - (1 + x));
        DrinkButton.clear();
        menuLayout1.getContent();
        menuLayout1.setContent(menuLayout2);
        for (int x = 0; x < dataDrink.size(); x++) {
            Button listDrinkButton = new Button();
            listDrinkButton.setStyle("-fx-focus-color: RED;");
            listDrinkButton.setPrefHeight(175);
            listDrinkButton.setPrefWidth(125);
            int finalX = x;
            listDrinkButton.setOnAction(e -> {
                drinkPointer = dataDrink.get(finalX).numberDrink;
                ListDrinkButtonClicked();
            });
            imageDrink = new Image(getClass().getResourceAsStream(dataDrink.get(x).pathPictureDrink), 125, 175, false, false);
            listDrinkButton.setGraphic(new ImageView(imageDrink));
            DrinkButton.add(listDrinkButton);
        }
        templateDrink();
    }

    private void templateDrink() {
        //template minuman, addnya ke gridpane menulayout2
        int cs = 0,rs = 0;
        for(int x = 0; x < DrinkButton.size();x++)
        {
            menuLayout2.add(DrinkButton.get(x),cs,rs,2,2); //2 column span, 2 row span
            cs += 2;
            if(cs > 8)
            {
                rs += 4;
                cs = 0;
            }
        }
    }

    private void ListFoodButtonClicked(){   //ketika gambar makanan diklik tiap tombol, akan memanggil beberapa method dimana dia akan menambahkan ke dalam table2 dan perhitungan sebagainya
        table2.refresh();
        for(int x = 0; x < dataFood.size();x++)
        {
            if(dataFood.get(x).numberFood.equals(foodPointer))
            {
                FoodList products = new FoodList();

                stek = new Stage();
                stek.setOnCloseRequest(event -> event.consume());
                stek.initModality(Modality.APPLICATION_MODAL);
                stek.setResizable(false);
                Text teks1 = new Text("Jumlah :");
                Button btn1 = new Button("Ok");

                btn1.setStyle("-fx-focus-color: RED;");
                textfieldJ1 = new TextField();
                textfieldJ1.setStyle("-fx-focus-color: RED;");
                Pane paneQ1 = new Pane();
                VBox vq1 = new VBox();
                vq1.setAlignment(Pos.CENTER);
                vq1.getChildren().addAll(teks1,textfieldJ1,btn1);
                paneQ1.getChildren().add(vq1);
                Scene sceneQ1 = new Scene(paneQ1);
                stek.setScene(sceneQ1);
                stek.show();

                btn1.setOnAction(event -> {

                    products.setQuantityFood((Integer.parseInt(textfieldJ1.getText())));

                    textfieldJ1.clear();

                    stek.close();
                    table2.refresh();
                });
                products.setNameFood(dataFood.get(x).getNameFood());
                products.setPriceFood(dataFood.get(x).getPriceFood());
                table2.getItems().add(products);
                table2.refresh();
            }


        }
    }

    private void ListDrinkButtonClicked(){  //ketika gambar minuman diklik tiap tombol, akan memanggil beberapa method dimana dia akan menambahkan ke dalam table dan perhitungan sebagainya
        table.refresh();
        for(int x = 0; x < dataDrink.size();x++)
        {
            if(dataDrink.get(x).numberDrink.equals(drinkPointer))
            {
                DrinkList product = new DrinkList();
                stek = new Stage();
                stek.setOnCloseRequest(event -> event.consume());
                stek.setResizable(false);
                stek.initModality(Modality.APPLICATION_MODAL);
                Text teks = new Text("Jumlah :");
                Button btn = new Button("Ok");
                btn.setStyle("-fx-focus-color: RED;");
                textfieldJ = new TextField();
                textfieldJ.setStyle("-fx-focus-color: RED;");
                Pane paneQ = new Pane();
                VBox vq = new VBox();
                vq.setAlignment(Pos.CENTER);
                vq.getChildren().addAll(teks,textfieldJ,btn);
                paneQ.getChildren().add(vq);
                Scene sceneQ = new Scene(paneQ);
                stek.setScene(sceneQ);
                stek.show();

                btn.setOnAction(event -> {

                    product.setQuantityDrink((Integer.parseInt(textfieldJ.getText())));

                    textfieldJ.clear();

                    stek.close();
                    table.refresh();
                });

                product.setNameDrink(dataDrink.get(x).getNameDrink());
                product.setPriceDrink(dataDrink.get(x).getPriceDrink());
                table.getItems().add(product);
                table.refresh();

            }
        }
    }

    private void changeScene1() { //untuk mengganti ke menu awal pertama kali run


        window.setMaximized(false);
        window.setHeight(500);
        window.setWidth(450);
        window.setResizable(false);
        window.setScene(scene1);
        window.centerOnScreen();

    }

    private void changeScene2() {  //menu pelanggan
        window.setResizable(true);
        window.setScene(scene2);

        window.setMaximized(true);


    }

    public void btnCheckoutClicked(){  //kondisi pada saat buton checkout di click
        int total = 0;
        int total1 = 0;
        int p2 = 1;

        for(int i = 0; i<table.getItems().size(); i++){
            total += Integer.valueOf(String.valueOf(table.getColumns().get(1).getCellObservableValue(i).getValue()))* //menghitung pada colom harga makan

                    Integer.valueOf(String.valueOf(table.getColumns().get(2).getCellObservableValue(i).getValue()));    //dikali kuantitas barang

        }
        for(int i = 0; i<table2.getItems().size(); i++){
            total1 += Integer.valueOf(String.valueOf(table2.getColumns().get(1).getCellObservableValue(i).getValue()))* //menghitung kolom harga minum
                    Integer.valueOf(String.valueOf(table2.getColumns().get(2).getCellObservableValue(i).getValue())); //dikali kuantitas barang

        }
        totalPricePointer = total+total1; //total dari kedua tabel (table,table2)
        totalPrice.setText("Rp."+totalPricePointer+",00");

        answer = ConfirmCheckOut.display("", "");
        if(answer == true){


            totalOrdPointer = totalOrdPointer+p2;

            totalIncPointer += totalPricePointer;


            totalOrd.setText("Total Order :"+"\n"+String.valueOf(totalOrdPointer)+" Order"); //mengupdate jumlah order pada menu admin;
            totalInc.setText("Total Income :"+"\n"+"Rp."+totalIncPointer+",00");  //mengupdate total income pada menu admin

            //refresh kembali table
            table.refresh();
            table2.refresh();
            cashierMode();

        }
        else {

        }

    }

    public void btnRemoveClicked(){  //method button remove dibawah table, akan clear table
        ObservableList<DrinkList> productSelected1, allProduct1;
        allProduct1 = table.getItems();
        productSelected1 = table.getSelectionModel().getSelectedItems();
        productSelected1.forEach(allProduct1::remove);


    }

    public void btnRemove1Clicked(){ //method button remove dibawah table2, akan clear table 2
        ObservableList<FoodList> productSelected, allProduct;
        allProduct = table2.getItems();
        productSelected = table2.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProduct::remove);
    }

    private void closeProgram(){
        answer1 = CloseBox.display("Close Box", "Are you sure?");
        if(answer1)
            window.close();
    }

    public void mauAddMakan(){ //method menambah array FoodList



        stek2 = new Stage();
        Label foodnum = new Label("number : ");
        Label foodname = new Label("Food Name : ");

        Label foodpicpath = new Label("Food pic name (.jpg): ");
        Label foodprice = new Label("Food Price : Rp.");
        getfoodnum = new TextField();
        getfoodname = new TextField();
        getfoodpic = new TextField();
        getfoodprice = new TextField();


        GridPane gridPaneF = new GridPane();
        gridPaneF.add(foodnum,0,0);
        gridPaneF.add(getfoodnum,1,0);
        gridPaneF.add(foodname,0,1);
        gridPaneF.add(getfoodname,1,1);
        gridPaneF.add(foodpicpath,0,2);
        gridPaneF.add(getfoodpic,1,2);
        gridPaneF.add(foodprice,0,3);
        gridPaneF.add(getfoodprice,1,3);
        Button btnaddF = new Button("add");
        gridPaneF.add(btnaddF,0,4);

        btnaddF.setOnAction(event -> {
            addMakanan();
            getfoodpic.clear();
            getfoodprice.clear();
            getfoodname.clear();
            getfoodnum.clear();



        });


        Scene sceneaf = new Scene(gridPaneF);
        stek2.setScene(sceneaf);
        stek2.show();



    }

    public void mauAddMinum(){

        stek2 = new Stage();
        Label drinknum = new Label("number : ");
        Label drinkname = new Label("drink Name : ");
        Label drinkpicpath = new Label("drink pic name (.jpg): ");
        Label drinkprice = new Label("drink price : Rp.");
        getdrinknum = new TextField();
        getdrinkname = new TextField();
        getdrinkpic = new TextField();
        getdrinkprice = new TextField();

        GridPane gridPaneD = new GridPane();
        gridPaneD.add(drinknum,0,0);
        gridPaneD.add(getdrinknum,1,0);
        gridPaneD.add(drinkname,0,1);
        gridPaneD.add(getdrinkname,1,1);
        gridPaneD.add(drinkpicpath,0,2);
        gridPaneD.add(getdrinkpic,1,2);
        gridPaneD.add(drinkprice,0,3);
        gridPaneD.add(getdrinkprice,1,3);
        Button btnaddD = new Button("add");
        gridPaneD.add(btnaddD,0,4);
        btnaddD.setOnAction(event -> {
            addMinum();
            getdrinkname.clear();
            getdrinknum.clear();
            getdrinkpic.clear();
            getdrinkprice.clear();



        });


        Scene sceneaD = new Scene(gridPaneD);
        stek2.setScene(sceneaD);
        stek2.show();




    }

    public void addMakanan(){

        FoodList newDataFoodx = new FoodList();
        newDataFoodx.setNumberFood(getfoodnum.getText());
        newDataFoodx.setNameFood(getfoodname.getText());
        newDataFoodx.setPathPictureFood(getfoodpic.getText());
        newDataFoodx.setPriceFood(getfoodprice.getText());
        newDataFoodx.setQuantityFood(pointerQF);




        dataFood.add(newDataFoodx);

        updateBarang();

    }

    public void addMinum(){

        DrinkList newDataFoody = new DrinkList();
        newDataFoody.setNumberDrink(getdrinknum.getText());
        newDataFoody.setNameDrink(getdrinkname.getText());
        newDataFoody.setPathPictureDrink(getdrinkpic.getText());
        newDataFoody.setPriceDrink(getdrinkprice.getText());
        newDataFoody.setQuantityDrink(pointerQD);

        dataDrink.add(newDataFoody);
        updateBarang();
    }

    private void updateBarang(){
        int totalProduct = 0;
        totalProduct += dataDrink.size()+dataFood.size();
        product.setText("Total Product :"+totalProduct+"\n"+
                "Beverage :"+dataDrink.size()+"\n"+
                "Food :"+dataFood.size()+"\n");
        product.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        product.setTextFill(Color.WHITE);
    }

    public void DataMakanan() throws FileNotFoundException {
        //cara input data account manual
        FoodList listFood = new FoodList("1","Sweet Chicken Waffle","SCW.jpg","50000",pointerQF) ;
        dataFood.add(listFood);
        listFood = new FoodList("2","Bagel n Egg Melts","BNEM.jpg","55000",pointerQF) ;
        dataFood.add(listFood);
        listFood = new FoodList("3","Tuna Sandwich","TS.jpg","46000",pointerQF) ;
        dataFood.add(listFood);


        //data minuman
        DrinkList listDrink = new DrinkList("1","Iced White Chocolate Mocha","ICWM.jpg","35000",pointerQD );
        dataDrink.add(listDrink);
        listDrink = new DrinkList("2","Green Tea Latte","GTL.jpg","30000",pointerQD ) ;
        dataDrink.add(listDrink);
        listDrink = new DrinkList("3","Caffeine-Free Herbal Tea","CFHT.jpg","30000",pointerQD );
        dataDrink.add(listDrink);
        listDrink = new DrinkList("4","Asian Dolce Latte","ADL.jpg","37000",pointerQD );
        dataDrink.add(listDrink);
        listDrink = new DrinkList("5","Raspberry Black Currant","RBC.jpg","34000",pointerQD );
        dataDrink.add(listDrink);
        listDrink = new DrinkList("6","Caffe Americano","CA.jpg","38000",pointerQD );
        dataDrink.add(listDrink);
        listDrink = new DrinkList("7","Caramel Macchiato","CM.jpg","35000",pointerQD );
        dataDrink.add(listDrink);
        listDrink = new DrinkList("8","Signature Hot Chocolate","SHC.jpg","45000",pointerQD );
        dataDrink.add(listDrink);
    }

    private void adminProgram(){  //method terjadi login,
        answer2 = AdminPage.display("Login Page", "Please input username and password");
        if(answer2){  //dimana true, akan masuk ke dalam admin scene.
            window.setScene(scene3);
            window.setMaximized(true);
            window.setResizable(true);
        }

    }

    public void cashierMode(){ //metod menghitung harga total, dan kembalian yang dibayar
        stek3 = new Stage();

        stek3.setTitle("Kembalian");
        Label texth = new Label("Harga: ");
        Label textb = new Label("Bayar : ");
        Label textk = new Label("Kembalian : ");
        Button btnKurang = new Button("Calculate");
        btnKurang.setStyle("-fx-focus-color: RED;");
        GridPane gpBayar = new GridPane();
        gpBayar.setVgap(5);

        gpBayar.setPadding(new Insets(5,5,5,5));
        Label labelKembalian = new Label("");
        labelKembalian.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD,20));
        TextField textFieldBayar = new TextField();
        textFieldBayar.setStyle("-fx-focus-color: RED;");
        gpBayar.add(texth,0,0);
        gpBayar.add(totalPrice,1,0);
        gpBayar.add(textb,0,1);
        gpBayar.add(textFieldBayar,1,1);
        gpBayar.add(btnKurang,0,2);
        gpBayar.add(textk,0,3);
        gpBayar.add(labelKembalian,1,3);


        btnKurang.setOnAction(event ->{
            Kembalian = Integer.parseInt(textFieldBayar.getText())-totalPricePointer;
            labelKembalian.setText("Rp."+String.valueOf(Kembalian)+",00");
            ;

        });

        Scene scene4 = new Scene(gpBayar); //windows untuk kalkulasi kembalian
        stek3.setScene(scene4);
        stek3.initModality(Modality.APPLICATION_MODAL);
        stek3.setResizable(false);
        stek3.show();
        stek3.setOnCloseRequest(event -> {
                    hboxTotalPrice.getChildren().addAll(totalPrice);
                    stek3.close();

                }
        );




    }


}




