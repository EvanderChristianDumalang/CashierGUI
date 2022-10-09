package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorInputAdmin {
    public static void display(String title, String Message){

        Stage stageError = new Stage();
        stageError.initModality(Modality.APPLICATION_MODAL);
        Label messageL = new Label();
        messageL.setText(Message);

        VBox vboxError = new VBox();
        vboxError.setAlignment(Pos.CENTER);
        Button closeErrorBtn = new Button("Close");
        closeErrorBtn.setPrefSize(50,20);
        vboxError.setPadding(new Insets(10,5,10,5));

        closeErrorBtn.setOnAction(event -> stageError.close());
        vboxError.getChildren().addAll(messageL,closeErrorBtn);
        Scene sceneError = new Scene(vboxError);

        stageError.setScene(sceneError);
        stageError.setMinHeight(100);
        stageError.setMinWidth(50);

        stageError.show();

    }

}
