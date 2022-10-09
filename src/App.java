package oeg.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;

/**
 * JavaFX App
 */


public class App extends Application implements EventHandler<ActionEvent> {

    private Button btnRegis;
    private Button btnExit;


    public App() {
    }

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25,25,25,25));

        Text title = new Text("Silahkan Isi BIODATA");
        title.setFont(Font.font("TAHOMA",
                FontWeight.BOLD,20));
        pane.add(title,0,0,3,1);

        Label labelnama = new Label("Nama Lengkap :");
        pane.add(labelnama,0,1);

        TextField textnama = new TextField();
        pane.add(textnama,1,1);

        Label labelUmur= new Label("Umur :");
        pane.add(labelUmur,0,2);

        TextField textUmur = new TextField();
        pane.add(textUmur,1,2);

//RADIO BUTTON
        RadioButton rbPria = new RadioButton("Pria");
        rbPria.setSelected(true);

        RadioButton rbWanita = new RadioButton("Wanita");

        ToggleGroup radioGroup = new ToggleGroup();

        rbPria.setToggleGroup(radioGroup);
        rbWanita.setToggleGroup(radioGroup);

        pane.add(rbPria,0,3);
        pane.add(rbWanita,0,4);

        Label labelpekerjaan = new Label("Pekerjaan");
        pane.add(labelpekerjaan,0,5);

        ComboBox cb1 = new ComboBox();
        cb1.getItems().addAll("Mahasiswa", "Pegawai", "Wiraswasta");
        pane.add(cb1,0,6);



        btnRegis = new Button("Register");
        btnExit = new Button("Exit");
        btnExit.setOnAction(actionEvent -> stage.close());
        btnRegis.setOnAction(this);
        HBox hb = new HBox(10);
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().addAll(btnRegis,btnExit);

        pane.add(hb,1,4);

        Scene scene = new Scene(pane,350,275);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if( actionEvent.getSource() == btnRegis ) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Login Information");
            a.setHeaderText(null);
            a.setContentText("Sucess!");
            a.showAndWait();
        }
    }
}