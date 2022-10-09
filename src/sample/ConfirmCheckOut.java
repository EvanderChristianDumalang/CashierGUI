package sample;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmCheckOut {
    static boolean answer;

        public static boolean display(String title, String message)
        {
            Stage window = new Stage();
            window.setOnCloseRequest(event -> event.consume());
            window.setResizable(false);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("CONFIRM CHECKOUT");
            window.setResizable(false);
            window.setOnCloseRequest(Event::consume);
            window.setMinHeight(300);
            window.setMinWidth(250);
            Label label1 = new Label("PLEASE ENSURE THE CHECKOUT IS CORRECT");

            label1.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            label1.setTextFill(Color.RED);

            Button cancelButton = new Button("CANCEL");
            cancelButton.setStyle("-fx-focus-color: RED;");
            Button confirmButton = new Button("CLICK IF ALREADY PAID");
            confirmButton.setStyle("-fx-focus-color: RED;");



            confirmButton.setOnAction(event ->{
                answer = true;
                window.close();  //ketika true, maka akan lanjut ke main, kemudian menjalankan perintah penambahan income dan order, lalu calculate
            });

            cancelButton.setOnAction(event ->{
                answer = false; //ketika false, tidak terjadi apa2.
                window.close();
            });

            VBox layout = new VBox(20);

            layout.getChildren().addAll(label1,confirmButton,cancelButton);
            layout.setAlignment(Pos.CENTER);

            Scene closeScene = new Scene(layout);
            window.setScene(closeScene);
            window.showAndWait();

            return answer;

        }




    }
