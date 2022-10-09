package sample;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

public class AdminPage {
    static boolean answer1;
    static ArrayList<AdminData> dataAdmin = new ArrayList<>();
    static Image image;

    public static boolean display(String title, String message)  {
        answer1 = false; //diset false, agar tiap kali sign out, kondisi boolean false, jadi harus login kembali.
        DataAdmin(); //set awal2 data admin login  sebelum memulai.
        Stage stekReg = new Stage();
        VBox vbox1 = new VBox();
        image = new Image((AdminPage.class.getResourceAsStream("QRCODE.jpg")));
        ImageView imageView = new ImageView(image);
        Label lebel = new Label("this app is for Personal Use Only,"+"\n"+"if you need, please contact Us at LINE by scan the QR CODE below");
        vbox1.getChildren().add(lebel);
        vbox1.getChildren().addAll(imageView);
        vbox1.setAlignment(Pos.CENTER);
        Scene scenee = new Scene(vbox1);
        stekReg.setScene(scenee);
        stekReg.initStyle(StageStyle.UTILITY);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setOnCloseRequest(event ->{
            event.consume();
        window.close();
        });
        window.setTitle(title);

        Label labelUsername = new Label("Username :");
        TextField inputUsername = new TextField();
        Label labelPassword = new Label("Password :");
        PasswordField inputPassword = new PasswordField();
        Button loginButton = new Button("L\n"+"O\n"+"G\n"+"I\n"+"N");
        loginButton.setPrefSize(50,100);
        Hyperlink registerButton = new Hyperlink("Do not have the Account? Click here");
        registerButton.setOnAction(event -> {
            stekReg.show();

        });



        loginButton.setOnAction(event ->{
            if(dataAdmin.size() == 0)
            {
                inputUsername.clear();
                inputPassword.clear();
                answer1= false;
                ErrorInputAdmin.display("Error","Wrong Username or Password");
            }
            for(int x = 0; x < dataAdmin.size();x++) //mencoba sebanyak dataAdmin yang ada.
            {
                if(dataAdmin.get(x).getUsername().equals(inputUsername.getText()) &&
                        dataAdmin.get(x).getPassword().equals(inputPassword.getText()))
                {

                    answer1 = true; //ketika true, maka boolean akan kembali ke atas, yang kemudian di main, akan menyebabkan perpindahan scene ke admin scene
                    window.close();
                    break;
                }
                if(x == dataAdmin.size() - 1)
                {
                    inputUsername.clear();
                    inputPassword.clear();
                    answer1= false;

                    ErrorInputAdmin.display("Error","Wrong Username or Password");
                }
            }
        }
        );

        GridPane pane = new GridPane();
        GridPane.setConstraints(labelUsername,0,0);
        GridPane.setConstraints(inputUsername,1,0);
        GridPane.setConstraints(labelPassword,0,1);
        GridPane.setConstraints(inputPassword,1,1);
        GridPane.setConstraints(registerButton,0,2,2,1);
        GridPane.setConstraints(loginButton,2,0,2,3);
        pane.setVgap(9);
        pane.setHgap(9);
        pane.setPadding(new Insets(5,10,5,10));
        pane.getChildren().addAll(labelUsername,inputUsername,labelPassword,inputPassword,registerButton,loginButton);


        Scene loginScene = new Scene(pane);
        window.setScene(loginScene);
        window.showAndWait();

        return answer1;

    }
    public static void DataAdmin(){
        //cara input data admin manual
        AdminData newDataAdmin = new AdminData("a", "a");
        dataAdmin.add(newDataAdmin);
        newDataAdmin = new AdminData("petra99", "petra99");
        dataAdmin.add(newDataAdmin);
        newDataAdmin = new AdminData("evan2000", "Evan123");
        dataAdmin.add(newDataAdmin);
        newDataAdmin = new AdminData("gaby20", "gebigebi123");
        dataAdmin.add(newDataAdmin);
        newDataAdmin = new AdminData("paulus2", "paulus123");
        dataAdmin.add(newDataAdmin);
    }



}
