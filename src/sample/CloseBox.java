package sample;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.util.Stack;

public class CloseBox {
    static boolean answer;

        public static boolean display(String title, String message)
        {
            Stage window = new Stage();
            window.setOnCloseRequest(event -> event.consume());
            window.setResizable(false);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Close Box");
            window.setMaxHeight(250);
            window.setMaxWidth(250);
            window.setMinHeight(250);
            window.setMinWidth(250);
            Label label1 = new Label("Are you sure you want to exit?");
            Button cancelButton = new Button("Cancel");
            Button confirmButton = new Button("confirm");


            confirmButton.setOnAction(event ->{
                answer = true;
                window.close();
            });

            cancelButton.setOnAction(event ->{
                answer = false;
                window.close();
            });

            VBox layout = new VBox(20);

            layout.getChildren().addAll(label1,cancelButton,confirmButton);
            layout.setAlignment(Pos.CENTER);

            Scene closeScene = new Scene(layout);
            window.setScene(closeScene);
            window.showAndWait();

            return answer;

        }
    }
